package dp;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	
	public static int lisDP1(int size , int a[]) {
		
		int lis = 0;
		int dp[] = new int[size];
		for(int i = 0 ; i < size ; i++) {
			int max = 0;
			for(int j = 0 ; j < i ; j++) {
				if(a[i] > a[j]) {
					if( max < dp[j]) {
						max = dp[j];  
					}
				}
			}
			dp[i] = max + 1;
			if (lis < dp[i]) {
				lis = dp[i];
			}
		}
		return lis;
	}
	
//	public static int Binary(int )
	
	public static int lisDP2(int size , int a[]) {
		int[] dp = new int[size + 1];
		int j = 1;
		for(int i = 1 ; i < size ; i++) {
			dp[i] = Integer.MIN_VALUE;
		}
		for(int i = 0 ; i < size ; i++) {
			int k = 1;
			while(k < size) {
				if(dp[k] == Integer.MIN_VALUE) {
					dp[k] = a[i];
					break;
				}
				else if(a[i] > dp[k] && dp[k] != Integer.MIN_VALUE) {
					k++; 
				}
				else {
					dp[k] = a[i];
					break;
				}
			}
			if(j < k ) {
				j = k;
			}
		}

		return j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		16
//		0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int a[] = new int[size];
		for(int i = 0 ; i < size ; i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println(lisDP1(size , a));
		System.out.println(lisDP2(size , a));
		

	}

}
