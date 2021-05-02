package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BinaryTreeUse {
	
	public static BinaryTreeNode<Integer> takeInputRecursive(Scanner s) {
		
		int rootData;
		System.out.println("Enter node data ");
		rootData = s.nextInt();
		
        if(rootData == -1 ) {
        	return null;
		}
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        root.left = takeInputRecursive(s);
        root.right = takeInputRecursive(s);
		
		return root;

	}
	
	
	public static void printRecursive(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		String toBePrinted = root.data + " : ";
		if(root.left != null) {
			toBePrinted += "L" + root.left.data + ", ";
		}
		if(root.right != null) {
			toBePrinted += "R" + root.right.data + ", ";
		}
		
		System.out.println(toBePrinted);
		
		printRecursive(root.left);
		printRecursive(root.right);
		}
	
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data ");
		int rootData = s.nextInt();
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);
		
		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.remove();
			System.out.println("Enter the left child of "+ frontNode.data);
			int left = s.nextInt();
			if(left != -1) {
				frontNode.left = new BinaryTreeNode<>(left);
				pendingNodes.add(frontNode.left);	
			}
			
			System.out.println("Enter the right child of "+ frontNode.data);
			int right = s.nextInt();
			if(right != -1) {
				frontNode.right = new BinaryTreeNode<>(right);
				pendingNodes.add(frontNode.right);
			}
		}
		return root;
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.remove();
			System.out.print(frontNode.data + " : ");
			if(frontNode.left != null) {
				System.out.print("L"+frontNode.left.data+" , " );
				pendingNodes.add(frontNode.left);
			}
			if(frontNode.right != null) {
				System.out.print("R"+frontNode.right.data );
				pendingNodes.add(frontNode.right);
			}
			System.out.println();
		}
	}
	
	

	public static void main(String[] args) {
		
		
//		Scanner s = new Scanner(System.in);
//		BinaryTreeNode<Integer> root = takeInputRecursive(s);
//		printRecursive(root);
//		s.close();
		
		
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);

		
		
	}

}
