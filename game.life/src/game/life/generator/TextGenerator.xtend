package game.life.generator

import game.life.goLDSL.EvaluationRule
import game.life.goLDSL.Model
import game.life.goLDSL.Operator
import game.life.goLDSL.Outcome
import game.life.goLDSL.RuleCompare
import game.life.goLDSL.RuleConditionLevel1
import game.life.goLDSL.RuleConj
import game.life.goLDSL.RuleOtherwise
import java.util.List

class TextGenerator {
	
	def static toText(Model model) '''
	Rules:
	«genRules(model.rules)»'''
	
	def static CharSequence genRules(List<EvaluationRule> rules) {
		var List<RuleConditionLevel1> cDie = newArrayList()
		var List<RuleConditionLevel1> cLive = newArrayList()
		var List<RuleConditionLevel1> cBecome = newArrayList()
		
		for (r : rules) {
			val conj = genConj(r.condition)
			if (r.outcome == Outcome::DIE) {if (conj === null) cDie = null else cDie.add(conj)}
			else if (r.outcome == Outcome::LIVE) {if (conj === null) cLive = null else cLive.add(conj)}
			else {if (conj === null) cBecome = null else cBecome.add(conj)}
		}
		
		return '''
		«"\t"»Die«"\t\t\t\t"»if«"\t"»«IF cDie !== null»«genConditions(cDie)»«ELSE»otherwise«ENDIF»
		«"\t"»Live«"\t\t\t"»if«"\t"»«IF cLive !== null»«genConditions(cLive)»«ELSE»otherwise«ENDIF»
		«"\t"»Become alive«"\t"»if«"\t"»«IF cBecome !== null»«genConditions(cBecome)»«ELSE»otherwise«ENDIF»
		'''
	}
	
	def static dispatch genConj(RuleConj r) {return r.conj}
	
	def static dispatch genConj(RuleOtherwise r) {return null}
	
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