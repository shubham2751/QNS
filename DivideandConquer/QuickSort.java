package DivideandConquer;

public class QuickSort {

	public static void main(String[] args) {

		int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		quick(arr, 0, arr.length - 1);

		for (int val : arr)
			System.out.print(val + " ");

	}

	public static void quick(int arr[], int low, int high) {
		if (low >= high)
			return;

		int mid = (low + high) / 2;

		int pivot = arr[mid];

		int left = low;
		int right = high;

		while (left <= right) {
			while (arr[left] < pivot)
				left++;

			while (arr[right] > pivot)
				right--;

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}

		quick(arr, low, right);
		quick(arr, left, high);
	}

}
