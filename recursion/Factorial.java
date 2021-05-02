package recursion;

import java.util.Scanner;

public class Factorial {
	
	public static int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number ");
		int x = sc.nextInt();
		
		System.out.println("The Factorial of "+x+" is  "+factorial(x));
		

	}

}
