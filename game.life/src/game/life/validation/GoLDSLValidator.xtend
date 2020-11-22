package game.life.validation

import game.life.goLDSL.Model
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
		if (rc.amount < 0 || rc.amount > 8)
			error("The number of neighbors must be in a range from 0 to 8.", null)
	}
	
	@Check
	def checkUselessEvalRule(RuleConj rc) {
		val conds = EvalRules.genPredicate(rc)		
		val sat = applyConds(conds)
		
		if (!sat.contains(true))
			warning("This condition is not satisfiable and will have no side effects.\nThis means this condition can be safely removed", null)
	}
	
	@Check
	def checkEvalRulesCover(Model m) {		
		var boolean[] cover = #[false, false, false, false, false, false, false, false, false]
		var hasOtherwise = false;
		
		for (var i = 0; i < m.rules.length && (!hasOtherwise || cover.contains(false)); i++) {
			val RuleCondition c = m.rules.get(i).condition
			if (c instanceof RuleOtherwise) {
				hasOtherwise = true;
			} else {
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
			error( "The rules do not cover all possibilities.\n
					The missing values are: " + missingVals + "\n
					Suggestion: use otherwise on one of the outcomes to make it the default one.", null)
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