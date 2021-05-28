package VariableSizeSlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacter {

	public static void main(String[] args) {
		
//		String s = "aabacbebebe";
//		int k = 3; //unquieChar
		String s = "aabcbcdbca";
		int k = 2; //unquieChar
//		String s = "aaaa";
//		int k = 1; //unquieChar
		longestSubstringWithKUniqueCharacter(s, k);
		System.out.println(res);

	}
	
	static String res = "";
	
	public static void longestSubstringWithKUniqueCharacter(String s, int k)
	{
		int start = 0, end, max = -1;
		
		HashMap<Character, Integer> h = new HashMap<>();
		
		for (end = 0; end < s.length(); end++)
		{
			char ch = s.charAt(end);
			
			if (h.size() < s.length())
			{
				if (h.containsKey(ch))
					h.put(ch, h.get(ch) + 1);
				else
					h.put(ch, 1);
			}
			
			
			while (h.size() > k)// && start < end-1)
			{
				char chAtStart = s.charAt(start);
				h.put(chAtStart, h.get(chAtStart)-1);
				
				if (h.get(chAtStart) == 0)
					h.remove(chAtStart);
				
				start++; 
			}
			
			if (h.size() == k)
			{			
				if (max < end - start + 1)
				{
					max = end - start + 1;
					res = s.substring(start, end + 1);
				}
			
			}
		}
		
		System.out.println(max);
	}

}
