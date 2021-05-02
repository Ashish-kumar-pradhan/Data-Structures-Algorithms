package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTree.BinaryTreeNode;

public class BinarySearchTreeUse {
	
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
	
	public static boolean isXPresentInBST(BinaryTreeNode<Integer> root , int x ) {
		boolean ans ;
		if(root == null) {
			return false;
		}
		if(root.data == x ){
			return true;
		}else if(root.data > x) {
			ans = isXPresentInBST(root.left, x);
		}else{
			ans = isXPresentInBST(root.right, x);
		}
		return ans;
	}
	
	public static void numPresentInRange(BinaryTreeNode<Integer> root , int sN , int eN) {
		if(root == null) {
			return;
		}
		if(root.data >= sN && root.data <= eN) {
			System.out.print(root.data + " ");
		}
		if(root.data > sN) {
			numPresentInRange(root.left , sN , eN);
		}
		
		if(root.data < eN) {
			numPresentInRange(root.right , sN , eN);
		}
	}
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}
	
	public static int maximum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	}
	
	
	public static boolean isBST1(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		int leftMax = maximum(root.left);
		int rightMin = minimum(root.right);
		if(root.data <= leftMax) {
			return false;
		}
		if(root.data > rightMin) {
			return false;
		}
		boolean isLeftBST = isBST1(root.left);
		boolean isRightBST = isBST1(root.right);
		if(isLeftBST && isRightBST) {
			return true ;
		} else {
			return false;
		}
		
	}
	
	public static Pair<Boolean , Pair<Integer , Integer >> isBST2(BinaryTreeNode<Integer> root){
		if(root == null) {
			Pair<Boolean , Pair<Integer ,Integer >> output = new Pair<Boolean , Pair<Integer , Integer>>();
			output.first = true;
			output.second = new Pair<Integer , Integer >();
			output.second.first = Integer.MIN_VALUE;
			output.second.second = Integer.MAX_VALUE;
			return output;
		}
		Pair<Boolean , Pair<Integer , Integer>> leftOutput = isBST2(root.left);
		Pair<Boolean , Pair<Integer , Integer >> rightOutput = isBST2(root.right);
		int min = Math.min(root.data, Math.min(leftOutput.second.first , rightOutput.second.first));
		int max = Math.max(root.data, Math.max(leftOutput.second.second , rightOutput.second.second));
		boolean isBST =(root.data > leftOutput.second.second) && (root.data <= rightOutput.second.first) && leftOutput.first && rightOutput.first; 
		
		
		Pair<Boolean , Pair<Integer ,Integer >> output = new Pair<Boolean , Pair<Integer , Integer>>();
		output.first = isBST;
		output.second = new Pair<Integer , Integer >();
		output.second.first = min;
		output.second.second = max;
		return output;
	}
	
	public static boolean isBST3(BinaryTreeNode<Integer> root , int min , int max) {
		if(root == null) {
			return true;
		}
		if(root.data < min && root.data > max  ) {
			return false;
		}
		boolean isLeftOk = isBST3(root.left , min , root.data - 1);
		boolean isRightOk = isBST3(root.right ,root.data , max);
		return isLeftOk && isRightOk ;
	} 
	
	
	public static ArrayList<Integer> rootToNodePath(BinaryTreeNode<Integer> root , int data) {
		if (root == null) {
			return null;
		}
		
		if (root.data == data) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(data);
			return output;
		}
		ArrayList<Integer> leftOutput = rootToNodePath(root.left , data);
		if(leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		
		ArrayList<Integer> rightOutput = rootToNodePath(root.right , data);
		if(rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		} else {
			return null;
		}
	} 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeNode<Integer> root = takeInputLevelWise();
//		printLevelWise(root);
//		
//		System.out.println(isXPresentInBST(root , 2));
		
//		numPresentInRange(root , 6 , 10);
		
//		System.out.println(isBST1(root));
//		System.out.println(isBST2(root).first);
//		System.out.println(isBST3(root , 0 , 8));
		
		ArrayList<Integer> arr = rootToNodePath(root , 7);
		System.out.print(arr);

	}

}
