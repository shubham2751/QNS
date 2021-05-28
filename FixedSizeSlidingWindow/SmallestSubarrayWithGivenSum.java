package FixedSizeSlidingWindow;

public class SmallestSubarrayWithGivenSum {

	public static void main(String[] args) {

		int arr[] = { 4, 2, 2, 7, 8, 1, 2, 8, 1, 0 };

		int sum = 8;

		System.out.println(minimumSumSubarray(arr, sum, 3));

	}

	public static int minimumSumSubarray(int arr[], int sum, int k) {
		int min = Integer.MAX_VALUE;
		int start = 0;
		int currentSum = 0;

		for (int end = 0; end < arr.length; end++) 
		{
			currentSum += arr[end];

			while (currentSum >= sum) {
				min = Math.min(min, end - start + 1);
				currentSum -= arr[start];
				start++;
			}
			
		}
		
		return min;
	}

}
