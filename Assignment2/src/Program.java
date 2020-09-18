import java.util.*;

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
			
	}

}
