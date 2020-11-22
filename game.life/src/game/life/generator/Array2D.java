package game.life.generator;

import org.eclipse.xtext.xbase.lib.Inline;

public class Array2D {
	
	@Inline("new boolean[$1][$2]")
	public static boolean[][] boolArray(int n, int m) {throw new UnsupportedOperationException();}

}
