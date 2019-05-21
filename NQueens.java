/*	Sergio Iván Tostado Nieto A01229274
 *	Edgar Manuel Perez Villa A00344473 
 *	Diego Solorzano
 * */


public class NQueens {
	private int[][] board;
	
	public void start(int queens) {
		board = new int[queens][queens];
		for(int i = 0; i < board.length;i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	public boolean is_attacked(int x, int y, int[][] board) {
		if(containsRow(this.board[x])) {
			return true;
		}else if(containsCol(this.board, y)) {
			return true;
		}else if(containsNegDiag(this.board, x, y)) {
			return true;
		}else if(containsPosDiag(this.board, x, y)) {
			return true;
		}
		return false;
	}
	
	public boolean containsRow(int[] row) {
		for(int i = 0; i < row.length;i++) {
			if(row[i] == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsCol(int[][] board, int col) {
		for(int i = 0; i < board.length;i++) {
			if(board[i][col] == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsNegDiag(int[][] board, int x, int y) {
		int x1 = x;
		int y1 = y;
		while(x1 < board.length && y1 < board.length) {
			if(board[x1][y1] == 1) {
				return true;
			}
			x1++;
			y1++;
		}
		x1 = x;
		y1 = y;
		while(x1 >= 0 && y1 >= 0) {
			if(board[x1][y1] == 1) {
				return true;
			}
			x1--;
			y1--;
		}
		return false;
	}
	
	public boolean containsPosDiag(int[][] board, int x, int y) {
		int x1 = x;
		int y1 = y;
		while(x1 < board.length && y1 >= 0) {
			if(board[x1][y1] == 1) {
				return true;
			}
			x1++;
			y1--;
		}
		x1 = x;
		y1 = y;
		while(x1 >= 0 && y1 < board.length) {
			if(board[x1][y1] == 1) {
				return true;
			}
			x1--;
			y1++;
		}
		return false;
	}
	
	public boolean plotingQueens(int[][] board, int queens, int n) {
		if(queens == n) {
			return true;
		}
		for(int i = n; i < queens; i++) {
			for(int j = 0; j < queens; j++) {
				if(is_attacked(i, j, board)) {
					continue;
				}
				board[i][j] = 1;
				if(plotingQueens(board, queens, n + 1)) {
					return true;
				}
				board[i][j]=0;
			}
		}
		return false;
	}
	
	public void solve() {
		plotingQueens(this.board, this.board.length, 0);
	}
	
	public void print() {
		for(int i = 0; i < this.board.length; i++) {
			for(int j = 0; j < this.board[i].length; j++) {
				System.out.print(this.board[i][j] + ", ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		NQueens queen = new NQueens();
		NQueens queen2 = new NQueens();
		NQueens queen3 = new NQueens();
		
		queen.start(4);
		queen.solve();
		queen.print();
		System.out.println("-----------------------------");
		queen2.start(5);
		queen2.solve();
		queen2.print();
		System.out.println("-----------------------------");
		queen3.start(10);
		queen3.solve();
		queen3.print();
	}
}