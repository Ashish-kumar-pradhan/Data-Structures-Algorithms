package dp;

public class MinStepsToGet1 {
	
	
	public static int myMinSteps(int n) {
		if(n==1) return 0;
		
		else if(n%3==0) return myMinSteps(n/3) + 1;
		
		else if(n%2==0) return Math.min(myMinSteps(n/2) + 1, myMinSteps(n - 1) + 1) ;
		
		else return myMinSteps(n-1) + 1 ;
	}
	

	public static int countStepsR(int n) {
		if(n==1) {
			return 0;
		}
		
		int op1 = countStepsR(n - 1);
		int minSteps = op1;

		if(n%3==0) {
		   int op2 = countStepsR(n/3);
		   if(op2 < minSteps) minSteps = op2;
		}
		
		if(n%2==0) {
			int op3 = countStepsR(n/2) ;
			if(op3 < minSteps) minSteps = op3;
		}
		
		return 1 + minSteps;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countStepsR(10));

	}

}
