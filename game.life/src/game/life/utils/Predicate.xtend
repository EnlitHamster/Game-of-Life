package game.life.utils

import game.life.goLDSL.OperatorEx
import game.life.goLDSL.PatternStmt
import game.life.goLDSL.PatternStmtX
import game.life.goLDSL.PatternStmtY
import java.util.List

class Predicate {
	
	interface Stmt {
		def boolean apply(int x, int y)
	}
	
	def static List<Stmt> genPredicate(List<PatternStmt> stmts) {
		val List<Stmt> predicate = newArrayList();
		for (stmt : stmts) predicate.add(toStmt(stmt))
		return predicate;
	}
	
	def static dispatch toStmt(PatternStmtX stmt) {
		val neg = stmt.neg;
		val am = stmt.amount;
		switch (stmt.op) {
			case OperatorEx::LT: return [int x, int y | neg ? x >= am : x < am]
			case OperatorEx::EQ: return [int x, int y | neg ? x != am : x == am]
			case OperatorEx::GT: return [int x, int y | neg ? x <= am : x > am]
			case OperatorEx::MOD: return [int x, int y | neg ? x % am != 0 : x % am == 0]
		}
	}
	
	def static dispatch toStmt(PatternStmtY stmt) {
		val neg = stmt.neg;
		val am = stmt.amount;
		switch (stmt.op) {
			case OperatorEx::LT: return [int x, int y | neg ? y >= am : y < am]
			case OperatorEx::EQ: return [int x, int y | neg ? y != am : y == am]
			case OperatorEx::GT: return [int x, int y | neg ? y <= am : y > am]
			case OperatorEx::MOD: return [int x, int y | neg ? y % am != 0 : y % am == 0]
		}
	}
	
}