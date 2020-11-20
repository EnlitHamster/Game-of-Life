package gol.tasks.generator

import gol.tasks.taskDSL.EvaluationRule
import gol.tasks.taskDSL.Model
import gol.tasks.taskDSL.Operator
import gol.tasks.taskDSL.Outcome
import gol.tasks.taskDSL.RuleCompare
import gol.tasks.taskDSL.RuleOtherwise
import org.eclipse.emf.common.util.EList

class TextGenerator {
	
	def static toText(Model model) '''
	Rules:
	«genRules(model.rules)»'''
	
	def static genRules(EList<EvaluationRule> rules) '''
	«FOR r : rules»
		«genOutcome(r.outcome)» <- «genCondition(r.condition)»
	«ENDFOR»'''
	
	def static genOutcome(Outcome oc) {
		switch (oc) {
			case Outcome::LIVE:			return '''Live'''
			case Outcome::DIE:			return '''Die'''
			case Outcome::BECOMEALIVE:	return '''Become alive'''
		}
	}
	
	def static dispatch genCondition(RuleOtherwise r) '''otherwise'''
	
	def static dispatch genCondition(RuleCompare r) 
	'''#neighbours «genOp(r.op)» «r.amount»'''
	
	def static genOp(Operator op) {
		switch (op) {
			case Operator::LT: return '''<'''
			case Operator::LQ: return '''<='''
			case Operator::EQ: return '''='''
			case Operator::GQ: return '''>'''
			case Operator::GT: return '''>='''
		}		
	}
	
}