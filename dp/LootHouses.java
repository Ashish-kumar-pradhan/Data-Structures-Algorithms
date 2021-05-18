package dp;

public class LootHouses {
	
	public static int maxR(int arr[]) {
		int n = arr.length;
		return maxR(arr , n);
		
	}

	private static int maxR(int[] arr, int n) {
		if(n < 1) {
			return 0;
		}
		return Math.max(arr[n-1] + maxR(arr , n - 2), maxR(arr , n - 1));
	}
	
	public static int maxM(int arr[]) {
		int n = arr.length;
		int[] storage = new int[n + 1];
		return maxM(arr , n , storage);
		
	}

	private static int maxM(int[] arr, int n, int[] storage) {
		if(n < 1) { 
			return 0;
		}
		if(storage[n] != 0) {
			return storage[n];
		}
		
		storage[n] = Math.max(arr[n-1] + maxM(arr , n - 2 , storage), maxM(arr , n - 1 , storage));
		return storage[n];
	}
	
	public static int maxDP(int arr[]) {
		int n = arr.length;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		if(n == 0) {
			return dp[0];
		}
		dp[1] = arr[0];
		if(n == 1) {
			return dp[1];
		}
		for(int i = 2 ; i <= n ; i++) {
				dp[i] = Math.max(arr[i-1] + dp[i-2] , dp[i-1]);
			}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int arr[] = {0, 1, 2, 0 , 5 , 5 , 1 , 0};
		System.out.println(maxR(arr));
		System.out.println(maxM(arr));
		System.out.println(maxDP(arr));
		

	}

}
