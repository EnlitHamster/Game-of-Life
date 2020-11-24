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
				if ((gameBoard[i][j]) &&(surrounding < 6)) {
					 dieingCells.add(new Point(i-1,j-1)); 
				}
				else
				if ((gameBoard[i][j]) &&(surrounding == 6)) {
					  survivingCells.add(new Point(i-1,j-1));
				}
				else
				if (!gameBoard[i][j]) {
					survivingCells.add(new Point(i-1,j-1));
				}
            }
        }

	}
		public static ArrayList<Point> initializeGrid() {
			ArrayList<Point> points = new ArrayList<Point>();
						
					points.add(new Point(0,0));
			points.add(new Point(0,4));
			points.add(new Point(0,8));
			points.add(new Point(0,12));
			points.add(new Point(0,16));
			points.add(new Point(0,20));
			points.add(new Point(0,24));
			points.add(new Point(0,28));
			points.add(new Point(0,32));
			points.add(new Point(0,36));
			points.add(new Point(0,40));
			points.add(new Point(0,44));
			points.add(new Point(0,48));
			points.add(new Point(3,0));
			points.add(new Point(3,4));
			points.add(new Point(3,8));
			points.add(new Point(3,12));
			points.add(new Point(3,16));
			points.add(new Point(3,20));
			points.add(new Point(3,24));
			points.add(new Point(3,28));
			points.add(new Point(3,32));
			points.add(new Point(3,36));
			points.add(new Point(3,40));
			points.add(new Point(3,44));
			points.add(new Point(3,48));
			points.add(new Point(6,0));
			points.add(new Point(6,4));
			points.add(new Point(6,8));
			points.add(new Point(6,12));
			points.add(new Point(6,16));
			points.add(new Point(6,20));
			points.add(new Point(6,24));
			points.add(new Point(6,28));
			points.add(new Point(6,32));
			points.add(new Point(6,36));
			points.add(new Point(6,40));
			points.add(new Point(6,44));
			points.add(new Point(6,48));
			points.add(new Point(9,0));
			points.add(new Point(9,4));
			points.add(new Point(9,8));
			points.add(new Point(9,12));
			points.add(new Point(9,16));
			points.add(new Point(9,20));
			points.add(new Point(9,24));
			points.add(new Point(9,28));
			points.add(new Point(9,32));
			points.add(new Point(9,36));
			points.add(new Point(9,40));
			points.add(new Point(9,44));
			points.add(new Point(9,48));
			points.add(new Point(12,0));
			points.add(new Point(12,4));
			points.add(new Point(12,8));
			points.add(new Point(12,12));
			points.add(new Point(12,16));
			points.add(new Point(12,20));
			points.add(new Point(12,24));
			points.add(new Point(12,28));
			points.add(new Point(12,32));
			points.add(new Point(12,36));
			points.add(new Point(12,40));
			points.add(new Point(12,44));
			points.add(new Point(12,48));
			points.add(new Point(15,0));
			points.add(new Point(15,4));
			points.add(new Point(15,8));
			points.add(new Point(15,12));
			points.add(new Point(15,16));
			points.add(new Point(15,20));
			points.add(new Point(15,24));
			points.add(new Point(15,28));
			points.add(new Point(15,32));
			points.add(new Point(15,36));
			points.add(new Point(15,40));
			points.add(new Point(15,44));
			points.add(new Point(15,48));
			points.add(new Point(18,0));
			points.add(new Point(18,4));
			points.add(new Point(18,8));
			points.add(new Point(18,12));
			points.add(new Point(18,16));
			points.add(new Point(18,20));
			points.add(new Point(18,24));
			points.add(new Point(18,28));
			points.add(new Point(18,32));
			points.add(new Point(18,36));
			points.add(new Point(18,40));
			points.add(new Point(18,44));
			points.add(new Point(18,48));
			points.add(new Point(21,0));
			points.add(new Point(21,4));
			points.add(new Point(21,8));
			points.add(new Point(21,12));
			points.add(new Point(21,16));
			points.add(new Point(21,20));
			points.add(new Point(21,24));
			points.add(new Point(21,28));
			points.add(new Point(21,32));
			points.add(new Point(21,36));
			points.add(new Point(21,40));
			points.add(new Point(21,44));
			points.add(new Point(21,48));
			points.add(new Point(24,0));
			points.add(new Point(24,4));
			points.add(new Point(24,8));
			points.add(new Point(24,12));
			points.add(new Point(24,16));
			points.add(new Point(24,20));
			points.add(new Point(24,24));
			points.add(new Point(24,28));
			points.add(new Point(24,32));
			points.add(new Point(24,36));
			points.add(new Point(24,40));
			points.add(new Point(24,44));
			points.add(new Point(24,48));
			points.add(new Point(27,0));
			points.add(new Point(27,4));
			points.add(new Point(27,8));
			points.add(new Point(27,12));
			points.add(new Point(27,16));
			points.add(new Point(27,20));
			points.add(new Point(27,24));
			points.add(new Point(27,28));
			points.add(new Point(27,32));
			points.add(new Point(27,36));
			points.add(new Point(27,40));
			points.add(new Point(27,44));
			points.add(new Point(27,48));
			points.add(new Point(30,0));
			points.add(new Point(30,4));
			points.add(new Point(30,8));
			points.add(new Point(30,12));
			points.add(new Point(30,16));
			points.add(new Point(30,20));
			points.add(new Point(30,24));
			points.add(new Point(30,28));
			points.add(new Point(30,32));
			points.add(new Point(30,36));
			points.add(new Point(30,40));
			points.add(new Point(30,44));
			points.add(new Point(30,48));
			points.add(new Point(33,0));
			points.add(new Point(33,4));
			points.add(new Point(33,8));
			points.add(new Point(33,12));
			points.add(new Point(33,16));
			points.add(new Point(33,20));
			points.add(new Point(33,24));
			points.add(new Point(33,28));
			points.add(new Point(33,32));
			points.add(new Point(33,36));
			points.add(new Point(33,40));
			points.add(new Point(33,44));
			points.add(new Point(33,48));
			points.add(new Point(36,0));
			points.add(new Point(36,4));
			points.add(new Point(36,8));
			points.add(new Point(36,12));
			points.add(new Point(36,16));
			points.add(new Point(36,20));
			points.add(new Point(36,24));
			points.add(new Point(36,28));
			points.add(new Point(36,32));
			points.add(new Point(36,36));
			points.add(new Point(36,40));
			points.add(new Point(36,44));
			points.add(new Point(36,48));
			points.add(new Point(39,0));
			points.add(new Point(39,4));
			points.add(new Point(39,8));
			points.add(new Point(39,12));
			points.add(new Point(39,16));
			points.add(new Point(39,20));
			points.add(new Point(39,24));
			points.add(new Point(39,28));
			points.add(new Point(39,32));
			points.add(new Point(39,36));
			points.add(new Point(39,40));
			points.add(new Point(39,44));
			points.add(new Point(39,48));
			points.add(new Point(42,0));
			points.add(new Point(42,4));
			points.add(new Point(42,8));
			points.add(new Point(42,12));
			points.add(new Point(42,16));
			points.add(new Point(42,20));
			points.add(new Point(42,24));
			points.add(new Point(42,28));
			points.add(new Point(42,32));
			points.add(new Point(42,36));
			points.add(new Point(42,40));
			points.add(new Point(42,44));
			points.add(new Point(42,48));
			points.add(new Point(45,0));
			points.add(new Point(45,4));
			points.add(new Point(45,8));
			points.add(new Point(45,12));
			points.add(new Point(45,16));
			points.add(new Point(45,20));
			points.add(new Point(45,24));
			points.add(new Point(45,28));
			points.add(new Point(45,32));
			points.add(new Point(45,36));
			points.add(new Point(45,40));
			points.add(new Point(45,44));
			points.add(new Point(45,48));
			points.add(new Point(48,0));
			points.add(new Point(48,4));
			points.add(new Point(48,8));
			points.add(new Point(48,12));
			points.add(new Point(48,16));
			points.add(new Point(48,20));
			points.add(new Point(48,24));
			points.add(new Point(48,28));
			points.add(new Point(48,32));
			points.add(new Point(48,36));
			points.add(new Point(48,40));
			points.add(new Point(48,44));
			points.add(new Point(48,48));
			
			return points;
		}

}