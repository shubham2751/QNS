package RecursionCount;

public class MazePathCount {

	public static void main(String[] args) {

		System.out.println(mazePathCount(0, 0, 2, 2));

	}

	public static int mazePathCount(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec)
			return 1;

		if (cr > er || cc > ec)
			return 0;

		int ch= mazePathCount(cr, cc + 1, er, ec);
		int cv = mazePathCount(cr + 1, cc, er, ec);
		
		return ch + cv;
	}

}
