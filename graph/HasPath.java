package graph;

public class HasPath {
	
	public static boolean hasPathDFS(int[][] grid , int s , int d) {
		
		 boolean visited[] = new boolean[grid.length];
		return hasPathDFSHelper(grid , s , d  , visited );
	}

	private static boolean hasPathDFSHelper(int[][] grid, int s, int d , boolean[] visited) {
		
		int n = grid.length;
		if(s == d) {
			return true;
		}
		visited[s] = true;
		
		for(int i = 0 ; i < n ; i++) {
			if(!visited[i] && grid[s][i] == 1) {
				if(hasPathDFSHelper(grid , i , d , visited)) {
					return true;
				}
			} 
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] graph = {{0,1,1,1},
				         {0,0,1,1}, 
				         {0,0,0,1},
				         {0,0,0,0}};
		System.out.println(hasPathDFS(graph , 0 , 3));

	}

}
