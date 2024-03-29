package game.life.validation

import game.life.generator.RolGenerator
import game.life.goLDSL.Coord
import game.life.goLDSL.EvaluationRule
import game.life.goLDSL.GoLDSLPackage.Literals
import game.life.goLDSL.GridRule
import game.life.goLDSL.Invert
import game.life.goLDSL.Model
import game.life.goLDSL.Operator
import game.life.goLDSL.Outcome
import game.life.goLDSL.RuleCompare
import game.life.goLDSL.RuleCondition
import game.life.goLDSL.RuleConj
import game.life.goLDSL.RuleOtherwise
import game.life.utils.EvalRules
import game.life.utils.EvalRules.Cond
import java.util.List
import org.eclipse.xtext.validation.Check

class GoLDSLValidator extends AbstractGoLDSLValidator {
	
	@Check
	def checkOutOfBoundEvalRule(RuleCompare rc) {
		if (rc.amount < 0 || rc.amount > 8) {
			if (rc.amount > 8 && rc.op == Operator.LT)
				warning("This condition is always satisfied.\nThis means it will always be applied", null)
			else if (rc.amount < 0 && rc.op == Operator.GT)
				warning("This condition is always satisfied.\nThis means it will always be applied", null)
			else 
				error("The number of neighbors must be in a range from 0 to 8.", null)		
		}
	}
	
	@Check
	def checkUselessEvalRule(RuleConj rc) {
		val op = rc.conj.compares.get(0).op
		if (rc.conj.compares.size() > 1 || op != Operator::EQ) {
			val conds = EvalRules.genPredicate(rc)		
			val boolean[] sat = applyConds(conds)
			
			if (!sat.contains(true))
				warning("This condition is not satisfiable and will have no side effects.\nThis means this condition can be safely removed", null)
			else {
					var nSat = 0
					var lastSat = -1
					for (var i = 0; i < sat.length; i++) if (sat.get(i)) {nSat++; lastSat = i}
					if (nSat == 1)
						info("This condition is equivalent to \"neighbors equal to " + lastSat + "\"", null)
			}
		}
	}
	
	@Check
	def checkEvalRulesCover(Model m) {		
		var boolean[] cover = #[false, false, false, false, false, false, false, false, false]
		var hasOtherwise = false;
		val List<EvaluationRule> rules = newArrayList();
		
		for (var i = 0; i < m.rules.length && (!hasOtherwise || cover.contains(false)); i++) {
			val RuleCondition c = m.rules.get(i).condition
			if (c instanceof RuleOtherwise) {
				hasOtherwise = true;
			} else if (m.rules.get(i).outcome != Outcome::BECOMEALIVE) {
				rules.add(m.rules.get(i))
				val sat = applyConds(EvalRules.genPredicate(c as RuleConj))
				for (var j = 0; j < cover.length; j++)
					if (!cover.get(j)) cover.set(j, sat.get(j))
			}
		}
		
		if (!hasOtherwise && cover.contains(false)) {
			var String missingVals = "";
			for (var i = 0; i < cover.length; i++)
				if (!cover.get(i)) missingVals += i + ", "
			missingVals = "(" + missingVals.substring(0, missingVals.length - 2) + ")";
			for (r : rules)
				error( "The Live and die rules do not cover all possible neighbor values.\n
						The missing values are: " + missingVals + "\n
						Suggestion: use otherwise on one of those outcomes to make it the default one.", r, null, -1)
		}
	}
	
	@Check
	def checkBecomeAliveOtherwise(EvaluationRule er) {
		if (er.outcome == Outcome::BECOMEALIVE && er.condition instanceof RuleOtherwise)
			warning("This way cells will always become alive", er, null, -1)
	}
	
	@Check
	def checkMultipleOtherwiseLiveDie(Model m) {
		val List<EvaluationRule> rules = newArrayList();
		
		for (r : m.rules)
			if ((r.outcome == Outcome::LIVE || r.outcome == Outcome::DIE) &&
				(r.condition instanceof RuleOtherwise))
				rules.add(r)
				
		if (rules.size() > 1)
			for (r : rules)
				error("Multiple otherwises on live/die. Please define only one.", r, null, -1)
	}  
	
	@Check
	def checkGridCoordsValid(Coord c) {
		if (c.x <= 0 || c.x > RolGenerator.GRID_SIZE)
			error("Value must be between 1 and " + RolGenerator.GRID_SIZE, Literals.COORD__X)
		if (c.y <= 0 || c.y > RolGenerator.GRID_SIZE)
			error("Value must be between 1 and " + RolGenerator.GRID_SIZE, Literals.COORD__Y)
	}

    @Check
    def checkGridDoubleInvert(Model model) {
       var List<GridRule> rules = model.init
        for (var i = 0; i < rules.length - 1; i++)
            if (rules.get(i) instanceof Invert &&
                rules.get(i+1) instanceof Invert) {
                    info("Consecutive inverts have no side effects.\nThis means they can be safely removed", rules.get(i), null, -1)
                    info("Consecutive inverts have no side effects.\nThis means they can be safely removed", rules.get(i+1), null, -1)
                }
    }
	
	def static applyConds(List<Cond> conds) {
		var sat = #[true, true, true, true, true, true, true, true, true]
		for (cond : conds) sat = applyCond(sat, cond)
		return sat
	}
	
	def static applyCond(boolean[] sat, Cond cond) {
		var sat1 = sat;
		for (var i = 0; i < sat1.length; i++)
			if (sat1.get(i)) sat1.set(i, cond.apply(i))
		return sat1
	}
	
}