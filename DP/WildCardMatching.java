package DP;

public class WildCardMatching {

	public static void main(String[] args) {
		
		String src = "abcde";
		String pat = "a****";
		
		System.out.println(WildCardMatchingRecursion(src, pat)); // TRUE
		System.out.println(WildCardMatchingRecursionVidx(src, pat, 0, 0)); // TRUE
		System.out.println(WildCardMatchingTopDown(src, pat, 0, 0, new int[src.length()][pat.length()])); // TRUE
		System.out.println(WildCardMatchingBottomUp(src, pat)); // TRUE
		
	}
	
	public static boolean WildCardMatchingRecursion(String src, String pat)
	{
		if (src.length() == 0 && pat.length() == 0)
			return true;
		
		if (src.length() != 0 && pat.length() == 0)
			return false;
		
		if (src.length() == 0 && pat.length() != 0)
		{
			for (int i = 0; i < pat.length(); i++)
			{
				if (pat.charAt(i) != '*')
					return false;
			}
			
			return true;
		}
		
		char chs = src.charAt(0); // char at src
		char chp = pat.charAt(0); // char at pat
		
		String ros = src.substring(1); // Rest Of src
		String rop = pat.substring(1); // Rest Of pat
		
		boolean ans;
		
		if (chs == chp || chp == '?')
		{
			ans = WildCardMatchingRecursion(ros, rop);
		}
		else if (chp == '*')
		{
			boolean blank = WildCardMatchingRecursion(src, rop);
			boolean multiple = WildCardMatchingRecursion(ros, pat);
			
			ans = blank || multiple;
		}
		else // chs != chp
		{
			ans = false;
		}
		
		return ans;
	}
	
	public static boolean WildCardMatchingRecursionVidx(String src, String pat, int svidx, int pvidx) // TC : O(2^N) || SC : RECUSRION SPACE
	{
		if (src.length() == svidx && pat.length() == pvidx)
			return true;
		
		if (src.length() != svidx && pat.length() == pvidx)
			return false;
		
		if (src.length() == svidx && pat.length() != pvidx)
		{
			for (int i = pvidx; i < pat.length(); i++)
			{
				if (pat.charAt(i) != '*')
					return false;
			}
			
			return true;
		}
		
		char chs = src.charAt(svidx);
		char chp = pat.charAt(pvidx);
		
		boolean ans;
		
		if (chs == chp || chp == '?')
			ans = WildCardMatchingRecursionVidx(src, pat, svidx+1, pvidx+1);
		else if (chp == '*')
		{
			boolean blank = WildCardMatchingRecursionVidx(src, pat, svidx, pvidx+1);
			boolean multiple = WildCardMatchingRecursionVidx(src, pat, svidx+1, pvidx);
			
			ans = blank || multiple;
		}
		else 
		{
			ans = false;
		}
		
		return ans;
	}
	
	public static boolean WildCardMatchingTopDown(String src, String pat, int svidx, int pvidx, int strg[][])
	{
		if (src.length() == svidx && pat.length() == pvidx)
			return true;
		
		if (src.length() != svidx && pat.length() == pvidx)
			return false;
		
		if (src.length() == svidx && pat.length() != pvidx)
		{
			for (int i = pvidx; i < pat.length(); i++)
			{
				if (pat.charAt(i) != '*')
					return false;
			}
			
			return true;
		}
		
		/* NOTE : "That's why we are making int array rather than boolean array"
		 	if '0' is there means answer is not computed
		 	if '1' is there means answer is FALSE
		 	if '2' is there means answer is TRUE
		 */
		
		if (strg[svidx][pvidx] != 0) 
			return (strg[svidx][pvidx] == 2) ? true : false; 
		
		char chs = src.charAt(svidx);
		char chp = pat.charAt(pvidx);
		
		boolean ans;
		
		if (chs == chp || chp == '?')
			ans = WildCardMatchingTopDown(src, pat, svidx+1, pvidx+1, strg);
		else if (chp == '*')
		{
			boolean blank = WildCardMatchingTopDown(src, pat, svidx, pvidx+1, strg);
			boolean multiple = WildCardMatchingTopDown(src, pat, svidx+1, pvidx, strg);
			
			ans = blank || multiple;
		}
		else
			ans = false;
		
		strg[svidx][pvidx] = (ans == true ? 2 : 1);
		
		return ans ;
			
	}
	
	public static boolean WildCardMatchingBottomUp(String src, String pat) // TC : O(length(src) * length(pat)) || SC : O(length(src) * length(pat))
	{
		boolean strg[][] = new boolean[src.length()+1][pat.length()+1];
		
		strg[src.length()][pat.length()] = true;
		
		for (int row = src.length(); row >= 0; row--)
		{
			for (int col = pat.length()-1; col >= 0; col--)
			{
				if (row == src.length())
				{
					if (pat.charAt(col) == '*')
						strg[row][col] = strg[row][col+1];
					else
						strg[row][col] = false;
					
					continue;
				}
				
				char chs = src.charAt(row);
				char chp = pat.charAt(col);
				
				boolean ans;
				
				if (chs == chp || chp == '?')
					ans = strg[row+1][col+1];
				else if (chp == '*')
				{
					boolean blank = strg[row][col+1];
					boolean multiple = strg[row+1][col];
					
					ans = blank || multiple;
				}
				else
					ans = false;
				
				strg[row][col] = ans;
				
			}
		}
		
		for (int i = 0; i < strg.length; i++)
		{
			for (int j = 0; j < strg[0].length; j++)
				System.out.print(strg[i][j] + " ");
			System.out.println();
		}
		
		return strg[0][0];
	}

}
