package recursion;

import java.util.*;

public class GeometricSum {
	
	public static double geometricSum(int n) {
		if (n==1) {
			return 1;
		}
		double ans = 1/(double)Math.pow(2 , n-1) + geometricSum(n-1);
		return ans;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number ");
		int x = sc.nextInt();
		
		System.out.println("The sum of terms is  "+geometricSum(x));
		
		

	}

}
