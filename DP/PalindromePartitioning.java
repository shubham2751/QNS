package DP;
// leetcode
import java.util.Arrays;

public class PalindromePartitioning {

	public static void main(String[] args) {

		String s = "abacdc";
//		String s = "nitin";

		System.out.println(PalindromePartitioningRecursion(s, 0, s.length() - 1)); // ans is 2 for s = abacd || ans is 1
																					// for s = abacdc

		int strg[][] = new int[s.length()][s.length()];

		for (int i = 0; i < strg.length; i++)
			Arrays.fill(strg[i], -1);

		System.out.println(PalindromePartitioningTopDown(s, 0, s.length() - 1, strg));

		System.out.println(PalindromePartitioningBottomUp(s));

	}

	public static int PalindromePartitioningRecursion(String s, int si, int ei) {
		// Base Case
		if (isPalindrome(s, si, ei))
			return 0;

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {
			int fp = PalindromePartitioningRecursion(s, si, k); // fp : first problem
			int sp = PalindromePartitioningRecursion(s, k + 1, ei); // sp : second problem

			int total = fp + sp + 1;

			if (total < min)
				min = total;

		}

		return min;
	}

	public static boolean isPalindrome(String s, int si, int ei) {
		int l = si;
		int r = ei;

		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;

			l++;
			r--;
		}

		return true;
	}

	public static int PalindromePartitioningTopDown(String s, int si, int ei, int strg[][]) {
		if (isPalindrome(s, si, ei))
			return 0;

		if (strg[si][ei] != -1) // -1 because if s is PALINDROME ans is 0
			return strg[si][ei];

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {
			int fp = PalindromePartitioningTopDown(s, si, k, strg);
			int sp = PalindromePartitioningTopDown(s, k + 1, ei, strg);

			int total = fp + sp + 1;

			if (total < min)
				min = total;
		}

		strg[si][ei] = min;

		return min;
	}

	public static int PalindromePartitioningBottomUp(String s) {
		boolean isStringPalindrome[][] = palindromeInfo(s); // used to reduce complexity for line 103 if condition

		int n = s.length();
		int strg[][] = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

//				if (isPalindrome(s, si, ei)) // we use this but complexity increased
//					strg[si][ei] = 0;

				if (isStringPalindrome[si][ei])
					strg[si][ei] = 0;
				else {
					int min = Integer.MAX_VALUE;

					for (int k = si; k <= ei - 1; k++) {
						int fp = strg[si][k];
						int sp = strg[k + 1][ei];

						int total = fp + sp + 1;

						if (total < min)
							min = total;

					}
					strg[si][ei] = min;
				}
			}
		}

		return strg[0][n - 1];
	}

	public static boolean[][] palindromeInfo(String s) {
		boolean isStringPalindrome[][] = new boolean[s.length()][s.length()];

		// filling bydefault with "true"
		// this is done to fill diagonal with "true"
		for (int i = 0; i < isStringPalindrome.length; i++)
			Arrays.fill(isStringPalindrome[i], true);

		for (int row = s.length() - 2; row >= 0; row--) {
			for (int col = row + 1; col < s.length(); col++) {
				if (s.charAt(row) == s.charAt(col)) {
					isStringPalindrome[row][col] = isStringPalindrome[row + 1][col - 1]; // previous diagonal
				} else {
					isStringPalindrome[row][col] = false;
				}
			}
		}

		return isStringPalindrome;
	}
}
