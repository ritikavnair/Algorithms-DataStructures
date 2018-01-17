import java.util.Scanner;

public class CreatureInsertionSort {
	public static void main(String args[] ) throws Exception {
        
        // Write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] creatures = new int[n];
        int evenCount =0;
        int oddCount = 0;
        for(int i=0;i<n;i++){
            creatures[i] = s.nextInt();
            if(creatures[i]%2==0){
                evenCount+=1;
            }
            else{
                oddCount+=1;
            }
        }
        
        int[] evens = new int[evenCount];
        int[] odds = new int[oddCount];
        int e=0;
        int o=0;
        for(int i =0;i<n;i++){
            if(creatures[i]%2==0){
                evens[e] = creatures[i];
                e++;
            }
            else{
                odds[o] = creatures[i];
                o++;
            }
        }
        
        evens=insertionSort(evens,evenCount);
        odds =insertionSort(odds,oddCount);
        
        int[] finalArray = new int[n+2];
        int i = 0;
        int sumEven=0;
        for(i=0;i<evenCount;i++){
            finalArray[i] = evens[i];
            sumEven+=evens[i];
        }
        finalArray[i] = sumEven;
        int j = 0;
        int sumOdd=0;
        for(j =0;j<oddCount;j++){
            finalArray[evenCount+j+1] = odds[j];
            sumOdd+=odds[j];
            
        }
        finalArray[evenCount+j+1] = sumOdd;
        String result ="";
        for(int k =0;k<n+2;k++) {
        result+=(finalArray[k] + " ");	
        }
        System.out.println(result.trim());
        

    }
    
    public static int[] insertionSort(int[] arr, int n){
        for(int i=1;i<n;i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
        return arr;
    }
}
