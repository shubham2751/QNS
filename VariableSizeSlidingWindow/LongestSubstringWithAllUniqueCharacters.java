package VariableSizeSlidingWindow;
// code submitted on leetcode
import java.util.HashMap;

public class LongestSubstringWithAllUniqueCharacters {

	public static void main(String[] args) {
		
//		String s = "abcd";
//		String s = "pewwkeg";
//		String s = "abcabcbb";
//		String s = "bbbbb";
		String s = "abcdefgh";
		
		System.out.println(longestSubstringWithAllUniqueCharacters(s));
//		System.out.println(res);
	}
//	static String res = "";
	
	public static int longestSubstringWithAllUniqueCharacters(String s)
	{
		int start = 0, end = 0, max = 0;
		String res = "";
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for (end = 0; end < s.length(); end++)
		{
			char ch = s.charAt(end);
			
			if (end < s.length())
			{
				hm.put(ch, hm.getOrDefault(ch, 0)+1);
			}
			
			
			while (hm.get(ch) > 1)// && start < end) 
			{
				char chAtStart = s.charAt(start);

				hm.put(chAtStart, hm.get(chAtStart)-1);
				
				if (hm.get(chAtStart) == 0)
				{
					hm.remove(chAtStart);
				}
				start++;
			}
			
			if (max < end - start + 1)
			{
				if (res.length() < end - start + 1)
					res = s.substring(start, end+1);
				max = end - start + 1;
			}
	
		}
		
		System.out.println(res);
		return max;
		
	}
}
