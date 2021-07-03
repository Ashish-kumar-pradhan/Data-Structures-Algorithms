package graphAL;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacentList {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of Elements");
		n = s.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for(int i= 0 ; i < n ; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			arr.add(list);
		}
		
		for(int i= 0 ; i < n ; i++) {
			System.out.println("Enter the vertices which are connected to " + i +"th vertice, enter -1 also at the end");
			for(int j = 0 ; j < n ; j++) {
				int temp = s.nextInt();
				if(temp == -1) {
					break;
				}
				arr.get(i).add(temp);
			}
		}
		

	}

}
