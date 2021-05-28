package VariableSizeSlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		
//		String s = "toxc";
//		String p = "toc";

		String s = "ADOBECODEBANC";
		String p = "ABC";
		
//		String s = "a";
//		String p = "a";
		HashMap<Character, Integer> hmp = new HashMap<>();
		
		for (int i = 0; i < p.length(); i++)
			hmp.put(p.charAt(i), hmp.getOrDefault(p.charAt(i), 0)+1);
		
		System.out.println(hmp);
		
		
		minimumWindowSubstring(s, p, hmp, hmp.size());

	}
	
	public static void minimumWindowSubstring(String s, String p, HashMap<Character, Integer> hmp, int count)
	{
		System.out.println(s + " " + p + " " +  hmp + " " +  count);
		
		int start = 0, end, min = Integer.MAX_VALUE;
		
		String res = "";
		
		for (end = 0; end < s.length(); end++)
		{
			char ch = s.charAt(end);
			
			if (hmp.containsKey(ch))
			{
				hmp.put(ch, hmp.get(ch)-1);
				
				if (hmp.get(ch) == 0)
					count -= 1;
			}	
				
			while (start <= end && count == 0)
			{
				char chAtStart = s.charAt(start);
				
				if (hmp.containsKey(chAtStart))
				{
					hmp.put(chAtStart, hmp.get(chAtStart)+ 1);
					
					if (hmp.get(chAtStart) == 1)
						count+=1;
					
				}
				
				if (min > end - start + 1)
				{
					
					res = s.substring(start, end + 1);
					
					min = Math.min(min, end - start + 1);
				}
				
				start++;
						
			}
			
			
		}
		System.out.println(res);
		System.out.println(min);
	}

}
