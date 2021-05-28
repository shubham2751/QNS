package FixedSizeSlidingWindow;

import java.util.ArrayList;

public class FirstNegativeNumber {

	public static void main(String[] args) {
		
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
		
		int k = 3;
		
		BruteForce(arr, k);
		
		System.out.println();
		
		firstNegative(arr, k);
		
		System.out.println();
		
		firstNegativeOptimized(arr, k);

	}
	
	public static void BruteForce(int arr[], int k)
	{
		for (int start = 0; start <= arr.length-3; start++)
		{
			boolean flag = true;
			for (int end = start; end < start+3; end++)
			{
				
				if (arr[end] < 0)
				{
					System.out.print(arr[end] + " ");
					flag = false;
					break;
				}
			}
			
			if (flag == true)
				System.out.print(Integer.parseInt("0"));
		}
	}
	
	public static void firstNegative(int arr[], int k)
	{
		int start = 0;
		int end = 0;
		
		while (end < arr.length)
		{
			if (end - start + 1 < k)
			{
				end++;
			}
			else if (end - start + 1 == k)
			{
				// i ==> start;
				// j ==> end;
				
				boolean flag = true;
				
				for (int i = start; i <= end; i++)
				{
					if (arr[i] < 0)
					{
						System.out.print(arr[i] + " ");
						flag = false;
						break;
					}	
				}	
				
				if (flag == true)
					System.out.print(Integer.parseInt("0") + " ");
				
				start++;
				end++;
			}
		}
		
	}
	
	public static void firstNegativeOptimized(int arr[], int k)
	{
		int start = 0;
		int end = 0;
		
		ArrayList<Integer> temp = new ArrayList<>();
		ArrayList<Integer> res = new ArrayList<>();
		
		while (end < arr.length)
		{
			if (arr[end] < 0)
				temp.add(arr[end]);
				
			if (end - start + 1 < k)
			{
				end++;
			}
			else if (end - start + 1 == k)
			{
				if (temp.size() == 0)
					res.add(0);
				else
				{
					res.add(temp.get(0));
					if (temp.get(0) == arr[start])
						temp.remove(0);	
				}
				
				start++;
				end++;
	
			}
		}
		
		System.out.println(res);
		
	}

}
