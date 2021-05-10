package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import queue.QueueEmptyException;

public class Graph {
	
	public static void printDFSHelper(int edges[][] , int sv , boolean visited[]) {
		System.out.println(sv);
		visited[sv] = true;
		int n = edges.length;
		for(int i = 0; i < n ; i++) {
			if(edges[sv][i] == 1 && !visited[i]) {
				printDFSHelper(edges , i , visited);
			}
		}
	}
 	
	public static void printDFS(int edges[][]) {
		boolean visited[] = new boolean[edges.length];
		for(int i = 0 ; i < edges.length ; i++) {
			if(!visited[i]) {
				printDFSHelper(edges , i , visited);
			}
		}
		
	}
	
	public static void printBFSHelper(int edges[][] , int sv , boolean visited[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(sv);
		int n = edges.length;
		visited[sv] = true;
		while(!q.isEmpty()) {
			int front;
			front = q.remove();
			System.out.println(front);
			for(int i = 0 ; i < n ; i++) {
				if(edges[front][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void printBFS(int edges[][]) {
		boolean visited[] = new boolean[edges.length];
		for(int i = 0; i < edges.length ; i++) {
			if(!visited[i]) {
				printBFSHelper(edges , i , visited);
			}
		}
		
	} 
	

	public static void main(String[] args) {
		int n;
		int e;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		e = s.nextInt();
		int edges[][] = new int[n][n];
		for(int i= 0 ; i< e ; i++) {
			int fv = s.nextInt();
			int sv = s.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		
		printDFS(edges);
		System.out.println(" ************************* ");
		System.out.println();
		printBFS(edges);
	}

}
