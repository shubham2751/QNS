package RecursionCount;

public class MazePathDiagonalCount {

	public static void main(String[] args) {

		System.out.println(mazePathDiagonalCount(0, 0, 2, 2)); // ans is 13

	}
	
	public static int mazePathDiagonalCount(int cr, int cc, int er, int ec)	
	{
		if (cr == er && cc == ec)
			return 1;
		
		if (cr > er || cc > ec)
			return 0;
		
		int ch = mazePathDiagonalCount(cr, cc+1, er, ec);
		int cv = mazePathDiagonalCount(cr+1, cc, er, ec);
		int cd = mazePathDiagonalCount(cr+1, cc+1, er, ec);
		
		return ch + cv + cd;
	}

}
