
public class MaximumSubarray {
	
	public static class Subarray{
		int low;
		int high;
		int sum;
		int[] elements;
		
		Subarray( int[] arr,int left,int right){
			low = left;
			high = right;
			for(int i=low;i<=high;i++) {
				sum  += arr[i];
			}			
			elements = arr;
		}
	}

	public static void main(String[] args) {
		int[] arr = {2,-3,4,-88,-3,6,1,0,9};
		Subarray result = DivideAndConquer(arr,0,arr.length-1);
		System.out.println(String.format("%d : %d ; Sum = %d", result.low,result.high,result.sum));
	}
	
	public static Subarray DivideAndConquer(int[] arr,int low,int high) {
		
		if(high ==low) {
			return new Subarray(arr,low,high);
		}
		else {
			int mid = (low+high)/2;
			Subarray leftSA = DivideAndConquer(arr,low,mid);
			Subarray rightSA = DivideAndConquer(arr,mid+1,high);
			Subarray crossSA = MaxCrossingSubArray(arr,low,mid,high);
			
			if(leftSA.sum >= rightSA.sum && leftSA.sum>=crossSA.sum)
				return leftSA;
			else if (rightSA.sum >= leftSA.sum && rightSA.sum>=crossSA.sum)
				return rightSA;
			else
				return crossSA;
		}
			
		
	}
	
	private static Subarray MaxCrossingSubArray(int[] arr, int low, int mid, int high) {
		
		// find max sub array in left side of mid.
		int leftSum = arr[mid];
		int leftMax = mid;
		for(int i=mid-1;i>=low;i--) {
			if(leftSum + arr[i] > leftSum) {
				leftSum = arr[i] + leftSum;
				leftMax = i;
			}
		}
		
		// find max sub array in right side of mid.
		int rightSum = arr[mid];
		int rightMax = mid;
		for(int i=mid+1;i<=high;i++) {
			if(rightSum + arr[i] > rightSum) {
				rightSum = arr[i] + rightSum;
				rightMax = i;
			}
		}
		
		return new Subarray(arr,leftMax,rightMax);
	}
	
	public void Kadanes() {
		
	}

}
