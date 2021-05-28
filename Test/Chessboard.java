package Test;

public class Chessboard {

	public static void main(String[] args) {
		
		int n = 3;
		
		boolean v[][] = new boolean[3][3];
		
		solve(v, 0, 0, 0, 3, "");

	}
	
	public static void solve(boolean v[][], int row, int col, int qpsf, int tq, String ans)
	{
		if (qpsf == tq)
		{
			System.out.print(ans + " ");
			return;
		}
		
		if (row == v.length)
		{
			row += 1;
			col = 0;
		}

		if (col == v[0].length)
			return;
		
		if (isSafeToPlaceTheKnight(v, row, col))
		{
			v[row][col] = true;
			solve(v, row, col+1, qpsf+1, tq, ans + "{" + row + "-" + col + "}K");
			v[row][col] = false;
		}
		
		solve(v, row, col+1, qpsf, tq, ans);
		
		if (row == 0 || col == v[0].length)
		{
			if (isSafeToPlaceTheRook(v, row, col))
			{
				v[row][col] = true;
				solve(v, row, col+1, qpsf+1, tq, ans + "{" + row + "-" + col + "}R");
				v[row][col] = false;
			}
			
			solve(v, row, col+1, qpsf, tq, ans);
		}
		
		if (row == col)
		{
			if (isSafeToPlaceTheBishop(v, row, col))
			{
				v[row][col] = true;
				solve(v, row, col+1, qpsf+1, tq, ans + "{" + row + "-" + col + "}B");
				v[row][col] = false;
			}
			
			solve(v, row, col+1, qpsf, tq, ans);
		}
			
	}
	
	public static boolean isSafeToPlaceTheBishop(boolean[][] board, int row, int col) {
		
		int r;
		int c;
		
		r = row - 1;
		c = col - 1;
		
		while (r >= 0 && c >= 0)
		{
			if (board[r][c])
				return false;
			r--;
			c--;
		}

		// Diagonally Right

		r = row - 1;
		c = col + 1;

		while (r >= 0 && c > board[0].length)
		{
			if (board[r][c])
				return false;
			r--;
			c++;
		}
		
		return true;
	}

	public static boolean isSafeToPlaceTheKnight(boolean board[][], int row, int col)
	{
		int rowArr[] = {-1, -2, -2, -1};
		int colArr[] = {2, 1, -1, -2};

		for (int i = 0; i < 4; i++)
		{
			int r = row + rowArr[i];
			int c = col + colArr[i];
			
			if (r >= 0 && r < board.length && c >= 0 && c < board[0].length)
			{
				if (board[r][c])
					return false;
			}	
		}
		
		return true;		
	}
	
	public static boolean isSafeToPlaceTheRook(boolean board[][], int row, int col)
	{
		int r;
		int c;
		
		r = row - 1;
		c = col;
		
		while (r >= 0)
		{
			if (board[r][c])
				return false;
			
			r--;
		}
		
		r = row;
		c = col-1;
		
		while (c >= 0)
		{
			if (board[r][c])
				return false;
			c--;
		}
		
		return true;
			
	}

}
