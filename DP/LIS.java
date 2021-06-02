package DP;

import java.util.Arrays;

public class LIS // Longest Increasing Subsequence Leetcode
{
	public static void main(String[] args) {

		int arr[] = { 3, 4, -1, 0, 6, 2, 3 };
		System.out.println(LISBottomUp(arr));
		
		System.out.println(LISBottomUp2(arr));

	}

	public static int LISBottomUp(int arr[]) // TC : O(N^2) || SC : O(N)
	{
		if (arr.length == 0)
			return 0;

		int max = Integer.MIN_VALUE;
		int strg[] = new int[arr.length];

		Arrays.fill(strg, 1);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					strg[i] = Math.max(strg[i], strg[j] + 1);
					max = Math.max(max, strg[i]);
				}
			}
		}

//		for (int e : strg)
//			System.out.print(e + " ");
//		System.out.println();

		return max;
	}

	public static int LISBottomUp2(int arr[]) // TC : O(N.LOG(N)) || SC : O(N)
	{
		int le[] = new int[arr.length];

		le[0] = arr[0];

		int len = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > le[len - 1]) {
				le[len] = arr[i];
				len++;
			} 
			else {
				int idx = BinarySearch(le, 0, len-1, arr[i]);
				
				le[idx] = arr[i];
			}
			
			System.out.print(arr[i] + " : ");
			for (int val : le)
				System.out.print(val + " ");
			System.out.println();
		}
		
		return len;
	}

	public static int BinarySearch(int le[], int si, int ei, int item) {
		int low = si;
		int high = ei;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (item > le[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}

		return low;
	}

}
