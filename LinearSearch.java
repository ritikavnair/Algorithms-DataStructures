import java.util.*;

public class LinearSearch {

	public static void main(String[] args) {
		System.out.println("n? : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter n numbers : ");
		for(int i =0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter number to be searched : ");
		int x = sc.nextInt();
		sc.close();

		//int pos = find(x,arr,n);
		int pos = recursiveFind(x,arr,n,0);
		if(pos>=0) {
			System.out.println(x+ " is present at position "+pos);
		}
		else {
			System.out.println(x+" is not present.");
		}
		
	}

	//Performs linear search. Returns position if x is found in arr.
	// Else returns -1.
	private static int find(int x, int[] arr, int n) {
		
		for(int i=0;i<n;i++) {
			if(x==arr[i]) {
				return i+1;
			}				
		}
		return -1;
	}
	
	//Performs Recursive linear search. Returns position if x is found in arr.
	// Else returns -1.
	private static int recursiveFind(int x, int[] arr, int n,int pos) {
		
		if(arr.length==0)
			return -1;
		else {
			if(arr[0]==x)
				return pos+1;
			else				
				return recursiveFind(x,Arrays.copyOfRange(arr, 1, n-1), n-1,pos+1);
				
		}
			
	}
}
