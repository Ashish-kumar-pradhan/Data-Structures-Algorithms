package dp;

import java.util.Scanner;

public class Staircase {
	
	public static int numStepsR(int n) {
		if(n == 0) return 1;
		else if(n < 0) return 0;
		int x = numStepsR(n-1);
		int y = numStepsR(n-2);
		int z = numStepsR(n-3);
		return x+y+z;
	}
	
	public static int numStepsM(int n ) {
		int storage[] = new int[n+1];
		return numStepsM(n , storage);
	} 
	
	public static int numStepsM(int n , int[] storage) {
		if(n == 0) return 1;
		else if(n < 0) return 0;
		if(storage[n] != 0) return storage[n];
		int x = numStepsM(n-1 , storage);
		int y = numStepsM(n-2 , storage);
		int z = numStepsM(n-3 , storage);
		storage[n] = x+y+z;
		return storage[n];
	}
	public static int numStepsDP(int n ) {
		int storage[] = new int[n + 1];
		storage[0] = 1;
		for(int i = 1 ; i <= n ; i++) {
			if(i < 3) storage[i] = i; 
 			else storage[i] =  storage[i-1] +  storage[i-2] +  storage[i-3]; 
		}
		return storage[n];	
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(numStepsR(n));
		System.out.println(numStepsM(n));
		System.out.println(numStepsDP(n));
	}
}
