/*
 * Given two strings x and y, find the longest common subsequence (LCS) and print its length
 */

public class LCS {
	
	public static int findLCS(String x, String y){
		
		int rowCount = x.length();
		int colCount = y.length();
		
		System.out.println("Length of x (row): " + rowCount);
		System.out.println("Length of y (col): " + colCount);
		
		int[][] strMatrix = new int[rowCount+1][colCount+1];
		strMatrix[0][0] = 0;
		
		for(int col = 1; col <= colCount; col++)
			strMatrix[0][col] = 0;
			
		for(int row = 1; row <= rowCount; row++)
			strMatrix[row][0] = 0;
		
		for(int j = 1; j <= rowCount; j++){
			System.out.println("Current j: " + j);
			char rowChar = x.charAt(j-1);
			
			for(int i = 1; i <= colCount; i++){
				System.out.println("Current i: " + i);
				char colChar = y.charAt(i-1);
	
				if(rowChar == colChar){
					System.out.printf("%s is equal to %s", rowChar, colChar);
					strMatrix[j][i] = 1 + strMatrix[j-1][i-1];
				} else{
					int removeI = strMatrix[j][i-1];
					int removeJ = strMatrix[j-1][i];
					strMatrix[j][i] = Math.max(removeI, removeJ);
				}
			}
		}
		return strMatrix[rowCount][colCount];
	}
	
	public static void main(String[] args){
		String x = "ABCBDAB";
		String y = "BDCABC";
		
		int seqVal = LCS.findLCS(x, y);
		System.out.printf("LCS value of %s and %s is %d", x, y, seqVal);
	}
}
