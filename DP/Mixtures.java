package DP;

import java.util.Arrays;

public class Mixtures {

	public static void main(String[] args) {
		
		int arr[] = {40, 60, 20, 50};
		
		System.out.println(MixturesRecursion(arr, 0, arr.length-1)); // ans is 3400
		
		int strg[][] = new int[arr.length][arr.length];
		
		for (int i = 0; i < strg.length; i++)
			Arrays.fill(strg[i], -1);
		
		System.out.println(MixturesTopDown(arr, 0, arr.length-1, strg)); // ans is 3400
		
		System.out.println(MixturesBottomUp(arr)); // ans is 3400

	}
	
	public static int MixturesRecursion(int arr[], int si, int ei)
	{
		if (si == ei)
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		for (int k = si; k <= ei-1; k++)
		{
			int fp = MixturesRecursion(arr, si, k);
			int sp = MixturesRecursion(arr, k+1, ei);
			
			int sw = colors(arr, si, k) * colors(arr, k+1, ei);
			
			int total = fp + sp + sw;
			
			if (total < min)
				min = total;
		}
		
		return min;
	}
	
	public static int colors(int arr[], int i, int j)
	{
		int sum = 0;
		
		for (int k = i; k <=j; k++)
			sum += arr[k];
		
		return sum % 100;
	}
	
	
	public static int MixturesTopDown(int arr[], int si, int ei, int strg[][])
	{
		if (si == ei)
			return 0;
		
		if (strg[si][ei] != -1) // 0 can be ans
			return strg[si][ei];
		
		int min = Integer.MAX_VALUE;
		
		for (int k = si; k <= ei-1; k++)
		{
			int fp = MixturesTopDown(arr, si, k, strg);
			int sp = MixturesTopDown(arr, k+1, ei, strg);
			
			int sw = colors(arr, si, k) * colors(arr, k+1, ei);
			
			int total = fp + sp + sw;
			
			if (total < min)
				min = total;
		}
		
		strg[si][ei] = min;
		return min;
	}
	
	public static int MixturesBottomUp(int arr[])
	{
		int n = arr.length;
		int strg[][] = new int[n][n];
		
		for (int slide = 0; slide <= n-1; slide++)
		{
			for (int si = 0 ; si <= n-slide-1; si++)
			{
				int ei = si + slide;
				
				if (si == ei)
					strg[si][ei] = 0;
				else
				{
					int min = Integer.MAX_VALUE;
					
					for (int k = si; k <= ei-1; k++)
					{
						int fp = strg[si][k];
						int sp = strg[k+1][ei];
						
						int sw = colors(arr, si, k) * colors(arr, k+1, ei);
						
						int total = fp + sp + sw;
						
						if (total < min)
							min = total;
					}
					
					strg[si][ei] = min;
				}
			}
		}
		
		return strg[0][n-1];
		
	}

}
