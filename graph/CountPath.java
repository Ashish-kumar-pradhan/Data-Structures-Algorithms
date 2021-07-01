package graph;


public class CountPath {
	
	static int count = 0;
	public static void countPathDFS(int[][] grid, int s, int d , boolean[] visited ) {
		
		int n = grid.length;
		if(s == d) {
			count++;
			return;
		}
		visited[s] = true;
		
		for(int i = 0 ; i < n ; i++) {
			if(!visited[i] && grid[s][i] == 1) {
				countPathDFS(grid , i , d , visited);
				visited[i] = false;
			} 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] grid =  {{0,1,1,1},
				         {0,0,0,1}, 
				         {0,0,0,1},
				         {0,0,0,0}};
		
		int n = grid.length;
		boolean visited[] = new boolean[n];
		
		countPathDFS(grid , 0 , 3 , visited );
		
		System.out.println(count);
	}

}
