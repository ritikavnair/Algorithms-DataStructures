import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		System.out.println("Insertion Sort:\nHow many numbers?");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the numbers:");
		for (int i =0; i<n;i++) {
			arr[i]=sc.nextInt();
		}
		sc.close();
		// Insertion Sort begins:
		for(int i =1;i<n;i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]<key) {
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}		
		// End of Sort
		
		//Output
		System.out.println("Sorted array:");
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}

}
