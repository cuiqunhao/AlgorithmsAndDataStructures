package Solution;

public class Solution11 {

	public int Fibonacci(int n) {
		int[] result = { 0, 1 };
		if (n < 2)
			return result[n];

		int one = 0;
		int two = 1;
		int F=0;
		
		for (int i = 2; i <=n; i++) {
			F=one+two;
			
			one=two;
			two=F;
		}
		
		return F;
	}
}
