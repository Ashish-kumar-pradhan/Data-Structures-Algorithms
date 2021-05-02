package dp;

public class BalanceBTs {
	
	public static long countBBTs(int h) {
		if(h == 0 || h == 1) {
			return 1;
		}
		long x = countBBTs(h-1);
		long y = countBBTs(h-2);
		
		return x*x + 2*x*y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countBBTs(6 ));

	}

}
