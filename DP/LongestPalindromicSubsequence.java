package DP;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {

		String s = "acdcga";
//		String s = "abcd"; // ans is 1

		System.out.println(LongestPalindromicSubsequenceRecursion(s)); // ans is 5

		System.out.println(LongestPalindromicSubsequenceRecursionVIDX(s, 0, s.length() - 1)); // ans is 5

		System.out.println(LongestPalindromicSubsequenceTopDown(s, 0, s.length() - 1, new int[s.length()][s.length()]));

		System.out.println(LongestPalindromicSubsequenceBottomUp(s));

	}

	public static int LongestPalindromicSubsequenceRecursion(String s) {
		if (s.length() == 0)
			return 0;

		if (s.length() == 1)
			return 1;

		char chf = s.charAt(0);
		char chl = s.charAt(s.length() - 1);

		int ans = 0;

		if (chf == chl) {
			String ros = s.substring(1, s.length() - 1);
			ans = LongestPalindromicSubsequenceRecursion(ros) + 2;
		} else {
			String ros1 = s.substring(1);
			String ros2 = s.substring(0, s.length() - 1);

			int fp = LongestPalindromicSubsequenceRecursion(ros1);
			int sp = LongestPalindromicSubsequenceRecursion(ros2);

			ans = Math.max(fp, sp);
		}

		return ans;

	}

	public static int LongestPalindromicSubsequenceRecursionVIDX(String s, int si, int ei) {
		if (si > ei)
			return 0;

		if (si == ei)
			return 1;

		int ans = 0;

		if (s.charAt(si) == s.charAt(ei)) {
			ans = LongestPalindromicSubsequenceRecursionVIDX(s, si + 1, ei - 1) + 2;
		} else {

			int o1 = LongestPalindromicSubsequenceRecursionVIDX(s, si + 1, ei);
			int o2 = LongestPalindromicSubsequenceRecursionVIDX(s, si, ei - 1);

			ans = Math.max(o1, o2);
		}

		return ans;

	}

	public static int LongestPalindromicSubsequenceTopDown(String s, int si, int ei, int strg[][]) {
		if (si > ei)
			return 0;

		if (si == ei)
			return 1;

		if (strg[si][ei] != 0)
			return strg[si][ei];

		int ans = 0;

		if (s.charAt(si) == s.charAt(ei)) {
			ans = LongestPalindromicSubsequenceTopDown(s, si + 1, ei - 1, strg) + 2;
		} else {

			int o1 = LongestPalindromicSubsequenceTopDown(s, si + 1, ei, strg);
			int o2 = LongestPalindromicSubsequenceTopDown(s, si, ei - 1, strg);

			ans = Math.max(o1, o2);
		}

		strg[si][ei] = ans;

		return ans;

	}

	public static int LongestPalindromicSubsequenceBottomUp(String s) {
		int n = s.length();

		int strg[][] = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

				if (si == ei)
					strg[si][ei] = 1;
				else {
					int ans = 0;

					if (s.charAt(si) == s.charAt(ei))
						ans = strg[si + 1][ei - 1] + 2;
					else {
						int o1 = strg[si + 1][ei];
						int o2 = strg[si][ei - 1];

						ans = Math.max(o1, o2);
					}

					strg[si][ei] = ans;
				}
			}

		}

		return strg[0][n - 1];
	}

}
