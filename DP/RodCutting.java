package DP;

public class RodCutting {

	public static void main(String[] args) {

		int price[] = { 0, 1, 5, 8, 9, 10, 17, 17, 20 };

		System.out.println(RodCuttingRecursion(price, price.length - 1)); // ans is 22

		int strg[] = new int[price.length];

		System.out.println(RodCuttingTopDown(price, price.length - 1, strg)); // ans is 22

		System.out.println(RodCuttingBottomUp(price)); // ans is 22

	}

	public static int RodCuttingRecursion(int price[], int n) {
		int max = price[n];
		int left = 1;
		int right = n - 1;

		while (left <= right) {
			int fp = RodCuttingRecursion(price, left);
			int sp = RodCuttingRecursion(price, right);

			int total = fp + sp;

			if (total > max)
				max = total;

			left++;
			right--;
		}

		return max;
	}

	public static int RodCuttingTopDown(int price[], int n, int strg[]) {
		if (strg[n] != 0)
			return strg[n];

		int max = price[n];
		int left = 1;
		int right = n - 1;

		while (left <= right) {
			int fp = RodCuttingTopDown(price, left, strg);
			int sp = RodCuttingTopDown(price, right, strg);

			int total = fp + sp;

			if (total > max)
				max = total;

			left++;
			right--;
		}

		strg[n] = max;

		return max;
	}

	public static int RodCuttingBottomUp(int price[]) {
		int strg[] = new int[price.length];

		strg[0] = price[0];
		strg[1] = price[1];

		for (int n = 2; n < strg.length; n++) {
			int max = price[n];

			int left = 1;
			int right = n - 1;

			while (left <= right) {
				int fp = strg[left];
				int sp = strg[right];

				int total = fp + sp;

				if (total > max)
					max = total;

				left++;
				right--;
			}

			strg[n] = max;
		}

		return strg[strg.length - 1];
	}

}
