package arrayList;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list1 = new ArrayList<>();
		System.out.println(list1.size());
		list1.add(15);
		list1.add(20);
		list1.add(30);
		System.out.println(list1.size());
	//	System.out.println(list1.get(2));
		for (int i = 0 ; i < list1.size() ; i++) {
			System.out.print(list1.get(i) + " ");
		}
		list1.add(2, 45);
		System.out.println();
		
		System.out.println(list1.size());

		for (int i = 0 ; i < list1.size() ; i++) {
			System.out.print(list1.get(i)+ " ");
		}
		
		list1.set(0, 100);
		System.out.println();
		
		System.out.println(list1.size());

		for (int i = 0 ; i < list1.size() ; i++) {
			System.out.print(list1.get(i)+ " ");
		}
		


	}

}
