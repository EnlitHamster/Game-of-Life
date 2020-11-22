package game.life.generator

import game.life.goLDSL.Coord
import game.life.goLDSL.EvaluationRule
import game.life.goLDSL.GridRule
import game.life.goLDSL.Invert
import game.life.goLDSL.Model
import game.life.goLDSL.Operator
import game.life.goLDSL.Pattern
import game.life.goLDSL.RuleCompare
import game.life.goLDSL.RuleConditionLevel1
import game.life.goLDSL.State
import game.life.utils.EvalRules
import game.life.utils.EvalRules.Rules
import game.life.utils.Predicate
import game.life.utils.Predicate.Stmt
import java.util.Iterator
import java.util.List
import java.util.Random

class TextGenerator {
	
	public static val GRID_SIZE = 40;
	
	def static toText(Model model) '''
	Rules:
	«genRules(model.rules)»
	Grid:
	«genGrid(model.rand, model.init)»'''
	
	def static CharSequence genGrid(boolean rand, List<GridRule> rules) {
		var matrix = Array2D.boolArray(GRID_SIZE, GRID_SIZE)
		val random = new Random();
		
		for (var i = 0; i < GRID_SIZE; i++)
			for (var j = 0; j < GRID_SIZE; j++)
				matrix.get(i).set(j, rand ? random.nextBoolean() : false);		
				
		for (rule : rules) applyRule(matrix, rule)
				
		return '''
		«FOR array : matrix»
		«FOR b : array SEPARATOR " " AFTER "\n"»«b ? "X" : "O"»«ENDFOR»
		«ENDFOR»'''
	}
	
	def static dispatch applyRule(boolean[][] matrix, Pattern rule) {
		val bVal = rule.state == State.ALIVE;
		val List<Stmt> predicate = Predicate.genPredicate(rule.condition.stmts)
		
		for (var i = 0; i < matrix.length; i++)
			for (var j = 0; j < matrix.get(i).length; j++) {
				var Iterator<Stmt> iPred = predicate.iterator();
				var boolean check = true;
				while (check && iPred.hasNext())
					check = iPred.next().apply(j, i)
				if (check) matrix.get(i).set(j, bVal)
			}
	}
	
	def static dispatch applyRule(boolean[][] matrix, Coord rule) {
		matrix.get(rule.y - 1).set(rule.x - 1, rule.state == State.ALIVE)
	}
	
	def static dispatch applyRule(boolean[][] matrix, Invert rule) {
		for (var i = 0; i < GRID_SIZE; i++)
			for (var j = 0; j < GRID_SIZE; j++)
				matrix.get(i).set(j, !matrix.get(i).get(j))
	}
	
	def static CharSequence genRules(List<EvaluationRule> rules) {
		val Rules conds = EvalRules.genEvalRules(rules);
		
		System.out.println(conds.die() + " " + conds.live() + " " + conds.become())
		
		return '''
		«"\t"»Die«"\t\t\t\t"»if«"\t"»«IF conds.die() !== null»«genConditions(conds.die())»«ELSE»otherwise«ENDIF»
		«"\t"»Live«"\t\t\t"»if«"\t"»«IF conds.live() !== null»«genConditions(conds.live())»«ELSE»otherwise«ENDIF»
		«"\t"»Become alive«"\t"»if«"\t"»«IF conds.become() !== null»«genConditions(conds.become())»«ELSE»otherwise«ENDIF»
		'''
	}
	
	def static genConditions(List<RuleConditionLevel1> conditions) '''«FOR c : conditions SEPARATOR " or "»«genCondition(c)»«ENDFOR»'''
	
	def static genCondition(RuleConditionLevel1 r) '''(«FOR c : r.compares SEPARATOR " and "»«genCompare(c)»«ENDFOR»)'''
	
	def static genCompare(RuleCompare r) '''#neighbours «genOp(r.op)» «r.amount»'''
	
	def static CharSequence genOp(Operator o) {
		switch (o) {
			case Operator::LT: return '''<'''
			case Operator::EQ: return '''='''
			case Operator::GT: return '''>'''
		}
	}
	
}