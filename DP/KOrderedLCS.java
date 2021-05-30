package DP;

import java.util.Arrays;

public class KOrderedLCS {

	public static void main(String[] args) {

		String s1 = "abchd";
		String s2 = "agcfd";

		int k = 2;

		System.out.println(KOrderedLCSRecursion(s1, s2, k, 0, 0));

		int strg[][][] = new int[k + 1][s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++)
				Arrays.fill(strg[i][j], -1);
		}

		System.out.println(KOrderedLCSTopDown(s1, s2, k, 0, 0, strg));

		System.out.println(KOrderedLCSBottomUp(s1, s2, k));

	}

	public static int KOrderedLCSRecursion(String s1, String s2, int k, int vidx1, int vidx2) {
		// Base Case
		if (s1.length() == vidx1 || s2.length() == vidx2)
			return 0;

		int ans = 0;

		if (s1.charAt(vidx1) == s2.charAt(vidx2))
			ans = KOrderedLCSRecursion(s1, s2, k, vidx1 + 1, vidx2 + 1) + 1;
		else {
			int o1 = KOrderedLCSRecursion(s1, s2, k, vidx1, vidx2 + 1);
			int o2 = KOrderedLCSRecursion(s1, s2, k, vidx1 + 1, vidx2);

			int o3 = 0;

			if (k >= 1)
				o3 = KOrderedLCSRecursion(s1, s2, k - 1, vidx1 + 1, vidx2 + 1) + 1;

			ans = Math.max(o1, Math.max(o2, o3));
		}

		return ans;
	}

	public static int KOrderedLCSTopDown(String s1, String s2, int k, int vidx1, int vidx2, int strg[][][]) {
		// Base Case
		if (s1.length() == vidx1 || s2.length() == vidx2)
			return 0;

		if (strg[k][vidx1][vidx2] != -1)
			return strg[k][vidx1][vidx2];

		int ans = 0;

		if (s1.charAt(vidx1) == s2.charAt(vidx2))
			ans = KOrderedLCSTopDown(s1, s2, k, vidx1 + 1, vidx2 + 1, strg) + 1;
		else {
			int o1 = KOrderedLCSTopDown(s1, s2, k, vidx1, vidx2 + 1, strg);
			int o2 = KOrderedLCSTopDown(s1, s2, k, vidx1 + 1, vidx2, strg);

			int o3 = 0;

			if (k >= 1)
				o3 = KOrderedLCSTopDown(s1, s2, k - 1, vidx1 + 1, vidx2 + 1, strg) + 1;

			ans = Math.max(o1, Math.max(o2, o3));
		}

		strg[k][vidx1][vidx2] = ans;
		return ans;
	}

	public static int KOrderedLCSBottomUp(String s1, String s2, int tk) {
		int strg[][][] = new int[tk + 1][s1.length() + 1][s2.length() + 1];

		for (int k = 0; k <= tk; k++) {
			for (int row = s1.length() - 1; row >= 0; row--) {
				for (int col = s2.length() - 1; col >= 0; col--) {
					int ans = 0;

					if (s1.charAt(row) == s2.charAt(col))
						ans = strg[k][row + 1][col + 1] + 1;
					else {
						int o1 = strg[k][row][col + 1];
						int o2 = strg[k][row + 1][col];

						int o3 = 0;

						if (k >= 1)
							o3 = strg[k - 1][row + 1][col + 1] + 1;

						ans = Math.max(o1, Math.max(o2, o3));
					}

					strg[k][row][col] = ans;
				}
			}
		}

		return strg[tk][0][0];
	}

}
