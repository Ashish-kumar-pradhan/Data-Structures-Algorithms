package dp;

public class MinStepsToGet1 {
	
	public static int minSteps(int n) {
		if(n==1) {
			return 0;
		}
		else {

			if(n%3==0) {
			   return	minSteps(n/3) + 1;
			}
			
			else if(n%2==0) {
				return minSteps(n/2) + 1;
			}
			else {
				return minSteps(n-1) + 1;
			}
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(minSteps(11));

	}

}
