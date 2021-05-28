package Searching;

public class Selectionsort {

	public static void main(String[] args) {

		int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		selectionSort(arr);

		for (int val : arr)
			System.out.print(val + " ");
	}

	public static void selectionSort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j])
					min = j;
			}

			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}

}
