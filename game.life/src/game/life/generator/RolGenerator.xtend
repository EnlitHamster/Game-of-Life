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

class RolGenerator {
	
	public static val GRID_SIZE = 50;
		
	def static toCode(Model model) '''
	package GameOfLife;
	
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
				ArrayList<Point> points = new ArrayList<Point>();
							
				«genGrid(model.rand, model.init)»
				return points;
			}
	
	}'''
	
	def static CharSequence genRules(List<EvaluationRule> rules) {
		val Rules conds = EvalRules.genEvalRules(rules);
		var String otherwise = "if (true) { }"
		
		if (conds.die() === null){
				otherwise = "if (gameBoard[i][j]) {
	dieingCells.add(new Point(i-1,j-1));
}"
		}
		if (conds.live() === null){			
			otherwise = "if (gameBoard[i][j]) {
	survivingCells.add(new Point(i-1,j-1));
}"
		}
		if (conds.become() === null){
				otherwise = "if (!gameBoard[i][j]) {
	survivingCells.add(new Point(i-1,j-1));
}"
		}
		
		
		return '''		
		«IF conds.die() !== null»
			«"if ((gameBoard[i][j]) &&"»«genConditions(conds.die())»«") {\n"»
			«"\t dieingCells.add(new Point(i-1,j-1)); \n"»
			«"}"»
			«"else"»
		«ENDIF»		
		«IF conds.live() !== null»
			«"if ((gameBoard[i][j]) &&"»«genConditions(conds.live())»«") {\n"»
			«"\t  survivingCells.add(new Point(i-1,j-1));\n "»
			«"}"»
			«"else"»
		«ENDIF»		
		«IF conds.become() !== null»
			«"if ((!gameBoard[i][j]) &&"»«genConditions(conds.become())»«") {\n"»
			«"\t survivingCells.add(new Point(i-1,j-1));\n"»
			«"}"»
			«"else"»
		«ENDIF»«otherwise»
		'''
	}
		
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
	
	def static CharSequence genGrid(boolean rand, List<GridRule> rules) {
		var matrix = Array2D.boolArray(GRID_SIZE, GRID_SIZE)
		val random = new Random();
		
		for (var i = 0; i < GRID_SIZE; i++)
			for (var j = 0; j < GRID_SIZE; j++)
				matrix.get(i).set(j, rand ? random.nextBoolean() : false);		
				
		for (rule : rules) applyRule(matrix, rule)
		
		val List<String> pointsList = newArrayList();
		
		var x = -1;
		var y = -1;
		for (array : matrix){
			x = x +1;
			y = -1;
			for (b : array){
				y = y+1;
				if (b){
					pointsList.add("			points.add(new Point("+x+","+y+"));")
				}
			}
		}
				
		return '''	
		«FOR point : pointsList BEFORE "\t\t" AFTER "\n"»
			«point»
		«ENDFOR»
		'''
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
	
	
}