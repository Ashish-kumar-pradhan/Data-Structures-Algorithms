package dp;

public class MinimumNoOfSquare {
	
	public static int minSqrR(int n) {
		if(n==0) {
			return 0;
		}
		int x = (int)Math.pow(n, 0.5);
		
		return 1 + minSqrR(n-x*x);
		
	}

	public static void main(String[] args) {
		 
		System.out.println(minSqrR(23));

	}

}
