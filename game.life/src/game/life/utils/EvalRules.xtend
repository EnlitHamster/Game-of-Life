package game.life.utils

import game.life.goLDSL.EvaluationRule
import game.life.goLDSL.Operator
import game.life.goLDSL.Outcome
import game.life.goLDSL.RuleCompare
import game.life.goLDSL.RuleConditionLevel1
import game.life.goLDSL.RuleConj
import game.life.goLDSL.RuleOtherwise
import java.util.List

class EvalRules {
	
	interface Cond {
		def boolean apply(int n)
	}
	
	static class Rules {
		val List<RuleConditionLevel1> cDie;
		val List<RuleConditionLevel1> cLive;
		val List<RuleConditionLevel1> cBecome;
		
		new(List<RuleConditionLevel1> cd, 
				  List<RuleConditionLevel1> cl, 
				  List<RuleConditionLevel1> cb) {
			cDie = cd;
			cLive = cl;
			cBecome = cb;
		}
		
		def die() {return cDie}
		def live() {return cLive}
		def become() {return cBecome}
	}
	
	def static List<Cond> genPredicate(RuleConj rc) {
		val List<Cond> predicate = newArrayList();
		for (comp : rc.conj.compares) predicate.add(toCond(comp))
		return predicate;
	}
	
	def static toCond(RuleCompare rc) {
		val am = rc.amount
		
		switch (rc.op) {
			case Operator::LT: return [int n | n < am]
			case Operator::EQ: return [int n | n == am]
			case Operator::GT: return [int n | n > am]	
		}	
	}
	
	def static genEvalRules(List<EvaluationRule> rules) {
		var List<RuleConditionLevel1> cDie = newArrayList()
		var List<RuleConditionLevel1> cLive = newArrayList()
		var List<RuleConditionLevel1> cBecome = newArrayList()
		
		for (r : rules) {
			val conj = genConj(r.condition)
			if (r.outcome == Outcome::DIE) {if (conj === null) cDie = null else cDie.add(conj)}
			else if (r.outcome == Outcome::LIVE) {if (conj === null) cLive = null else cLive.add(conj)}
			else {if (conj === null) cBecome = null else cBecome.add(conj)}
		}
		
		return new Rules(cDie, cLive, cBecome);
	}
	
	def static dispatch genConj(RuleConj r) {return r.conj}
	
	def static dispatch genConj(RuleOtherwise r) {return null}
	
}