package FixedSizeSlidingWindow;

import java.util.ArrayList;

public class MaxAllSubarrayOfSizeK {

	public static void main(String[] args) {

		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
//		int arr[] = { 3, 2, 1, 5 };
		int k = 3;
		
//		ArrayList<Integer> res = new ArrayList<>();
		
		BruteForce(arr, k); //O(N^2)
		
//		System.out.println(res);
		
		maxAllSubarrayOfSizeK(arr, k); // O(N)

	}
	
	public static void BruteForce(int arr[], int k)
	{
		int start = 0;
		int end = 0;
		
		ArrayList<Integer> res = new ArrayList<>();
		
		
		while (end < arr.length)
		{
			if (end - start + 1 < k)
			{
				end++;
			}
			else if (end - start + 1 == k)
			{
				int max = Integer.MIN_VALUE;
				
				for (int i = start ; i <= end; i++)
				{
					max = Math.max(max, arr[i]);
				}
				
				res.add(max);
				start++;
				end++;
			}
		}
		
		System.out.println(res);	
	}
	
	public static void maxAllSubarrayOfSizeK(int arr[], int k)
	{
		int start = 0;
		int end = 0;
		
		ArrayList<Integer> res = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		
		while (end < arr.length)
		{
// add to temp list and remove if arr[end] > elements before are lesser in temp
			// [1]
			// next is 3
			// now remove temp till arr[end] > temp[0] because 1 is not useful
			// [3]
			// next is -1
			// add that one because it may be next greater element after 3
			// [3, -1]
			while (temp.size() > 0 && temp.get(0) < arr[end])
				temp.remove(0);
			
			temp.add(arr[end]);
			
			if (end - start + 1 < k)
			{	
				end++;
			}
			else if (end - start + 1 == k)
			{
				res.add(temp.get(0));
	
				if (temp.get(0) == arr[start])
					temp.remove(0);
				
				start++;
				end++;	
			}	
			
		}
		System.out.println(res);
	}

}
