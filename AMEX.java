	public static int howmany(String S) {
		int aCount = 0, bCount = 0;
		int count = 0;
		char[] chars = S.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 'a' && bCount == 0) {
				aCount++;
			}
			else if (chars[i] == 'a' && bCount != 0) {
				aCount++;
				bCount = 0;
			}
			else if (chars[i] == 'b' && aCount == 0) {
				bCount++;
			}
			else {
				bCount++;
				aCount = 0;
			}
			
			if (aCount == 3) {
				swap(chars, i, 'a');
				aCount = chars[i] == 'a' ? 1 : 0;
				bCount = chars[i] == 'b' ? 1 : 0;
				count++;
			}
			else if (bCount == 3) {
				swap(chars, i, 'b');
				aCount = chars[i] == 'a' ? 1 : 0;
				bCount = chars[i] == 'b' ? 1 : 0;
				count++;
			}
		}
		return count;
	}
	
	public static void swap(char[] chars, int index, char chartoswap) {
		if (chartoswap == 'a' && chars[index + 1] == 'b') {
			chars[index - 2] = 'b';
		}
		else if (chartoswap == 'a' && chars[index + 1] != 'b') {
			chars[index] = 'b';
		}
		else if (chartoswap == 'b' && chars[index + 1] == 'a') {
			chars[index - 2] = 'a';
		}
		else {
			chars[index] = 'a';
		}
	}
