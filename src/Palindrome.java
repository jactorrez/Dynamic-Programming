/*
 * Given a string x, find the minimum number of characters that need to be inserted that need
 * to be inserted to make it a palindrome
 */
public class Palindrome {
	
	public static int findMin(String x){
		int strLen = x.length();
		int[][] matrix = new int[strLen][strLen];
		
		for(int j = 0; j < strLen; j++){
			char charAtJ = x.charAt(j);
			for(int i = strLen-1; i >= 0; i--){
				char charAtI = x.charAt(i);
				
				if((j < i) || (i == j)){
					matrix[j][i] = 0;
				} else if(charAtJ == charAtI) {
					matrix[j][i] = 0;
				} else{
					int appendJ = 1 + matrix[j-1][i];
					int appendI = 1 + matrix[j][i+1];
					int min = Math.min(appendJ, appendI);
					matrix[j][i] = min;
				}
			}
		}
		return matrix[strLen-1][0];
	}
	
	public static void main(String[] args){
		String str = "Ab3bd";
		int val = Palindrome.findMin(str);
		
		System.out.printf("Minimum number of characters to append to %s is %d", str, val);
	}
}
