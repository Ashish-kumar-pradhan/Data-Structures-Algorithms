 package graph;

import java.util.ArrayList;

public class GetPath {

	public static void getPathDFS(int[][] grid, int s, int d , boolean[] visited, ArrayList<Integer> arr) {
		
		int n = grid.length;
		arr.add(s);
		if(s == d) {
			for(int i = 0 ; i < n ; i++) {
				visited[i] = true;
			}
		}
		visited[s] = true;
		
		for(int i = 0 ; i < n ; i++) {
			if(!visited[i] && grid[s][i] == 1) {
				getPathDFS(grid , i , d , visited , arr);
			} 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] grid =  {{0,0,1,0},
				         {1,0,1,1}, 
				         {1,1,0,1},
				         {0,1,0,0}};
		
		    int n = grid.length;
			boolean visited[] = new boolean[n];
			ArrayList<Integer> arr = new ArrayList<>();
			getPathDFS(grid , 0 , 3 , visited , arr);
			
			for(int i = 0 ; i < arr.size() ; i++) {
				System.out.print(arr.get(i) + " => ");
			}
		

	}

}
