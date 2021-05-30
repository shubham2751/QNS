package DP;

// we are using "CATALAN SERIES" : 0, 1, 2, 3,... => 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, ..
public class NoOfBSTs {

	public static void main(String[] args) {

//		int n = 5;
//
//		System.out.println(NoOfBSTsRecursion(n)); // ans is 42 for n = 5

//		int n = 70;
		int n = 10;
		System.out.println(NoOfBSTsTopDown(n, new int[n + 1])); // ans is 668962456 for n = 70
		System.out.println(NoOfBSTsBottomUp(n)); // ans is 668962456 for n = 70
	}

	public static int NoOfBSTsRecursion(int n) {
		// Base Case
		if (n <= 1)
			return 1;

		int total = 0;

		for (int i = 1; i <= n; i++) {
			int l = NoOfBSTsRecursion(i - 1); // l : left subtree
			int r = NoOfBSTsRecursion(n - i); // r : right subtree

			int ans = l * r;

			total += ans;
		}

		return total;
	}

	public static int NoOfBSTsTopDown(int n, int strg[]) {
		// Base Case
		if (n <= 1)
			return 1;

		if (strg[n] != 0)
			return strg[n];

		int total = 0;

		for (int i = 1; i <= n; i++) {
			int l = NoOfBSTsTopDown(i - 1, strg); // l : left subtree
			int r = NoOfBSTsTopDown(n - i, strg); // r : right subtree

			int ans = l * r;

			total += ans;
		}

		strg[n] = total;
		return total;
	}

	public static int NoOfBSTsBottomUp(int tn) {
		int strg[] = new int[tn + 1];

		strg[0] = 1;
		strg[1] = 1;

		for (int n = 2; n < strg.length; n++) {
			int total = 0;

			for (int i = 1; i <= n; i++) {
				int l = strg[i - 1];
				int r = strg[n - i];

				int ans = l * r;

				total += ans;
			}

			strg[n] = total;
		}
		
		for (int e : strg)
			System.out.print(e + " ");	
		
		return strg[tn];
	}

}
