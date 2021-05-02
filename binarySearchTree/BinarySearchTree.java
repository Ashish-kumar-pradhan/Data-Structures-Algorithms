package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.BinaryTreeNode;

public class BinarySearchTree {
	
	private BinaryTreeNode<Integer> root;
	
	private boolean hasDataHelper(int data , BinaryTreeNode<Integer> root) {
		if(root == null) {
			return false;
		}
		if(root.data == data) {
			return true;
		}
		else if (root.data < data) {
			return hasDataHelper(data , root.left);
		}
		else {
			return hasDataHelper(data , root.right);
		}
		
	}
	
	public boolean hasData(int data ) {
		return hasDataHelper(data , root );
	}
	
	private BinaryTreeNode<Integer> insertDataHelper(int data , BinaryTreeNode<Integer> root){
		if (root == null) {
			BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(data);
			return newRoot;
		}
		if (root.data < data) {
			root.left = insertDataHelper(data , root.left);
		}
		else {
			root.right  = insertDataHelper(data , root.right);
		}
		return root;
	}
	
	public void insertData(int data) {
		root = insertDataHelper(data , root );
	}
	
	public void deleteData(int data) {
		root = deleteDataHelper(data , root);
	}

	private BinaryTreeNode<Integer> deleteDataHelper(int data, BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null ;
		}
		if (data < root.data ) {
			root.left = deleteDataHelper(data , root.left);
			return root ;
		}
		else if (data > root.data ) {
			root.right = deleteDataHelper(data , root.right);
			return root ;
		}
		else {
			if (root.left == null && root.right == null) {
				return null;
			}
			else if (root.left == null) {
				return root.right;
			}
			else if (root.right == null) {
				return root.left;
			}
			else {
				BinaryTreeNode<Integer> minNode = root.right;
				while(minNode.left != null) {
					minNode = minNode.left;
				}
				root.data = minNode.data;
				root.right = deleteDataHelper(minNode.data , root.right );
				
				return root;
			}
		}
		
	}
	
	private void printLevelWise(BinaryTreeNode<Integer> root) {
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
	
	public void printTree() {
		 printLevelWise(root);
	}

}
