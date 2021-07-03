package graphAL;

import java.util.ArrayList;
import java.util.Scanner;

public class HasPath {
	
	public static boolean hasPathDFS(ArrayList<ArrayList<Integer>> adj , int s , int d) {
			
		boolean visited[] = new boolean[adj.size()];
		return hasPathDFSHelper(adj , s , d  , visited );
	}
	
	private static boolean hasPathDFSHelper(ArrayList<ArrayList<Integer>> adj , int s, int d , boolean[] visited) {
		
		int n = adj.size();
		if(s == d) {
			return true;
		}
		visited[s] = true;
		ArrayList<Integer> list = adj.get(s);
		for(int i = 0 ; i < list.size() ; i++) {
			if(!visited[list.get(i)]) {
				if(hasPathDFSHelper(adj , list.get(i) , d , visited)) {
					return true;
				}
			} 
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of Elements");
		n = s.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i= 0 ; i < n ; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			adj.add(list);
		}
		
		for(int i= 0 ; i < n ; i++) {
			System.out.println("Enter the vertices which are connected to " + i +"th vertice, enter -1 also at the end");
			for(int j = 0 ; j < n ; j++) {
				int temp = s.nextInt();
				if(temp == -1) {
					break;
				}
				adj.get(i).add(temp);
			}
		}
		
		System.out.println(hasPathDFS(adj , 3 ,6));

	}
	
//	8 1 2 3 -1 2 4 5 -1 3 6 -1 7 -1 -1 -1 -1 -1

}
