package DivideandConquer;

// TC : O(N*LOGN) SC : O(N) : Not In-Place

public class MergeSort {
	
	public static void main(String[] args) {
		
		int arr[] = {80, 10, 50, 30, 60, 20, 70, 25};
		
		int res[] = mergeSort(arr, 0, arr.length-1);
		
		for (int val : res)
			System.out.print(val + " ");
		
	}
	
	public static int[] mergeTwoSortedArray(int one[], int two[])
	{
		int res[] = new int[one.length + two.length];
		
		int i = 0;
		int j = 0;
		
		int k = 0;
		
		while (i < one.length && j < two.length)
		{
			if (one[i] < two[j])
			{
				res[k] = one[i];
				i++;
				k++;
			}
			else
			{
				res[k] = two[j];
				j++;
				k++;
			}
		}
		
		while (i < one.length)
		{
			res[k] = one[i];
			i++;
			k++;
		}
		
		while (j < two.length)
		{
			res[k] = two[j];
			j++;
			k++;
		}
		
		return res;
	}
	
	public static int[] mergeSort(int arr[], int low, int high)
	{
		if (low == high)
		{
			int br[] = new int[1];
			br[0] = arr[low];
			
			return br;
		}
		
		int mid = (low + high) / 2;
		
		int left[] = mergeSort(arr, low, mid);
		int right[] = mergeSort(arr, mid+1, high);
		
		int res[] = mergeTwoSortedArray(left, right);
		
		return res;
	}
}
