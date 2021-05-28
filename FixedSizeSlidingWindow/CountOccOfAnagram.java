package FixedSizeSlidingWindow;

import java.util.HashMap;

public class CountOccOfAnagram {

	public static void main(String[] args) {
		
		String s = "aabaabaa";
		
		String p = "aaba";
		
		HashMap<Character, Integer> h = new HashMap<>();
		int count = 0;
		
		for (int i = 0; i < p.length(); i++)
		{
			char ch = s.charAt(i);
			
			if (h.containsKey(ch))
				h.replace(ch, h.get(ch)+1);
			else
			{
				h.put(ch, 1);
				count += 1;
			}
				
		}
		System.out.println(h);
//		System.out.println(count);
		
		System.out.println(countOccOfAnagrams(s, p, h, count, p.length()));

	}
	
	public static int countOccOfAnagrams(String s, String p, HashMap<Character, Integer> h, int count, int k)
	{
		int ans = 0;
		
		int start = 0, end = 0;
		
		while (end < s.length())
		{
			char ch = s.charAt(end);
			
			if (h.containsKey(ch))
			{
				h.put(ch, h.get(ch) - 1);
			}
			
			if (h.get(ch) == 0)
				count-=1;
			
			if (end - start + 1 < k)
				end++;
			
			else if (end - start + 1 == k)
			{
				if (count == 0)
				{
					ans += 1;
				}
				
				if (h.containsKey(s.charAt(start)))
				{
					h.replace(s.charAt(start), h.get(s.charAt(start))+1);
					
					if (h.get(s.charAt(start)) == 1)
						count+=1;
				}
				
				start++;
				end++;
							
			}
		}
		
		return ans;
		
	}

}

/*
def solve(s, p, d, count, k):
    
    start = 0
    end = 0
    
    ans = 0
    
    print(s, p, d, count, k)
    
    while (end < len(s)):
        
        ch = s[end]
        
        if ch in d:
            d[ch] -= 1
            
        if d[ch] == 0:
            count-=1
        
        if end - start + 1 < k:
            end += 1
            
        elif end - start + 1 == k:
            # print("enter", count, d)
            
            if count == 0:
                ans += 1
                
            if s[start] in d:
                d[s[start]] += 1
                
                if d[s[start]] == 1:
                    count += 1
            start+=1
            end += 1
            

    return ans


s = "aabaabaa"
p = "aaba"

count = 0

k = len(p)

global d
d = {}

for e in p:
    
    if e in d:
        d[e] += 1
    else:
        count+=1
        d[e] = 1

print(d)
print(solve(s, p, d, count, k))
print(d)

 */

