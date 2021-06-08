package RecursionCount;

public class BoardPathCount {

	public static void main(String[] args) {
		
		System.out.println(boardPathCount(0, 10)); // ans is 492

	}
	
	public static int boardPathCount(int curr, int end)
	{
		if (curr == end)
			return 1;
		
		if (curr > end)
			return 0;
		
		int count = 0;
		
		for (int dice = 1; dice <= 6; dice++)
		{
			count += boardPathCount(curr + dice, end);
		}
		
		return count;
	}

}
