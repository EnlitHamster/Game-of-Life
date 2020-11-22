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

class RolGenerator {
	
		
	def static toCode(Model model) '''
	package game.life;
	
		import java.awt.Point;
		import java.util.ArrayList;
	
		public class RulesOfLife {
			public static void computeSurvivors(boolean[][] gameBoard, ArrayList<Point> survivingCells, ArrayList<Point> dieingCells) {
	        	// Iterate through the array, follow game of life rules
	       	 for (int i=1; i<gameBoard.length-1; i++) {
	            for (int j=1; j<gameBoard[0].length-1; j++) {
	                int surrounding = 0;
	                if (gameBoard[i-1][j-1]) { surrounding++; }
	                if (gameBoard[i-1][j])   { surrounding++; }
	                if (gameBoard[i-1][j+1]) { surrounding++; }
	                if (gameBoard[i][j-1])   { surrounding++; }
	                if (gameBoard[i][j+1])   { surrounding++; }
	                if (gameBoard[i+1][j-1]) { surrounding++; }
	                if (gameBoard[i+1][j])   { surrounding++; }
	                if (gameBoard[i+1][j+1]) { surrounding++; }
	«genRules(model.rules)»
	            }
	        }
	
		}
			public static ArrayList<Point> initializeGrid() {
	«genGrid(model.rules)»
			}
	
	}'''
	
	def static CharSequence genRules(List<EvaluationRule> rules) {
		var List<RuleConditionLevel1> cDie = newArrayList()
		var List<RuleConditionLevel1> cLive = newArrayList()
		var List<RuleConditionLevel1> cBecome = newArrayList()
		var String otherwise = ""
		
		for (r : rules) {
			val conj = genConj(r.condition)
			if (r.outcome == Outcome::DIE) {if (conj === null) cDie = null else cDie.add(conj)}
			else if (r.outcome == Outcome::LIVE) {if (conj === null) cLive = null else cLive.add(conj)}
			else {if (conj === null) cBecome = null else cBecome.add(conj)}
		}
		
		
		return '''
		
		«IF cDie !== null»
			«"\t\t if ((gameBoard[i][j]) &&"»«genConditions(cDie)»«") {\n"»
			«"\t\t\t dieingCells.add(new Point(i-1,j-1)); \n"»
			«"\t\t}"»
		«ELSE»
			«otherwise = "if (gameBoard[i][j]) {
			 dieingCells.add(new Point(i-1,j-1));
				}"»
		«ENDIF»
		
		«IF cLive !== null»
			«"\t\t else if ((gameBoard[i][j]) &&"»«genConditions(cLive)»«") {\n"»
			«"\t\t\t  survivingCells.add(new Point(i-1,j-1));\n "»
			«"\t\t}"»
		«ELSE»
			«otherwise = "if (gameBoard[i][j]) {
						 survivingCells.add(new Point(i-1,j-1));
							}"»
		«ENDIF»
		
		«IF cBecome !== null»
			«"\t\t else if ((!gameBoard[i][j]) &&"»«genConditions(cBecome)»«") {\n"»
			«"\t\t\t survivingCells.add(new Point(i-1,j-1));\n"»
			«"\t\t}"»
		«ELSE»
			«otherwise = "else if (!gameBoard[i][j]) {
						 survivingCells.add(new Point(i-1,j-1));
							}"»
		«ENDIF»
		«otherwise»
		'''
	}
	
	def static CharSequence genGrid(List<EvaluationRule> rules) {
		return '''
		«"\t"»return new ArrayList<Point>();
		'''
	}
	
	def static dispatch genConj(RuleConj r) {return r.conj}
	
	def static dispatch genConj(RuleOtherwise r) {return null}
	
	def static genConditions(List<RuleConditionLevel1> conditions) '''«FOR c : conditions SEPARATOR " or "»«genCondition(c)»«ENDFOR»'''
	
	def static genCondition(RuleConditionLevel1 r) '''(«FOR c : r.compares SEPARATOR " and "»«genCompare(c)»«ENDFOR»)'''
	
	def static genCompare(RuleCompare r) '''surrounding «genOp(r.op)» «r.amount»'''
	
	def static CharSequence genOp(Operator o) {
		switch (o) {
			case Operator::LT: return '''<'''
			case Operator::EQ: return '''=='''
			case Operator::GT: return '''>'''
		}
	}
	
}