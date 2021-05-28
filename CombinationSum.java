
// submitted on leetcode
import java.util.ArrayList;

public class CombinationSum {

	public static void main(String[] args) {

		int arr[] = { 3, 12, 9, 11, 6, 7, 8, 5, 4 };
		int amt = 15;

		ArrayList<Integer> temp = new ArrayList<>();

		ArrayList<ArrayList<Integer>> l = new ArrayList<>();

		CombinationSum(arr, amt, 0, temp, l);

		System.out.println(l);

	}

	public static void CombinationSum(int arr[], int amt, int vidx, ArrayList<Integer> temp,
			ArrayList<ArrayList<Integer>> l) {
		if (amt == 0) {
			l.add(new ArrayList<>(temp));
			return;
		}

		if (amt < 0)
			return;

		for (int i = vidx; i < arr.length; i++) {
			temp.add(arr[i]);
			CombinationSum(arr, amt - arr[i], i, temp, l);
			temp.remove(temp.size() - 1); // Backtracking
		}
	}

}
