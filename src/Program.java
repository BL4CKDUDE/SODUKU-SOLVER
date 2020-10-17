import java.util.*;


//0 4 0 0 0 0 1 7 9
//0 0 2 0 0 8 0 5 4
//0 0 6 0 0 5 0 0 8
//0 8 0 0 7 0 9 1 0
//0 5 0 0 9 0 0 3 0
//0 1 9 0 6 0 0 4 0
//3 0 0 4 0 0 7 0 0
//5 7 0 1 0 0 2 0 0
//9 2 8 0 0 0 0 6 0

public class Program {
	
	public static void main(String...args) {
//			System.out.println("DONE!");
			int n = 3;
			int[][] board = new int[n*n][n*n];
			Scanner in = new Scanner(System.in);
			
			// input first row separated by spaces, new line for next row
			
			for(int i =0; i < n*n;i++) {
				String input = in.nextLine();
				String[] inputArray = input.split(" ");
				for(int j =0; j < inputArray.length; j++) {
					int value = Integer.parseInt(inputArray[j]);
					board[i][j] = value;
				}
			}
			
			// calling the soduku solver which backtracks and safely fills it
			Solver Soduku = new Solver(board, 0, 0);
			Soduku.FillSoduku();
			Soduku.printBoard();
			
			
	}

}
