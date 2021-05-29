package DP;

// Matrix Chain Multiplication
public class MCM {

	public static void main(String[] args) {

//		int arr[] = { 4, 2, 3, 5, 1 };

//		System.out.println(MCMRecursion(arr, 0, arr.length-1));// ans is 29

		int arr[] = new int[1000];
		for (int i = 0; i < arr.length; i++)
			arr[i] = i + 1;

		System.out.println(MCMTopDown(arr, 0, arr.length - 1, new int[arr.length][arr.length])); // ans is -2147334086
		System.out.println(MCMBottomUp(arr)); // ans is -2147334086

	}

	public static int MCMRecursion(int arr[], int si, int ei) {
		// Base Case
		if (si + 1 == ei)
			return 0;

		int min = Integer.MAX_VALUE;

		// k : splits (How n=many slipts are required)
		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMRecursion(arr, si, k); // arr[si] * arr[k]
			int sp = MCMRecursion(arr, k, ei); // arr[k] * arr[ei]

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min)
				min = total;
		}

		return min;
	}

	public static int MCMTopDown(int arr[], int si, int ei, int strg[][]) {
		// Base Case
		if (si + 1 == ei)
			return 0;

		if (strg[si][ei] != 0) // REUSE
			return strg[si][ei];

		int min = Integer.MAX_VALUE;

		// k : splits (How n=many slipts are required)
		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMTopDown(arr, si, k, strg); // arr[si] * arr[k]
			int sp = MCMTopDown(arr, k, ei, strg); // arr[k] * arr[ei]

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min)
				min = total;
		}

		strg[si][ei] = min; // STORE

		return min;
	}

	public static int MCMBottomUp(int arr[]) // TC : O(N^2 / 2) * O(N){FOR K LOOP} = O(N^3) {N^2 / 2 ONLY FILLING UPPER HALF }|| SC : O(N^2)
	{
		int n = arr.length;
		int strg[][] = new int[n][n];

		for (int slide = 1; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

				if (si + 1 == ei)
					strg[si][ei] = 0;
				else {
					int min = Integer.MAX_VALUE;

					// k : Splits
					for (int k = si + 1; k <= ei-1; k++) {
						int fp = strg[si][k];
						int sp = strg[k][ei];

						int sw = arr[si] * arr[k] * arr[ei];

						int total = fp + sp + sw;

						if (total < min)
							min = total;
					}

					strg[si][ei] = min;
				}
			}
		}
		return strg[0][n - 1];
	}

}
