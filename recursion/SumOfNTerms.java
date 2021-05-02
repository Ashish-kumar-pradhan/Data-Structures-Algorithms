package recursion;

import java.util.Scanner;

public class SumOfNTerms {
	
	public static int sum(int n) {
		if (n==1) {
			return 1;
		}
		return n + sum(n-1);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number ");
		int x = sc.nextInt();
		
		System.out.println("The sum of terms is  "+sum(x));
		
		

	}

}
