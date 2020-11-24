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
				if ((gameBoard[i][j]) &&(surrounding > 1 && surrounding < 4)) {
					  survivingCells.add(new Point(i-1,j-1));
				}
				else
				if ((!gameBoard[i][j]) &&(surrounding == 3)) {
					 survivingCells.add(new Point(i-1,j-1));
				}
				else
						if (gameBoard[i][j]) {
					dieingCells.add(new Point(i-1,j-1));
				}
            }
        }

	}
		public static ArrayList<Point> initializeGrid() {
			ArrayList<Point> points = new ArrayList<Point>();
						
					points.add(new Point(1,5));
			points.add(new Point(1,6));
			points.add(new Point(2,5));
			points.add(new Point(2,6));
			points.add(new Point(11,5));
			points.add(new Point(11,6));
			points.add(new Point(11,7));
			points.add(new Point(12,4));
			points.add(new Point(12,8));
			points.add(new Point(13,3));
			points.add(new Point(13,9));
			points.add(new Point(14,3));
			points.add(new Point(14,9));
			points.add(new Point(15,6));
			points.add(new Point(16,4));
			points.add(new Point(16,8));
			points.add(new Point(17,5));
			points.add(new Point(17,6));
			points.add(new Point(17,7));
			points.add(new Point(18,6));
			points.add(new Point(21,3));
			points.add(new Point(21,4));
			points.add(new Point(21,5));
			points.add(new Point(22,3));
			points.add(new Point(22,4));
			points.add(new Point(22,5));
			points.add(new Point(23,2));
			points.add(new Point(23,6));
			points.add(new Point(25,1));
			points.add(new Point(25,2));
			points.add(new Point(25,6));
			points.add(new Point(25,7));
			points.add(new Point(35,3));
			points.add(new Point(35,4));
			points.add(new Point(36,3));
			points.add(new Point(36,4));
			
			return points;
		}

}