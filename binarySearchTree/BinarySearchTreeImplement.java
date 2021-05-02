package binarySearchTree;

public class BinarySearchTreeImplement {

	public static void main(String[] args) {
		
		BinarySearchTree b = new  BinarySearchTree();
		
		b.insertData(10);
		b.insertData(20);
		b.insertData(5);
		b.insertData(15);
		b.insertData(3);
		b.insertData(7);
		
		b.deleteData(5);
		
		b.printTree();

	}

}
