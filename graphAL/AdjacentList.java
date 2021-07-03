package graphAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjacentList {
	
	public static void printBFSHelper(ArrayList<ArrayList<Integer>> adj , int sv , boolean visited[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(sv);
		int n = adj.size();
		visited[sv] = true;
		while(!q.isEmpty()) {
			int front;
			front = q.remove();
			System.out.println(front);
			ArrayList<Integer> list = adj.get(front);
			for(int i = 0 ; i < list.size(); i++) {
				if(!visited[list.get(i)]) {
					q.add(list.get(i));
					visited[list.get(i)] = true;
				}
			}
		}
	}
	
	public static void printBFS(ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[adj.size()];
		for(int i = 0; i < adj.size() ; i++) {
			if(!visited[i]) {
				printBFSHelper(adj , i , visited);
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
		printBFS(adj);
	}

}
