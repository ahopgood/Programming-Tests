
public class AnagramOfPalindroneTest {
	public static void main(String[] args){
		String palindrome1 = "kayak";
		String paldindrome2 = "codilitytilidoc";
		AnagramOfPalindroneTest sol = new AnagramOfPalindroneTest();
		System.out.println(sol.isAnagramOfPalindrome(palindrome1));
	}
	
	public int isAnagramOfPalindrome ( String S ) {
		char marker = '*';
		boolean singleChar = false;
		char[] chars = S.toCharArray();
		for (int i = 0; i < chars.length; i++){
			if (chars[i] == marker){
				//don't look for an index of our marker, we won't find it
			} else {
				char c 		= S.charAt(i);
				int found 	= S.indexOf(c, i+1);
				if (found == -1){
					//no luck
					if (!singleChar){
						singleChar = true;
						chars[i] = marker;
					} else {
						return 0;
						//can't be a palindone if it has more than one lone character without forming part of a matching pair
					}
				} else {
					chars[i]		= marker;
					chars[found]	= marker;
				}
			}

		}
		String result = new String(chars);
		result.replace(marker, ' ');
		result.trim();
		if (result.length() > 0){
			return 1;
		} else {
			return 0;
		}
	}
}