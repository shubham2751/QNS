package VariableSizeSlidingWindow;

import java.util.HashMap;

public class PickToys {

	public static void main(String[] args) {
		
		String s = "abaccab";
		int k = 2;
		
		pickToys(s, k);
	}
	
	public static void pickToys(String s, int k)
	{
		int start = 0, end, max = 0;
		String res = "";
		
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for (end = 0; end < s.length(); end++)
		{
			char toy = s.charAt(end);
			
			if (end < s.length())
			{
				hm.put(toy, hm.getOrDefault(toy, 0) + 1);
			}
			
			while (hm.size() > k)
			{
				char chAtStart = s.charAt(start);
				
				hm.put(chAtStart, hm.get(chAtStart)-1);
				
				if (hm.get(chAtStart) == 0)
				{
					hm.remove(chAtStart);
				}
				start++;
			}
			
			if (hm.size() == k)
			{
				if (res.length() < end - start + 1)
					res = s.substring(start, end + 1);
				
				max = Math.max(max, end - start + 1);
			}
		}
		
		System.out.println(res);
		System.out.println(max);
	}

}
