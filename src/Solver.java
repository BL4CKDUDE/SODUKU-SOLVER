
public class Solver {
		int[][] board;
		int row;
		int col;
		
		public Solver(int[][] board, int row, int col) {
			super();
			this.board = board;
			this.row = row;
			this.col = col;
		}
		
		public int[] findEmpty() {
			int [] coord = new int[2];
			coord[0] = 100;
			coord[1] = 100;
			for(int row=0; row < 9; row++) {
				for(int col =0; col < 9; col++) {
					if(board[row][col] == 0) {
						coord[0] = row;
						coord[1] = col;
					}
				}
			}
			return coord;
		}
		
		public Boolean FillSoduku() {
//			System.out.println("Backtracking must happen here");
			int [] fillCoord = findEmpty();
			
			if(fillCoord[0] == 100 && fillCoord[1] == 100) {				
				return true; 
			}
			
			int r = fillCoord[0];
			int c = fillCoord[1];
			
//			print(r+"" + "," + c + "");
			
			for(int num = 1 ; num <= 9;  num++) {
				
				if (isSafe(r,c,num)) {
				board[r][c] = num;
				
				if( FillSoduku()) {
					return true;
				}
				
				board[r][c] = 0;
				
				}
			}
			
			return false;
		}
		
		// Checking everything at once
		
		public Boolean isSafe(int row, int col, int num) {
			if(RowCheck(num,row,col) && ColCheck(num,row,col) && BlockCheck(num, row, col)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
		// Here we check if its safe to fill in row as per soduku rules
		
		public Boolean RowCheck(int value, int r, int c) {
			for(int i =0; i< 9;i++) {
				if(value == board[r][i]) {
					return false;
				}
			}
			return true;
		}
		
		
		// Here we check if its safe to fill in column as per soduku rules
		
		public Boolean ColCheck(int value, int r, int c) {
			for(int i =0; i< 9;i++) {
				if(value == board[i][c]) {
					return false;
				}
			}
			return true;
		}
		
		
		// Here we check if its safe to fill in the position's n x n block as per soduku rules
		public Boolean BlockCheck(int value, int row, int col) {
			int n = 9;
			int m = 9;
			
			// checking if were in the first row and first col block
			if(row < n/3 && col < m/3) {
				for(int r=0; r< n/3;r++) {
					for( int c =0; c< m/3;c++) {
						if(board[r][c] == value) {
							return false;
						}
					}
				}
			}
			
			// checking if were in the first row and second col block
			
			else if(row < n/3 && col >= m/3 && col < 6){
				for (int r = 0; r < n/3;r++) {
					for(int c =(n/3); c < 6 ; c++) {
						if(board[r][c] == value) {
							return false;
						}
					}
				}
			}
			
			// checking if were in the first row and third col block
			else if (row < n/3 && col >= 6) {
				for(int r=0; r < n/3; r++) {
					for(int c =6; c < m; c++) {
						if(board[r][c] == value) {
							return false;
						}
					}
				}
			}
			
			// checking if were in the second row and first col block
			else if(row >= n/3 && col < m/3 && row < 6) {
				for (int r = (n/3); r < 6; r++) {
					for(int c =0; c< m/3; c++) {
						if(board[r][c] == value) {
							return false;
						}
					}
				}
			}
			// checking if were in the second row and second col block
			else if (row >= n/3 && col >= m/3 && col < 6 && row < 6) {
				for (int r = (n/3) ; r < 6; r++) {
					for(int c =(n/3); c < 6; c++) {
						if(board[r][c] == value) {
							return false;
						}
					}
				}
			}
			
			// checking if were in the second row and third col block
			else if (row >= n/3 && col >= 6 && col < n && row < 6) {
				for(int r = (n/3); r < 6; r++) {
					for (int c=6; c< m; c++) {
						if(board[r][c] == value) {
							return false;
						}
					}
				}
			}
			
			// checking if were in the third row and first col block
			else if(row >= 6 && col < m/3){
				for (int r = 6; r < n;r++){
				for(int c =0; c < n/3; c++){
					if(board[r][c] == value){
						return false;
					}
				}
			}
			
		}
			// checking if were in the third row and second col block
			else if(row > 6 && col >= m/3 && col < 6){
				for (int r =6; r < n ;r++){
				for(int c =(n/3); c < 6; c++){
					if(board[r][c] == value){
						return false;
					}
				}
			}
			
		}	
			// checking if were in the third row and third col block
			
			else if(row >= 6 && col >= 6){
				for (int r =6; r < n;r++){
				for(int c =6; c < n; c++){
					if(board[r][c] == value){
						return false; 
					}
				}
			}
			
		}
			
			return true;
		}
		
		
		public void printBoard() {
			Boolean changed = true;
			
			for (int i =0; i < 9;i++) {
				for (int j =0; j < 9; j++) {
					if(board[i][j] == 0) {
						changed = false;
					}
				}
			}
			
			if(changed) {
			
			String rowString = "";
			for (int i =0; i < 9;i++) {
				for (int j =0; j < 9; j++) {
					rowString = rowString + board[i][j] + "";
					if (j < 8) {
						rowString  = rowString + " ";
					}
				}
				System.out.println(rowString);
				rowString = "";
			}
			
			}
			else {
				print("No Solution");
			}
		}
		
		public void print(String s) {
			System.out.println(s);
		}
			
}
