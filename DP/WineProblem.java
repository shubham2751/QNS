package DP;

public class WineProblem {

	public static void main(String[] args) {

//		int arr[] = {2, 3, 5, 1, 4};
//		
//		System.out.println(WineProblemRecursion(arr, 1, 0, arr.length-1)); // ans is 50
//		System.out.println(WineProblemRecursion(arr, 0, arr.length-1)); // ans is 50

		int arr[] = new int[1000];
		for (int i = 0; i < arr.length; i++)
			arr[i] = i;

		int strg[][] = new int[arr.length][arr.length];

		System.out.println(WineProblemTopDown(arr, 0, arr.length - 1, strg)); // ans is 333333000
		
		System.out.println(WineProblemBottomUp(arr)); // ans is 333333000

	}

	public static int WineProblemRecursion(int arr[], int year, int si, int ei) {
		if (si == ei)
			return arr[si] * year;

		int left = WineProblemRecursion(arr, year + 1, si + 1, ei) + arr[si] * year;
		int right = WineProblemRecursion(arr, year + 1, si, ei - 1) + arr[ei] * year;

		int ans = Math.max(left, right);

		return ans;
	}

	public static int WineProblemRecursion(int arr[], int si, int ei) {
		int year = arr.length - (ei - si + 1) + 1;

		if (si == ei)
			return arr[si] * year;

		int left = WineProblemRecursion(arr, si + 1, ei) + arr[si] * year;
		int right = WineProblemRecursion(arr, si, ei - 1) + arr[ei] * year;

		int ans = Math.max(left, right);

		return ans;
	}

	public static int WineProblemTopDown(int arr[], int si, int ei, int strg[][]) {
		int year = arr.length - (ei - si + 1) + 1;

		if (si == ei)
			return arr[si] * year;

		if (strg[si][ei] != 0)
			return strg[si][ei];

		int left = WineProblemTopDown(arr, si + 1, ei, strg) + arr[si] * year;
		int right = WineProblemTopDown(arr, si, ei - 1, strg) + arr[ei] * year;

		int ans = Math.max(left, right);

		strg[si][ei] = ans;

		return ans;
	}

	public static int WineProblemBottomUp(int arr[]) // TC : O(N^2 / 2) = O(N^2) || SC : O(N^2) 
	{
		int n = arr.length;

		int strg[][] = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

//				System.out.println(si + " " + ei);

				// logic same as top down

				int year = arr.length - (ei - si + 1) + 1;

				if (si == ei)
					strg[si][ei] = arr[si] * year;
				else {

					int left = strg[si + 1][ei] + arr[si] * year;
					int right = strg[si][ei - 1] + arr[ei] * year;

					int ans = Math.max(left, right);

					strg[si][ei] = ans;
				}
			}
		}
		
		display(strg);
		
		return strg[0][n-1];
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
