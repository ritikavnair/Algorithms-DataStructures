import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr = {23,78,78,68,45};
		int n = 5;
		
		for(int i=0;i<n-1;i++) {
			int small = i;
			for(int j = i+1;j<n;j++) {
				if(arr[j]<arr[small])
					small = j;
			}
			
			// Swap ith number with smallest number.
			int temp = arr[i];
			arr[i] = arr[small];
			arr[small] = temp;
		}
		
		Arrays.stream(arr).forEach(x-> System.out.println(x));

	}

}
