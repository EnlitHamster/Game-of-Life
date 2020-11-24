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
				if ((gameBoard[i][j]) &&(surrounding > 1 && surrounding < 3)) {
					 dieingCells.add(new Point(i-1,j-1)); 
				}
				else
				if ((!gameBoard[i][j]) &&(surrounding == 3)) {
					 survivingCells.add(new Point(i-1,j-1));
				}
				else
						if (gameBoard[i][j]) {
					survivingCells.add(new Point(i-1,j-1));
				}
            }
        }

	}
		public static ArrayList<Point> initializeGrid() {
			ArrayList<Point> points = new ArrayList<Point>();
						
					points.add(new Point(0,0));
			points.add(new Point(0,2));
			points.add(new Point(0,4));
			points.add(new Point(0,6));
			points.add(new Point(0,8));
			points.add(new Point(0,10));
			points.add(new Point(0,12));
			points.add(new Point(0,14));
			points.add(new Point(0,16));
			points.add(new Point(0,18));
			points.add(new Point(0,20));
			points.add(new Point(0,22));
			points.add(new Point(0,24));
			points.add(new Point(0,26));
			points.add(new Point(0,28));
			points.add(new Point(0,30));
			points.add(new Point(0,32));
			points.add(new Point(0,34));
			points.add(new Point(0,36));
			points.add(new Point(0,38));
			points.add(new Point(0,40));
			points.add(new Point(0,42));
			points.add(new Point(0,44));
			points.add(new Point(0,46));
			points.add(new Point(0,48));
			points.add(new Point(2,0));
			points.add(new Point(2,2));
			points.add(new Point(2,4));
			points.add(new Point(2,6));
			points.add(new Point(2,8));
			points.add(new Point(2,10));
			points.add(new Point(2,12));
			points.add(new Point(2,14));
			points.add(new Point(2,16));
			points.add(new Point(2,18));
			points.add(new Point(2,20));
			points.add(new Point(2,22));
			points.add(new Point(2,24));
			points.add(new Point(2,26));
			points.add(new Point(2,28));
			points.add(new Point(2,30));
			points.add(new Point(2,32));
			points.add(new Point(2,34));
			points.add(new Point(2,36));
			points.add(new Point(2,38));
			points.add(new Point(2,40));
			points.add(new Point(2,42));
			points.add(new Point(2,44));
			points.add(new Point(2,46));
			points.add(new Point(2,48));
			points.add(new Point(4,0));
			points.add(new Point(4,2));
			points.add(new Point(4,4));
			points.add(new Point(4,6));
			points.add(new Point(4,8));
			points.add(new Point(4,10));
			points.add(new Point(4,12));
			points.add(new Point(4,14));
			points.add(new Point(4,16));
			points.add(new Point(4,18));
			points.add(new Point(4,20));
			points.add(new Point(4,22));
			points.add(new Point(4,24));
			points.add(new Point(4,26));
			points.add(new Point(4,28));
			points.add(new Point(4,30));
			points.add(new Point(4,32));
			points.add(new Point(4,34));
			points.add(new Point(4,36));
			points.add(new Point(4,38));
			points.add(new Point(4,40));
			points.add(new Point(4,42));
			points.add(new Point(4,44));
			points.add(new Point(4,46));
			points.add(new Point(4,48));
			points.add(new Point(6,0));
			points.add(new Point(6,2));
			points.add(new Point(6,4));
			points.add(new Point(6,6));
			points.add(new Point(6,8));
			points.add(new Point(6,10));
			points.add(new Point(6,12));
			points.add(new Point(6,14));
			points.add(new Point(6,16));
			points.add(new Point(6,18));
			points.add(new Point(6,20));
			points.add(new Point(6,22));
			points.add(new Point(6,24));
			points.add(new Point(6,26));
			points.add(new Point(6,28));
			points.add(new Point(6,30));
			points.add(new Point(6,32));
			points.add(new Point(6,34));
			points.add(new Point(6,36));
			points.add(new Point(6,38));
			points.add(new Point(6,40));
			points.add(new Point(6,42));
			points.add(new Point(6,44));
			points.add(new Point(6,46));
			points.add(new Point(6,48));
			points.add(new Point(8,0));
			points.add(new Point(8,2));
			points.add(new Point(8,4));
			points.add(new Point(8,6));
			points.add(new Point(8,8));
			points.add(new Point(8,10));
			points.add(new Point(8,12));
			points.add(new Point(8,14));
			points.add(new Point(8,16));
			points.add(new Point(8,18));
			points.add(new Point(8,20));
			points.add(new Point(8,22));
			points.add(new Point(8,24));
			points.add(new Point(8,26));
			points.add(new Point(8,28));
			points.add(new Point(8,30));
			points.add(new Point(8,32));
			points.add(new Point(8,34));
			points.add(new Point(8,36));
			points.add(new Point(8,38));
			points.add(new Point(8,40));
			points.add(new Point(8,42));
			points.add(new Point(8,44));
			points.add(new Point(8,46));
			points.add(new Point(8,48));
			points.add(new Point(10,0));
			points.add(new Point(10,2));
			points.add(new Point(10,4));
			points.add(new Point(10,6));
			points.add(new Point(10,8));
			points.add(new Point(10,10));
			points.add(new Point(10,12));
			points.add(new Point(10,14));
			points.add(new Point(10,16));
			points.add(new Point(10,18));
			points.add(new Point(10,20));
			points.add(new Point(10,22));
			points.add(new Point(10,24));
			points.add(new Point(10,26));
			points.add(new Point(10,28));
			points.add(new Point(10,30));
			points.add(new Point(10,32));
			points.add(new Point(10,34));
			points.add(new Point(10,36));
			points.add(new Point(10,38));
			points.add(new Point(10,40));
			points.add(new Point(10,42));
			points.add(new Point(10,44));
			points.add(new Point(10,46));
			points.add(new Point(10,48));
			points.add(new Point(12,0));
			points.add(new Point(12,2));
			points.add(new Point(12,4));
			points.add(new Point(12,6));
			points.add(new Point(12,8));
			points.add(new Point(12,10));
			points.add(new Point(12,12));
			points.add(new Point(12,14));
			points.add(new Point(12,16));
			points.add(new Point(12,18));
			points.add(new Point(12,20));
			points.add(new Point(12,22));
			points.add(new Point(12,24));
			points.add(new Point(12,26));
			points.add(new Point(12,28));
			points.add(new Point(12,30));
			points.add(new Point(12,32));
			points.add(new Point(12,34));
			points.add(new Point(12,36));
			points.add(new Point(12,38));
			points.add(new Point(12,40));
			points.add(new Point(12,42));
			points.add(new Point(12,44));
			points.add(new Point(12,46));
			points.add(new Point(12,48));
			points.add(new Point(14,0));
			points.add(new Point(14,2));
			points.add(new Point(14,4));
			points.add(new Point(14,6));
			points.add(new Point(14,8));
			points.add(new Point(14,10));
			points.add(new Point(14,12));
			points.add(new Point(14,14));
			points.add(new Point(14,16));
			points.add(new Point(14,18));
			points.add(new Point(14,20));
			points.add(new Point(14,22));
			points.add(new Point(14,24));
			points.add(new Point(14,26));
			points.add(new Point(14,28));
			points.add(new Point(14,30));
			points.add(new Point(14,32));
			points.add(new Point(14,34));
			points.add(new Point(14,36));
			points.add(new Point(14,38));
			points.add(new Point(14,40));
			points.add(new Point(14,42));
			points.add(new Point(14,44));
			points.add(new Point(14,46));
			points.add(new Point(14,48));
			points.add(new Point(16,0));
			points.add(new Point(16,2));
			points.add(new Point(16,4));
			points.add(new Point(16,6));
			points.add(new Point(16,8));
			points.add(new Point(16,10));
			points.add(new Point(16,12));
			points.add(new Point(16,14));
			points.add(new Point(16,16));
			points.add(new Point(16,18));
			points.add(new Point(16,20));
			points.add(new Point(16,22));
			points.add(new Point(16,24));
			points.add(new Point(16,26));
			points.add(new Point(16,28));
			points.add(new Point(16,30));
			points.add(new Point(16,32));
			points.add(new Point(16,34));
			points.add(new Point(16,36));
			points.add(new Point(16,38));
			points.add(new Point(16,40));
			points.add(new Point(16,42));
			points.add(new Point(16,44));
			points.add(new Point(16,46));
			points.add(new Point(16,48));
			points.add(new Point(18,0));
			points.add(new Point(18,2));
			points.add(new Point(18,4));
			points.add(new Point(18,6));
			points.add(new Point(18,8));
			points.add(new Point(18,10));
			points.add(new Point(18,12));
			points.add(new Point(18,14));
			points.add(new Point(18,16));
			points.add(new Point(18,18));
			points.add(new Point(18,20));
			points.add(new Point(18,22));
			points.add(new Point(18,24));
			points.add(new Point(18,26));
			points.add(new Point(18,28));
			points.add(new Point(18,30));
			points.add(new Point(18,32));
			points.add(new Point(18,34));
			points.add(new Point(18,36));
			points.add(new Point(18,38));
			points.add(new Point(18,40));
			points.add(new Point(18,42));
			points.add(new Point(18,44));
			points.add(new Point(18,46));
			points.add(new Point(18,48));
			points.add(new Point(20,0));
			points.add(new Point(20,2));
			points.add(new Point(20,4));
			points.add(new Point(20,6));
			points.add(new Point(20,8));
			points.add(new Point(20,10));
			points.add(new Point(20,12));
			points.add(new Point(20,14));
			points.add(new Point(20,16));
			points.add(new Point(20,18));
			points.add(new Point(20,20));
			points.add(new Point(20,22));
			points.add(new Point(20,24));
			points.add(new Point(20,26));
			points.add(new Point(20,28));
			points.add(new Point(20,30));
			points.add(new Point(20,32));
			points.add(new Point(20,34));
			points.add(new Point(20,36));
			points.add(new Point(20,38));
			points.add(new Point(20,40));
			points.add(new Point(20,42));
			points.add(new Point(20,44));
			points.add(new Point(20,46));
			points.add(new Point(20,48));
			points.add(new Point(22,0));
			points.add(new Point(22,2));
			points.add(new Point(22,4));
			points.add(new Point(22,6));
			points.add(new Point(22,8));
			points.add(new Point(22,10));
			points.add(new Point(22,12));
			points.add(new Point(22,14));
			points.add(new Point(22,16));
			points.add(new Point(22,18));
			points.add(new Point(22,20));
			points.add(new Point(22,22));
			points.add(new Point(22,24));
			points.add(new Point(22,26));
			points.add(new Point(22,28));
			points.add(new Point(22,30));
			points.add(new Point(22,32));
			points.add(new Point(22,34));
			points.add(new Point(22,36));
			points.add(new Point(22,38));
			points.add(new Point(22,40));
			points.add(new Point(22,42));
			points.add(new Point(22,44));
			points.add(new Point(22,46));
			points.add(new Point(22,48));
			points.add(new Point(24,0));
			points.add(new Point(24,2));
			points.add(new Point(24,4));
			points.add(new Point(24,6));
			points.add(new Point(24,8));
			points.add(new Point(24,10));
			points.add(new Point(24,12));
			points.add(new Point(24,14));
			points.add(new Point(24,16));
			points.add(new Point(24,18));
			points.add(new Point(24,20));
			points.add(new Point(24,22));
			points.add(new Point(24,24));
			points.add(new Point(24,26));
			points.add(new Point(24,28));
			points.add(new Point(24,30));
			points.add(new Point(24,32));
			points.add(new Point(24,34));
			points.add(new Point(24,36));
			points.add(new Point(24,38));
			points.add(new Point(24,40));
			points.add(new Point(24,42));
			points.add(new Point(24,44));
			points.add(new Point(24,46));
			points.add(new Point(24,48));
			points.add(new Point(26,0));
			points.add(new Point(26,2));
			points.add(new Point(26,4));
			points.add(new Point(26,6));
			points.add(new Point(26,8));
			points.add(new Point(26,10));
			points.add(new Point(26,12));
			points.add(new Point(26,14));
			points.add(new Point(26,16));
			points.add(new Point(26,18));
			points.add(new Point(26,20));
			points.add(new Point(26,22));
			points.add(new Point(26,24));
			points.add(new Point(26,26));
			points.add(new Point(26,28));
			points.add(new Point(26,30));
			points.add(new Point(26,32));
			points.add(new Point(26,34));
			points.add(new Point(26,36));
			points.add(new Point(26,38));
			points.add(new Point(26,40));
			points.add(new Point(26,42));
			points.add(new Point(26,44));
			points.add(new Point(26,46));
			points.add(new Point(26,48));
			points.add(new Point(28,0));
			points.add(new Point(28,2));
			points.add(new Point(28,4));
			points.add(new Point(28,6));
			points.add(new Point(28,8));
			points.add(new Point(28,10));
			points.add(new Point(28,12));
			points.add(new Point(28,14));
			points.add(new Point(28,16));
			points.add(new Point(28,18));
			points.add(new Point(28,20));
			points.add(new Point(28,22));
			points.add(new Point(28,24));
			points.add(new Point(28,26));
			points.add(new Point(28,28));
			points.add(new Point(28,30));
			points.add(new Point(28,32));
			points.add(new Point(28,34));
			points.add(new Point(28,36));
			points.add(new Point(28,38));
			points.add(new Point(28,40));
			points.add(new Point(28,42));
			points.add(new Point(28,44));
			points.add(new Point(28,46));
			points.add(new Point(28,48));
			points.add(new Point(30,0));
			points.add(new Point(30,2));
			points.add(new Point(30,4));
			points.add(new Point(30,6));
			points.add(new Point(30,8));
			points.add(new Point(30,10));
			points.add(new Point(30,12));
			points.add(new Point(30,14));
			points.add(new Point(30,16));
			points.add(new Point(30,18));
			points.add(new Point(30,20));
			points.add(new Point(30,22));
			points.add(new Point(30,24));
			points.add(new Point(30,26));
			points.add(new Point(30,28));
			points.add(new Point(30,30));
			points.add(new Point(30,32));
			points.add(new Point(30,34));
			points.add(new Point(30,36));
			points.add(new Point(30,38));
			points.add(new Point(30,40));
			points.add(new Point(30,42));
			points.add(new Point(30,44));
			points.add(new Point(30,46));
			points.add(new Point(30,48));
			points.add(new Point(32,0));
			points.add(new Point(32,2));
			points.add(new Point(32,4));
			points.add(new Point(32,6));
			points.add(new Point(32,8));
			points.add(new Point(32,10));
			points.add(new Point(32,12));
			points.add(new Point(32,14));
			points.add(new Point(32,16));
			points.add(new Point(32,18));
			points.add(new Point(32,20));
			points.add(new Point(32,22));
			points.add(new Point(32,24));
			points.add(new Point(32,26));
			points.add(new Point(32,28));
			points.add(new Point(32,30));
			points.add(new Point(32,32));
			points.add(new Point(32,34));
			points.add(new Point(32,36));
			points.add(new Point(32,38));
			points.add(new Point(32,40));
			points.add(new Point(32,42));
			points.add(new Point(32,44));
			points.add(new Point(32,46));
			points.add(new Point(32,48));
			points.add(new Point(34,0));
			points.add(new Point(34,2));
			points.add(new Point(34,4));
			points.add(new Point(34,6));
			points.add(new Point(34,8));
			points.add(new Point(34,10));
			points.add(new Point(34,12));
			points.add(new Point(34,14));
			points.add(new Point(34,16));
			points.add(new Point(34,18));
			points.add(new Point(34,20));
			points.add(new Point(34,22));
			points.add(new Point(34,24));
			points.add(new Point(34,26));
			points.add(new Point(34,28));
			points.add(new Point(34,30));
			points.add(new Point(34,32));
			points.add(new Point(34,34));
			points.add(new Point(34,36));
			points.add(new Point(34,38));
			points.add(new Point(34,40));
			points.add(new Point(34,42));
			points.add(new Point(34,44));
			points.add(new Point(34,46));
			points.add(new Point(34,48));
			points.add(new Point(36,0));
			points.add(new Point(36,2));
			points.add(new Point(36,4));
			points.add(new Point(36,6));
			points.add(new Point(36,8));
			points.add(new Point(36,10));
			points.add(new Point(36,12));
			points.add(new Point(36,14));
			points.add(new Point(36,16));
			points.add(new Point(36,18));
			points.add(new Point(36,20));
			points.add(new Point(36,22));
			points.add(new Point(36,24));
			points.add(new Point(36,26));
			points.add(new Point(36,28));
			points.add(new Point(36,30));
			points.add(new Point(36,32));
			points.add(new Point(36,34));
			points.add(new Point(36,36));
			points.add(new Point(36,38));
			points.add(new Point(36,40));
			points.add(new Point(36,42));
			points.add(new Point(36,44));
			points.add(new Point(36,46));
			points.add(new Point(36,48));
			points.add(new Point(38,0));
			points.add(new Point(38,2));
			points.add(new Point(38,4));
			points.add(new Point(38,6));
			points.add(new Point(38,8));
			points.add(new Point(38,10));
			points.add(new Point(38,12));
			points.add(new Point(38,14));
			points.add(new Point(38,16));
			points.add(new Point(38,18));
			points.add(new Point(38,20));
			points.add(new Point(38,22));
			points.add(new Point(38,24));
			points.add(new Point(38,26));
			points.add(new Point(38,28));
			points.add(new Point(38,30));
			points.add(new Point(38,32));
			points.add(new Point(38,34));
			points.add(new Point(38,36));
			points.add(new Point(38,38));
			points.add(new Point(38,40));
			points.add(new Point(38,42));
			points.add(new Point(38,44));
			points.add(new Point(38,46));
			points.add(new Point(38,48));
			points.add(new Point(40,0));
			points.add(new Point(40,2));
			points.add(new Point(40,4));
			points.add(new Point(40,6));
			points.add(new Point(40,8));
			points.add(new Point(40,10));
			points.add(new Point(40,12));
			points.add(new Point(40,14));
			points.add(new Point(40,16));
			points.add(new Point(40,18));
			points.add(new Point(40,20));
			points.add(new Point(40,22));
			points.add(new Point(40,24));
			points.add(new Point(40,26));
			points.add(new Point(40,28));
			points.add(new Point(40,30));
			points.add(new Point(40,32));
			points.add(new Point(40,34));
			points.add(new Point(40,36));
			points.add(new Point(40,38));
			points.add(new Point(40,40));
			points.add(new Point(40,42));
			points.add(new Point(40,44));
			points.add(new Point(40,46));
			points.add(new Point(40,48));
			points.add(new Point(42,0));
			points.add(new Point(42,2));
			points.add(new Point(42,4));
			points.add(new Point(42,6));
			points.add(new Point(42,8));
			points.add(new Point(42,10));
			points.add(new Point(42,12));
			points.add(new Point(42,14));
			points.add(new Point(42,16));
			points.add(new Point(42,18));
			points.add(new Point(42,20));
			points.add(new Point(42,22));
			points.add(new Point(42,24));
			points.add(new Point(42,26));
			points.add(new Point(42,28));
			points.add(new Point(42,30));
			points.add(new Point(42,32));
			points.add(new Point(42,34));
			points.add(new Point(42,36));
			points.add(new Point(42,38));
			points.add(new Point(42,40));
			points.add(new Point(42,42));
			points.add(new Point(42,44));
			points.add(new Point(42,46));
			points.add(new Point(42,48));
			points.add(new Point(44,0));
			points.add(new Point(44,2));
			points.add(new Point(44,4));
			points.add(new Point(44,6));
			points.add(new Point(44,8));
			points.add(new Point(44,10));
			points.add(new Point(44,12));
			points.add(new Point(44,14));
			points.add(new Point(44,16));
			points.add(new Point(44,18));
			points.add(new Point(44,20));
			points.add(new Point(44,22));
			points.add(new Point(44,24));
			points.add(new Point(44,26));
			points.add(new Point(44,28));
			points.add(new Point(44,30));
			points.add(new Point(44,32));
			points.add(new Point(44,34));
			points.add(new Point(44,36));
			points.add(new Point(44,38));
			points.add(new Point(44,40));
			points.add(new Point(44,42));
			points.add(new Point(44,44));
			points.add(new Point(44,46));
			points.add(new Point(44,48));
			points.add(new Point(46,0));
			points.add(new Point(46,2));
			points.add(new Point(46,4));
			points.add(new Point(46,6));
			points.add(new Point(46,8));
			points.add(new Point(46,10));
			points.add(new Point(46,12));
			points.add(new Point(46,14));
			points.add(new Point(46,16));
			points.add(new Point(46,18));
			points.add(new Point(46,20));
			points.add(new Point(46,22));
			points.add(new Point(46,24));
			points.add(new Point(46,26));
			points.add(new Point(46,28));
			points.add(new Point(46,30));
			points.add(new Point(46,32));
			points.add(new Point(46,34));
			points.add(new Point(46,36));
			points.add(new Point(46,38));
			points.add(new Point(46,40));
			points.add(new Point(46,42));
			points.add(new Point(46,44));
			points.add(new Point(46,46));
			points.add(new Point(46,48));
			points.add(new Point(48,0));
			points.add(new Point(48,2));
			points.add(new Point(48,4));
			points.add(new Point(48,6));
			points.add(new Point(48,8));
			points.add(new Point(48,10));
			points.add(new Point(48,12));
			points.add(new Point(48,14));
			points.add(new Point(48,16));
			points.add(new Point(48,18));
			points.add(new Point(48,20));
			points.add(new Point(48,22));
			points.add(new Point(48,24));
			points.add(new Point(48,26));
			points.add(new Point(48,28));
			points.add(new Point(48,30));
			points.add(new Point(48,32));
			points.add(new Point(48,34));
			points.add(new Point(48,36));
			points.add(new Point(48,38));
			points.add(new Point(48,40));
			points.add(new Point(48,42));
			points.add(new Point(48,44));
			points.add(new Point(48,46));
			points.add(new Point(48,48));
			
			return points;
		}

}