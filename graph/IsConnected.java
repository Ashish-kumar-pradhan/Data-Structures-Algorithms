package graph;

public class IsConnected {
	
	public static void DFSHelper(int edges[][] , int sv , boolean visited[]) {
		System.out.println(sv);
		visited[sv] = true;
		int n = edges.length;
		for(int i = 0; i < n ; i++) {
			if(edges[sv][i] == 1 && !visited[i]) {
				DFSHelper(edges , i , visited);
			}
		}
	}
 	
	public static boolean isConectedDFS(int edges[][]) {
		boolean visited[] = new boolean[edges.length];
	    DFSHelper(edges , 0 , visited);
		for(int i = 0 ; i < edges.length ; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
