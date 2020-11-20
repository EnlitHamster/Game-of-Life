package game.life.generator

import game.life.goLDSL.Model
import game.life.goLDSL.Operator
import game.life.goLDSL.Outcome
import game.life.goLDSL.RuleCompare
import game.life.goLDSL.RuleOtherwise

class TextGenerator {
	
	def static toText(Model model) '''
	Rules:
	«FOR rule : model.rules»
	«"\t"»«genOutcome(rule.outcome)»«"\t"»=«"\t"»«genCondition(rule.condition)»
	«ENDFOR»'''
	
	def static CharSequence genOutcome(Outcome o) {
		switch (o) {
			case Outcome::LIVE: return '''Live«"\t\t"»'''
			case Outcome::DIE: return '''Die«"\t\t\t"»'''
			case Outcome::BECOMEALIVE: return '''Becom alive«"\t"»'''
		}
	}
	
	def static dispatch genCondition(RuleOtherwise r) '''otherwise'''
	
	def static dispatch genCondition(RuleCompare r) '''#neighbours «genOp(r.op)» «r.amount»'''
	
	def static CharSequence genOp(Operator o) {
		switch (o) {
			case Operator::LT: return '''<'''
			case Operator::EQ: return '''='''
			case Operator::GT: return '''>'''
		}
	}
	
}