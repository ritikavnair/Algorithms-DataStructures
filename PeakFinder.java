import java.util.Arrays;

public class PeakFinder {

	public static void main(String[] args) {
		
		// Find peak in a 1D array
		int[] arr = {3,1,0,1,6,7,8};
		int size = arr.length;
		System.out.println("1D Array : \n");
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}		
		System.out.println("\n1D Peak : " + find1DPeak(arr)+"\n");
		
		// Find peak in a 2D array
		int[][] matr = {{2,4,3,1,5},{9,5,1,2,3},{8,7,6,5,1},{2,2,1,4,9},{8,3,5,1,1}};
		int m =5;
		int n = 5;
		System.out.println("\n2D Array : \n");
		for(int i =0;i<m;i++) {
			
			for(int j = 0;j<n;j++)
			{
				System.out.print(matr[i][j] + " ");
			}
			System.out.println("");
		}		
		System.out.println("2D Peak : "+find2DPeak(matr, m ,n,(n-1)/2));

	}
	
	public static int find1DPeak(int[] arr) {
		
		int mid = arr.length/2;
		if(mid>0 && arr[mid-1]> arr[mid])
			return find1DPeak(Arrays.copyOfRange(arr, 0, mid));
		else if(mid>0 && arr[mid+1]> arr[mid])
			return find1DPeak(Arrays.copyOfRange(arr, mid+1, arr.length));
		else
			return arr[mid];
		
	}
	
	public static int find2DPeak(int[][] arr, int m, int n,int midColumn) {
		
		int max_i=0;
		int max_j=midColumn;
		int max = arr[max_i][max_j];
		// find maximum in this column
		for(int k=1;k<m;k++) {
			if(arr[k][midColumn]>max) {
				max = arr[k][midColumn];
				max_i = k;
			}			
		}
		
		if(max_j>0 && arr[max_i][max_j-1] > arr[max_i][max_j]) {
			return find2DPeak(arr, m ,n, max_j-1);
		}
		else if (max_j<n-1 && arr[max_i][max_j+1] > arr[max_i][max_j]) {
			return find2DPeak(arr, m ,n, max_j+1);
		}
		else
			return arr[max_i][max_j];			
				
	}

}
