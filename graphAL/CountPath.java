package graphAL;

import java.util.ArrayList;
import java.util.Scanner;

public class CountPath {
	
	public static void countPathDFS(ArrayList<ArrayList<Integer>> adj , int s, int d , boolean[] visited , int[] c) {
		
		int n = adj.size();
		if(s == d) {
			c[0]++;
		}
		visited[s] = true;
		ArrayList<Integer> list = adj.get(s);
		for(int i = 0 ; i < list.size() ; i++) {
			if(!visited[list.get(i)]) {
				countPathDFS(adj , list.get(i) , d , visited , c);
				visited[list.get(i)] = false;
			} 
		}
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
		
		boolean visited[] = new boolean[n];
		int[] c = new int[1]; 
		
		countPathDFS(adj , 4 , 7 , visited , c);
		
		System.out.println(c[0]);
	}

}
