import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static Map<Integer,Integer> memo = new HashMap<Integer, Integer>();
	
	
	public static void main(String[] args) {
		
		int n = 6;
		System.out.println(fib(n));
		System.out.println(fibRecursive(n));
	}
	
	public static int fib(int n) {
				
		if (n==0)
			return 0;
		if(n==1)
			return 1;
		
		int first = 0;
		int second = 1;
		int next = 0;
		int step = 2;
		while(step<=n) {
			next = first + second;
			first = second;
			second = next;
			step++;
		}
		return next;
		
	}
	
	public static int fibRecursive(int n) {
		if (n==0)
			return 0;
		if(n==1)
			return 1;
		
		if(memo.containsKey(n))
			return memo.get(n);
		
		int result = fibRecursive(n-1) + fibRecursive(n-2);
		memo.put(n, result);
		
		return result;
		
	}

}
