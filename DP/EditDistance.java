package DP;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {

		String s1 = "saturday";
		String s2 = "sunday";

		System.out.println(EditDistanceRecursion(s1, s2)); // ans is 3
		System.out.println(EditDistanceRecursionVIDX(s1, s2, 0, 0)); // ans is 3

		int strg[][] = new int[s1.length()][s2.length()];

		for (int i = 0; i < strg.length; i++)
			Arrays.fill(strg[i], -1);

		System.out.println(EditDistancetTopDown(s1, s2, 0, 0, strg)); // ans is 3

		System.out.println(EditDistancetBottomUp(s1, s2));

	}

	public static int EditDistanceRecursion(String s1, String s2) {
		// BASE CASE
		if (s1.length() == 0 || s2.length() == 0)
			return Math.max(s1.length(), s2.length());

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistanceRecursion(ros1, ros2);
		} else {
			int i = EditDistanceRecursion(ros1, s2);
			int d = EditDistanceRecursion(s1, ros2);
			int r = EditDistanceRecursion(ros1, ros2);

			ans = Math.min(i, Math.min(d, r)) + 1; // + 1 is for the operations {i, d, r}

		}

		return ans;
	}

	public static int EditDistanceRecursionVIDX(String s1, String s2, int vidx1, int vidx2) // TC : O(3 ^ (M * N) || SC : (M + N) + EXTRA RECURSION SPACE
	{
		// BASE CASE
		if (s1.length() == vidx1 || s2.length() == vidx2)
			return Math.max(s1.length() - vidx1, s2.length() - vidx2);

		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

//		String ros1 = s1.substring(1);
//		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistanceRecursionVIDX(s1, s2, vidx1 + 1, vidx2 + 1);
		} else {
			int i = EditDistanceRecursionVIDX(s1, s2, vidx1 + 1, vidx2);
			int d = EditDistanceRecursionVIDX(s1, s2, vidx1, vidx2 + 1);
			int r = EditDistanceRecursionVIDX(s1, s2, vidx1 + 1, vidx2 + 1);

			ans = Math.min(i, Math.min(d, r)) + 1; // + 1 is for the operations {i, d, r}

		}

		return ans;
	}

	public static int EditDistancetTopDown(String s1, String s2, int vidx1, int vidx2, int strg[][])// TC : O(M * N) || SC : O(M * N) + EXTRA RECURSION SPACE  
	{
		// BASE CASE
		if (s1.length() == vidx1 || s2.length() == vidx2)
			return Math.max(s1.length() - vidx1, s2.length() - vidx2);

		if (strg[vidx1][vidx2] != -1) // RE-Use { 0 can be ans so compared with -1 } Eg : a,a => "", ""
			return strg[vidx1][vidx2];

		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

//		String ros1 = s1.substring(1);
//		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistancetTopDown(s1, s2, vidx1 + 1, vidx2 + 1, strg);
		} else {
			int i = EditDistancetTopDown(s1, s2, vidx1 + 1, vidx2, strg);
			int d = EditDistancetTopDown(s1, s2, vidx1, vidx2 + 1, strg);
			int r = EditDistancetTopDown(s1, s2, vidx1 + 1, vidx2 + 1, strg);

			ans = Math.min(i, Math.min(d, r)) + 1; // + 1 is for the operations {i, d, r}

		}

		strg[vidx1][vidx2] = ans; // store

		return ans;
	}

	public static int EditDistancetBottomUp(String s1, String s2) // TC : O(M * N) || SC : O(M * N)
	{
		int strg[][] = new int[s1.length() + 1][s2.length() + 1];

		// filling bottom to top and right to left
		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {
				// base case : deletion ops {col wise (last col) }
				if (row == s1.length())
					strg[row][col] = s2.length() - col;
				// base case : insertion ops {row wise (last row) }
				else if (col == s2.length())
					strg[row][col] = s1.length() - row;
				// you are filling some intermediate cell
				else {
					if (s1.charAt(row) == s2.charAt(col))
						strg[row][col] = strg[row + 1][col + 1]; // fetch diagonal
					else {
						int i = strg[row + 1][col]; // bottom fetch
						int d = strg[row][col + 1]; // right fetch
						int r = strg[row + 1][col + 1]; // diagonal fetch

						strg[row][col] = Math.min(i, Math.min(d, r)) + 1;
					}
				}

			}
		}
		
		display(strg);
		return strg[0][0];
	}
	
	public static void display(int strg[][])
	{
		for (int val[] : strg)
		{
			for (int e : val)
				System.out.print(e + " ");
			System.out.println();
		}
	}

}
