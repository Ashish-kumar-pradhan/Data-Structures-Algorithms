package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BSTLL {
	
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
	
	public static Node<Integer> LLFromBST(BinaryTreeNode<Integer> root){
		
		if(root == null) {
			return null;
		}

		Node<Integer> leftHead = LLFromBST(root.left);
		Node<Integer> temp = leftHead;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node<Integer> rootNode = new Node<Integer>(root.data);
		
		Node<Integer> rightHead = LLFromBST(root.right);
		
		temp.next = rootNode;
		rootNode.next = rightHead;
		return leftHead;
	}
	
	public static void print(Node<Integer> head) {

		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		Node<Integer> head = LLFromBST(root);
		print(head);
		

	}

}
