/* 
 * Given n, find the number of different ways to write n as a sum of 1, 3, 4 (or any list given by client)
 */

public class NSum {
	private int[] numList;	// list containing numbers to use to create any given sum
	
	public NSum(int[] list){
		numList = list;
	}
	
	/**
	 * Finds number of ways to sum to a given number based on list given by client
	 * 
	 * @param num	number to sum to
	 * @return		number of ways to sum to num
	 */
	public int find(int num){
		int[] sums = new int[num+1];
		sums[0] = 1;
		
		for(int i = 1, sumLength = sums.length; i < sumLength; i++){
			int currentNum = i;
			int sumCount = 0; 
			
			for(int z = 0, listLength = numList.length; z < listLength; z++){
				int listNum = numList[z]; 
				
				if(listNum > currentNum){
					continue;
				} else{
					sumCount += sums[currentNum - listNum];
				}
			}
			
			sums[i] = sumCount;
		}
		
		return sums[num];
	}
	
	public static void main(String[] args){
		int[] list = {1,3,4};
		
		NSum testSum = new NSum(list);
		int sumTo = 5;
		int count = testSum.find(sumTo);
		System.out.printf("Number of ways to sum to %d: %d", sumTo, count);
	}
}
