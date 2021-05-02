package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.BinaryTreeNode;

public class BSTFromSoortedArray {
	
	public static BinaryTreeNode<Integer> makeBSTFromArray( int arr[] , int sI , int eI){
		
		if (eI < sI) {
			return null;
		}
		
		int mI = (sI + eI)/2 ;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mI]);
		
		root.left = makeBSTFromArray(arr , sI , mI - 1 );
		root.right = makeBSTFromArray(arr , mI + 1 , eI );
		
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
		// TODO Auto-generated method stub
		
		int array[] = {1 , 2 , 3 , 4 , 5 , 6 , 7 } ;
		BinaryTreeNode<Integer> root = makeBSTFromArray(array , 0 , array.length -1);

		printLevelWise(root);
	}

}
