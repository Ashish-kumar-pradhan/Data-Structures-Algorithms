package dp;

public class MinimumNoOfSquare {
	
		
	public static int minSqrR(int n) {
		if(n == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int x = (int)Math.pow(n, 0.5);
		for(int i = 1 ; i <= x ; i++) {
			if(min > minSqrR(n-i*i)) {
				min = minSqrR(n-i*i);
			}
		}
		return 1 + min;
	}
	
	public static int minSqrM(int n) {
		int storage[] = new int[n+1];
		return minSqrM(n , storage);
	}
	
	public static int minSqrM(int n , int[] storage) {
		if(n == 0) {
			storage[n] = 0;
			return storage[n];
		}
		if(storage[n] != 0) {
			return storage[n];
		}
		int min = Integer.MAX_VALUE;
		int x = (int)Math.pow(n, 0.5);
		for(int i = 1 ; i <= x ; i++) {
			if(min > minSqrM(n-i*i , storage)) {
				min = minSqrM(n-i*i , storage);
			}
		}
		storage[n] = 1 + min;
		return storage[n];
	}
	
	public static int minSqrDP(int n) {
		int storage[] = new int[n+1];
		
		for(int i = 0; i <= n; i++) {
			if(n < 4) {
				storage[i] = i;
			}
			else {
				storage[i] = i;
				int x = (int)Math.pow(i, 0.5);
				for(int j = 1 ; j <= x ; j++) {
					storage[i] = Math.min(storage[i], 1 + storage[i - j*j]);
	
				}
			}
		}
		
		return storage[n];
	}
	
	public static int minSqrLegendre(int n) {
		
		if((int)Math.sqrt(n)*(int)Math.sqrt(n) == n)  return 1;
		
		while(n % 4 == 0) {
			n /= 4;
		}
		
		if(n % 8 == 7) return 4 ;
		
		for(int i = 1 ; i < Math.sqrt(n) ; i++) {
			if((int)Math.sqrt(n-i*i)*(int)Math.sqrt(n-i*i) == n-i*i) return 2 ;
		}
		return 3;
	}
		

	public static void main(String[] args) {
		 
		System.out.println(minSqrR(12));
		System.out.println(minSqrM(12));
		System.out.println(minSqrDP(12));
		System.out.println(minSqrLegendre(12));

	}

}
