/** Finds the smallest sub-array with sum 
 *  greater than a given value.
 */

/**
 * @author Ritika Nair
 *
 */
public class SmallestSubarraySum {
	
	public static void main(String[] args) {
		
		int[] arr = {1 , 10, 5, 2, 7};
		int x = 9;
		int result = solution1(arr,x);
		System.out.println(result);
		
	}
	
	public static int solution1(int[] arr, int x) {
		int sumSoFar = 0;
		int index = 0;
		int minSubLen = arr.length;
		
		for(int i=0;i<arr.length;i++) {
			sumSoFar = arr[i];
			if(sumSoFar > x) return 1;
			for(int j=i+1;j<arr.length;j++) {
				sumSoFar += arr[j];
				if(sumSoFar > x) {
					minSubLen = ((j-i+1) < minSubLen) ? (j-i+1) : minSubLen;
					break;
				}
					
			}
				
				
		}
		return minSubLen;
				
		//for (int j=0;j<=index;j++) {
			//System.out.println(arr[j]);
		//}
	}

}
