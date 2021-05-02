package recursion;

import java.util.Scanner;

public class FibonacciSeries {
	
	public static int fibonacci(int n) {
		if(n==1||n==2) {
			return n-1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of terms ");
		int x = sc.nextInt();
		
		for (int i = 1 ; i <= x ; i++) {
			System.out.print(fibonacci(i)+" ");
		}
		

	}

}
