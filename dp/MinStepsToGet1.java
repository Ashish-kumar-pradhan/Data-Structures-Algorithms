package dp;

public class MinStepsToGet1 {
	
	
	public static int myMinSteps(int n) {
		if(n==1) return 0;
		
		else if(n%3==0) return myMinSteps(n/3) + 1;
		
		else if(n%2==0) return Math.min(myMinSteps(n/2) + 1, myMinSteps(n - 1) + 1) ;
		
		else return myMinSteps(n-1) + 1 ;
	}
	

	public static int countStepsR(int n) {
		if(n == 1) {
			return 0;
		}
		
		int op1 = countStepsR(n - 1);
		int minSteps = op1;

		if(n%3 == 0) {
		   int op2 = countStepsR(n/3);
		   if(op2 < minSteps) minSteps = op2;
		}
		
		if(n%2 == 0) {
			int op3 = countStepsR(n/2) ;
			if(op3 < minSteps) minSteps = op3;
		}
		
		return 1 + minSteps;

	}
	
	public static int countStepsM(int n) {
		int[] storage = new int[n + 1];
		return countStepsM(n , storage);
	}

	private static int countStepsM(int n, int[] storage) {
		if(n == 1) {
			storage[n] = 0;
			return storage[n];
		}
		if(storage[n] != 0) {
			return storage[n];
		}
		int op1 = countStepsM(n - 1 , storage);
		int minSteps = op1;

		if(n%3 == 0) {
		   int op2 = countStepsM(n/3 , storage);
		   if(op2 < minSteps) minSteps = op2;
		}
		
		if(n%2 == 0) {
			int op3 = countStepsM(n/2 , storage) ;
			if(op3 < minSteps) minSteps = op3;
		}
		
		storage[n] = 1 + minSteps;
		return storage[n];
	}
	
	public static int countStepsDP(int n) {
		int storage[] = new int[n + 1];
		storage[1] = 0;
		for(int i = 2; i <= n; i++) {
			int min = storage[i - 1];
			if(i % 3 == 0) {
				if(min > storage[i / 3]) {
					min = storage[i / 3];
				}
			}
			if(i % 2 == 0) {
				if(min > storage[i / 2]) {
					min = storage[i / 2];
				}
			}
			storage[i] = 1 + min;
		}
		return storage[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countStepsDP(10));
		System.out.println(countStepsM(10));
		System.out.println(countStepsR(10));

	}

}
