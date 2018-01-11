import java.util.Arrays;

public class BinaryAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,0,0,1,0,1,1,0};
		int[] B = {0,1,0,0,0,0,1,0};
		int[] result = new int[9];
		int carry = 0;
		for (int i=7;i>=0;i--) {
			int sum = A[i] + B[i] + carry;
			carry = 0;
			if(sum>1) {
				carry = 1;
				result[i+1] = 1;
			}
			else
			{
				result[i+1] = sum;
			}
		}
		
		result[0] = carry;
		Arrays.stream(result).forEach(x->System.out.print(x));
		
	}

}
