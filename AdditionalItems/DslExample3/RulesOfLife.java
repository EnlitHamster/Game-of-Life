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
				if ((gameBoard[i][j]) &&(surrounding < 3)) {
					 dieingCells.add(new Point(i-1,j-1)); 
				}
				else
				if ((!gameBoard[i][j]) &&(surrounding > 6)) {
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
						
					points.add(new Point(0,3));
			points.add(new Point(0,6));
			points.add(new Point(0,9));
			points.add(new Point(0,15));
			points.add(new Point(0,18));
			points.add(new Point(0,21));
			points.add(new Point(0,27));
			points.add(new Point(0,30));
			points.add(new Point(0,33));
			points.add(new Point(0,39));
			points.add(new Point(0,42));
			points.add(new Point(0,45));
			points.add(new Point(3,0));
			points.add(new Point(3,3));
			points.add(new Point(3,6));
			points.add(new Point(3,9));
			points.add(new Point(3,12));
			points.add(new Point(3,15));
			points.add(new Point(3,18));
			points.add(new Point(3,21));
			points.add(new Point(3,24));
			points.add(new Point(3,27));
			points.add(new Point(3,30));
			points.add(new Point(3,33));
			points.add(new Point(3,36));
			points.add(new Point(3,39));
			points.add(new Point(3,42));
			points.add(new Point(3,45));
			points.add(new Point(3,48));
			points.add(new Point(6,0));
			points.add(new Point(6,3));
			points.add(new Point(6,6));
			points.add(new Point(6,9));
			points.add(new Point(6,12));
			points.add(new Point(6,15));
			points.add(new Point(6,18));
			points.add(new Point(6,21));
			points.add(new Point(6,24));
			points.add(new Point(6,27));
			points.add(new Point(6,30));
			points.add(new Point(6,33));
			points.add(new Point(6,36));
			points.add(new Point(6,39));
			points.add(new Point(6,42));
			points.add(new Point(6,45));
			points.add(new Point(6,48));
			points.add(new Point(9,0));
			points.add(new Point(9,3));
			points.add(new Point(9,6));
			points.add(new Point(9,9));
			points.add(new Point(9,12));
			points.add(new Point(9,15));
			points.add(new Point(9,18));
			points.add(new Point(9,21));
			points.add(new Point(9,24));
			points.add(new Point(9,27));
			points.add(new Point(9,30));
			points.add(new Point(9,33));
			points.add(new Point(9,36));
			points.add(new Point(9,39));
			points.add(new Point(9,42));
			points.add(new Point(9,45));
			points.add(new Point(9,48));
			points.add(new Point(12,3));
			points.add(new Point(12,6));
			points.add(new Point(12,9));
			points.add(new Point(12,15));
			points.add(new Point(12,18));
			points.add(new Point(12,21));
			points.add(new Point(12,27));
			points.add(new Point(12,30));
			points.add(new Point(12,33));
			points.add(new Point(12,39));
			points.add(new Point(12,42));
			points.add(new Point(12,45));
			points.add(new Point(15,0));
			points.add(new Point(15,3));
			points.add(new Point(15,6));
			points.add(new Point(15,9));
			points.add(new Point(15,12));
			points.add(new Point(15,15));
			points.add(new Point(15,18));
			points.add(new Point(15,21));
			points.add(new Point(15,24));
			points.add(new Point(15,27));
			points.add(new Point(15,30));
			points.add(new Point(15,33));
			points.add(new Point(15,36));
			points.add(new Point(15,39));
			points.add(new Point(15,42));
			points.add(new Point(15,45));
			points.add(new Point(15,48));
			points.add(new Point(18,0));
			points.add(new Point(18,3));
			points.add(new Point(18,6));
			points.add(new Point(18,9));
			points.add(new Point(18,12));
			points.add(new Point(18,15));
			points.add(new Point(18,18));
			points.add(new Point(18,21));
			points.add(new Point(18,24));
			points.add(new Point(18,27));
			points.add(new Point(18,30));
			points.add(new Point(18,33));
			points.add(new Point(18,36));
			points.add(new Point(18,39));
			points.add(new Point(18,42));
			points.add(new Point(18,45));
			points.add(new Point(18,48));
			points.add(new Point(21,0));
			points.add(new Point(21,3));
			points.add(new Point(21,6));
			points.add(new Point(21,9));
			points.add(new Point(21,12));
			points.add(new Point(21,15));
			points.add(new Point(21,18));
			points.add(new Point(21,21));
			points.add(new Point(21,24));
			points.add(new Point(21,27));
			points.add(new Point(21,30));
			points.add(new Point(21,33));
			points.add(new Point(21,36));
			points.add(new Point(21,39));
			points.add(new Point(21,42));
			points.add(new Point(21,45));
			points.add(new Point(21,48));
			points.add(new Point(24,3));
			points.add(new Point(24,6));
			points.add(new Point(24,9));
			points.add(new Point(24,15));
			points.add(new Point(24,18));
			points.add(new Point(24,21));
			points.add(new Point(24,27));
			points.add(new Point(24,30));
			points.add(new Point(24,33));
			points.add(new Point(24,39));
			points.add(new Point(24,42));
			points.add(new Point(24,45));
			points.add(new Point(27,0));
			points.add(new Point(27,3));
			points.add(new Point(27,6));
			points.add(new Point(27,9));
			points.add(new Point(27,12));
			points.add(new Point(27,15));
			points.add(new Point(27,18));
			points.add(new Point(27,21));
			points.add(new Point(27,24));
			points.add(new Point(27,27));
			points.add(new Point(27,30));
			points.add(new Point(27,33));
			points.add(new Point(27,36));
			points.add(new Point(27,39));
			points.add(new Point(27,42));
			points.add(new Point(27,45));
			points.add(new Point(27,48));
			points.add(new Point(30,0));
			points.add(new Point(30,3));
			points.add(new Point(30,6));
			points.add(new Point(30,9));
			points.add(new Point(30,12));
			points.add(new Point(30,15));
			points.add(new Point(30,18));
			points.add(new Point(30,21));
			points.add(new Point(30,24));
			points.add(new Point(30,27));
			points.add(new Point(30,30));
			points.add(new Point(30,33));
			points.add(new Point(30,36));
			points.add(new Point(30,39));
			points.add(new Point(30,42));
			points.add(new Point(30,45));
			points.add(new Point(30,48));
			points.add(new Point(33,0));
			points.add(new Point(33,3));
			points.add(new Point(33,6));
			points.add(new Point(33,9));
			points.add(new Point(33,12));
			points.add(new Point(33,15));
			points.add(new Point(33,18));
			points.add(new Point(33,21));
			points.add(new Point(33,24));
			points.add(new Point(33,27));
			points.add(new Point(33,30));
			points.add(new Point(33,33));
			points.add(new Point(33,36));
			points.add(new Point(33,39));
			points.add(new Point(33,42));
			points.add(new Point(33,45));
			points.add(new Point(33,48));
			points.add(new Point(36,3));
			points.add(new Point(36,6));
			points.add(new Point(36,9));
			points.add(new Point(36,15));
			points.add(new Point(36,18));
			points.add(new Point(36,21));
			points.add(new Point(36,27));
			points.add(new Point(36,30));
			points.add(new Point(36,33));
			points.add(new Point(36,39));
			points.add(new Point(36,42));
			points.add(new Point(36,45));
			points.add(new Point(39,0));
			points.add(new Point(39,3));
			points.add(new Point(39,6));
			points.add(new Point(39,9));
			points.add(new Point(39,12));
			points.add(new Point(39,15));
			points.add(new Point(39,18));
			points.add(new Point(39,21));
			points.add(new Point(39,24));
			points.add(new Point(39,27));
			points.add(new Point(39,30));
			points.add(new Point(39,33));
			points.add(new Point(39,36));
			points.add(new Point(39,39));
			points.add(new Point(39,42));
			points.add(new Point(39,45));
			points.add(new Point(39,48));
			points.add(new Point(42,0));
			points.add(new Point(42,3));
			points.add(new Point(42,6));
			points.add(new Point(42,9));
			points.add(new Point(42,12));
			points.add(new Point(42,15));
			points.add(new Point(42,18));
			points.add(new Point(42,21));
			points.add(new Point(42,24));
			points.add(new Point(42,27));
			points.add(new Point(42,30));
			points.add(new Point(42,33));
			points.add(new Point(42,36));
			points.add(new Point(42,39));
			points.add(new Point(42,42));
			points.add(new Point(42,45));
			points.add(new Point(42,48));
			points.add(new Point(45,0));
			points.add(new Point(45,3));
			points.add(new Point(45,6));
			points.add(new Point(45,9));
			points.add(new Point(45,12));
			points.add(new Point(45,15));
			points.add(new Point(45,18));
			points.add(new Point(45,21));
			points.add(new Point(45,24));
			points.add(new Point(45,27));
			points.add(new Point(45,30));
			points.add(new Point(45,33));
			points.add(new Point(45,36));
			points.add(new Point(45,39));
			points.add(new Point(45,42));
			points.add(new Point(45,45));
			points.add(new Point(45,48));
			points.add(new Point(48,3));
			points.add(new Point(48,6));
			points.add(new Point(48,9));
			points.add(new Point(48,15));
			points.add(new Point(48,18));
			points.add(new Point(48,21));
			points.add(new Point(48,27));
			points.add(new Point(48,30));
			points.add(new Point(48,33));
			points.add(new Point(48,39));
			points.add(new Point(48,42));
			points.add(new Point(48,45));
			
			return points;
		}

}