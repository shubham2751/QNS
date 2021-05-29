package DP;

// 0/1 knapsack
public class knapsack {

	public static void main(String[] args) {

//		int wt[] = { 1, 3, 4, 5 };
//		int price[] = { 1, 4, 5, 7 };
//		int cap = 7;
//		int vidx = 0;
//
//		System.out.println(knapsackRecursion(wt, price, vidx, cap)); // ans is 9

		int wt[] = new int[1000];
		int price[] = new int[1000];
		int cap = 70;
		int vidx = 0;

		for (int i = 0; i < wt.length; i++) {
			wt[i] = i + 1;
			price[i] = i + 1;
		}

		long start = System.currentTimeMillis();
		System.out.println(knapsackTopDown(wt, price, vidx, cap, new int[wt.length][cap + 1])); // ans is 70
		System.out.println(knapsackBottomUp(wt, price, cap)); // ans is 70
		long end = System.currentTimeMillis();

		System.out.println(end - start);
	}

	public static int knapsackRecursion(int wt[], int price[], int vidx, int cap) {
		if (vidx == wt.length || cap == 0)
			return 0;

		// exclude
		int e = knapsackRecursion(wt, price, vidx + 1, cap);

		// include
		int i = 0;
		if (cap >= wt[vidx])
			i = knapsackRecursion(wt, price, vidx + 1, cap - wt[vidx]) + price[vidx];

		int ans = Math.max(e, i);

		return ans;
	}

	public static int knapsackTopDown(int wt[], int price[], int vidx, int cap, int strg[][]) {
		if (vidx == wt.length || cap == 0)
			return 0;

		if (strg[vidx][cap] != 0)
			return strg[vidx][cap];

		// exclude
		int e = knapsackTopDown(wt, price, vidx + 1, cap, strg);

		// include
		int i = 0;
		if (cap >= wt[vidx])
			i = knapsackTopDown(wt, price, vidx + 1, cap - wt[vidx], strg) + price[vidx];

		int ans = Math.max(e, i);

		strg[vidx][cap] = ans; // Store

		return ans;
	}

	public static int knapsackBottomUp(int wt[], int price[], int cap) {
		int n = wt.length;
		int strg[][] = new int[n + 1][cap + 1];

		for (int row = n - 1; row >= 0; row--) {
			for (int col = 1; col <= cap; col++) {
				int e = strg[row + 1][col];

				int i = 0;
				if (col >= wt[row])
					i = strg[row + 1][col - wt[row]] + price[row];
				
				int ans = Math.max(e,  i);
				
				strg[row][col] = ans;
			}
		}
		
		return strg[0][cap];
	}

}
