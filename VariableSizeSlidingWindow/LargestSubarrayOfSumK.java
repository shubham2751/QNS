package VariableSizeSlidingWindow;

public class LargestSubarrayOfSumK {

	public static void main(String[] args) 
	{	
		
// 		int arr[] = {1, 4, 20, 3, 10, 5};
// 		int sum = 33; // output = 3
//		
// 		int arr[] = {1, 4, 0, 0, 3, 10, 5};
// 		int sum = 7; // output = 4
//
//        int arr[] = {4, 1, 1, 1, 2, 3, 5};
//        int sum = 5; // output = 4
        
        int arr[] = {1, 2, 3, 7, 5};
		int sum = 12; // output = 3
		
		System.out.println(largestSubarrayOfSumK(arr, sum) + "ans");

	}
	
	// gfg : Find the Subarray with given sum (Non - Negative Values)
	// Manipulated as per the need by MySelf
	public static int largestSubarrayOfSumK(int arr[], int sum) 
	{
	    int cs = 0, start = 0, k = 0, end ;	
	    
	    for (end = 0; end < arr.length; end++)
	    {
	    	if (end < arr.length)
	        {
	            cs += arr[end];
	        }
	    	
	    	// if cs > sum
	    	while (cs > sum)// && start < end - 1)
	        {
	            cs -= arr[start];
	            start++;
	        }
	    	
	    	if (cs == sum)
	        {
	            System.out.println(start + " " + end);
	            k = Math.max(k, end - start + 1);
	        }
	    	    
	    }
	    
	    return k;
	    
	}
	
}
