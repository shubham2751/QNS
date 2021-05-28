class queen
{
	static int count = 0;
	public static void main(String args[])
	{	
		boolean board[][] = new boolean[5][5];
		NQueen(board, 0, 0, 0, board.length, "");
	}

	public static void NQueen(boolean board[][], int row, int col, int qpsf, int tq, String ans)
	{

		if (qpsf == tq)
		{	
			System.out.println(++count + " . " + ans);
			return;
		}

		if (row == board.length)
		{
			row += 1;
			col = 0;
		}

		if (col == board[0].length)
			return;

		if (isItSafeToPlaceTheQueen(board, row, col))
		{
			board[row][col] = true;
			NQueen(board, row+1, 0, qpsf+1, tq, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}
		NQueen(board, row, col+1, qpsf, tq, ans);
	}

	public static boolean isItSafeToPlaceTheQueen(boolean board[][], int row, int col)
	{
		int r, c;
		
		// Vertically Up
		r = row - 1;
		c = col;
		
		while (r >= 0)
		{
			if (board[r][c])
				return false;
			r--;
		}
		
		// Horizontally left

		r = row;
		c = col-1;

		while (c >= 0)
		{
			if (board[r][c])
				return false;
			c--;
		}

		// Diagonally left

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
}












































/*
public class queen
{
	public static void main(String[] args) {
		boolean board[][] = new boolean[3][4];
		
		QueenCombinationWRTBox2DKill(board, 0, 0, 0, 3, "");
	}
	
	public static void QueenCombinationWRTBox2DKill(boolean board[][], int row, int col, int qpsf, int tq, String ans)
	{
	    if (qpsf == tq)
	    {
	        System.out.println(ans);
	        return;
	    }
	    
	    if (col == board[0].length)
	    {
	        row += 1;
	        col = 0;
	    }
	    
	    if (row == board.length)
	    {
	        return;
	    }
	    
	    if (isItSafeToPlaceQueen(board, row, col))
	    {
	        board[row][col] = true;
	        QueenCombinationWRTBox2DKill(board, row, col+1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
	        board[row][col] = false;
	    }
	    
	    QueenCombinationWRTBox2DKill(board, row, col+1, qpsf, tq, ans);
	}
	
	public static boolean isItSafeToPlaceQueen(boolean board[][], int row, int col)
	{
		int r, c;
		
		// Vertically up
		r = row-1;
		c = col;
		while (r >= 0)
		{
			if (board[r][c])
				return false;
			r--;
			
		}
		
		// Horizontally left
		r = row;
		c = col-1;
		while (c >= 0)
		{
			if (board[r][c])
				return false;
			c--;
			
		}
		
		// Diagonal left
		r = row-1;
		c = col-1;
		while (r >= 0 && c >= 0)
		{
			if (board[r][c])
				return false;
			r--;
			c--;
			
		}

		// Diagonal right
		r = row-1;
		c = col+1;
		while (r >= 0 && c < board[0].length)
		{
			if (board[r][c])
				return false;
			r--;
			c++;
			
		}
		return true;
	}
}
*/
