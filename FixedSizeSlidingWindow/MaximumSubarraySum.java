package FixedSizeSlidingWindow;

public class MaximumSubarraySum {

	public static void main(String[] args) {

//		int arr[] = {1, 3, 4, 2, 6, 3};

		int arr[] = { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 };

		int k = 3;
		
		System.out.println(NaiveApproach(arr, k));

		System.out.println(slidingWindow(arr, k));
		
		System.out.println(slidingWindowSamjhNeWala(arr, k));

	}
	
	public static int NaiveApproach(int arr[], int k)
	{
		int maxsum = Integer.MIN_VALUE;
				
		for (int i = 0; i <= arr.length-3; i++)
		{
			int CurrentSum = 0;
			for (int j = i; j < i+3; j++)
			{
				CurrentSum += arr[j];
			}
			
			maxsum = Math.max(maxsum, CurrentSum);
		}
		return maxsum;
	}
	
	public static int slidingWindowSamjhNeWala(int arr[], int k)
	{
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		int start = 0;
		int end = 0;
		
		while (end < arr.length)
		{
			currentSum = currentSum + arr[end];
					
			if (end - start + 1 < k) // To REACH window size k
			{
				end++;
			}
			else if (end - start + 1 == k) // To MAINTAIN window size k
			{
				maxSum = Math.max(maxSum, currentSum);
				currentSum = currentSum - arr[start];
				start++;
				end++;
			}
		}
		
		return maxSum;
	}

	public static int slidingWindow(int arr[], int k) {
		int max = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int start = 0; start < arr.length; start++) {
			currentSum += arr[start];

			if (start >= k - 1) // IMPORTANT
			// 0 > 3-1 = 0 >= 2 no, 1 >= 3-1 = 1 >= 2 no, 2 >= 3-1 = 2 >= 2 yes
			{
				max = Math.max(max, currentSum);
				currentSum -= arr[start - k + 1]; // formula (start-end+1)

			}
		}

//		System.out.println();
		return max;
	}

}
