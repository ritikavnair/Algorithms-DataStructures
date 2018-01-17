import java.util.Scanner;

public class ReverseBits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer n = sc.nextInt();
		sc.close();
				
		int totalBits = Integer.SIZE;
		
		Integer reverseNum = 0;
		 while(n!=0){  
			int lastBit = (n & 1);
			reverseNum = reverseNum<<1;
			reverseNum += lastBit;
			n>>>=1;
			totalBits--;
			
		}
		reverseNum <<= totalBits;		
		System.out.println(reverseNum);
		
	}

}
