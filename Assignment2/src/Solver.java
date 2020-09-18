
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
		
		public void FillSoduku() {
			System.out.println("Backtracking must happen here");
		}
		
		
		// Here we check if its safe to fill in row as per soduku rules
		
		public Boolean RowCheck(int value, int r, int c) {
			for(int i =0; i< c;i++) {
				if(value == board[r][i]) {
					return false;
				}
			}
			return true;
		}
		
		
		// Here we check if its safe to fill in column as per soduku rules
		
		public Boolean ColCheck(int value, int r, int c) {
			for(int i =0; i< r;i++) {
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
			
}
