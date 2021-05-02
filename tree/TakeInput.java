package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeInput {
	


	public static TreeNode<Integer> takeInputRecursive() {
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter next node data ");
		n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter number of child of input "+n);
		int childCount = s.nextInt();
		for(int i = 0 ; i < childCount ; i++) {
			TreeNode<Integer> child = takeInputRecursive();
			root.children.add(child);
		}
		
		return root;

	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data ");
		int rootData = s.nextInt();
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.add(root);
		
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode = pendingNodes.remove();
			System.out.println("Enter the number of clidren of " + frontNode.data);
			int numChildren = s.nextInt();
			for(int i = 1 ; i <= numChildren ; i++) {
				System.out.println("Enter "+ i + "th child of "+ frontNode.data);
				int child = s.nextInt();
				TreeNode<Integer> childNode = new TreeNode<Integer>(child);
				frontNode.children.add(childNode);
				pendingNodes.add(childNode);
			}
		}
		
		return root;
		
	}
	
	public static void printRecursive(TreeNode<Integer> root) {
		String s = root.data + " : ";
		for(int i = 0 ; i < root.children.size() ; i++ ) {
			s = s + root.children.get(i).data + ", " ;
		}
		System.out.println(s);
		for(int i = 0 ; i < root.children.size() ; i++ ) {
			printRecursive(root.children.get(i));
		}
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode = pendingNodes.remove();
			System.out.print(frontNode.data + " : ");
			for(int i = 0 ; i < frontNode.children.size() ; i++) {
				System.out.print(frontNode.children.get(i).data+ ", ");
				pendingNodes.add(frontNode.children.get(i));
			}
			System.out.println();
		}
		
	}
	
	public static int numNodes(TreeNode<Integer> root) {
		int count = 1 ;
		for(int i = 0 ; i < root.children.size(); i++) {
			count += numNodes(root.children.get(i));
		}
		return count;
	}
	
	public static int largestNode(TreeNode<Integer> root) {
		if(root == null) {
		
			return Integer.MIN_VALUE;
		}
		
		int ans = root.data;
		for(int i = 0 ; i < root.children.size(); i++) {
			int childLargest = largestNode(root.children.get(i));
			if (childLargest > ans ) {
				ans = childLargest;
			}
		}
		return ans;
	}
	
	public static int hieghtOfTree(TreeNode<Integer> root)	{
		
		int count = 0 ;
		int value;
		for(int i = 0 ; i < root.children.size(); i++) {
			value = hieghtOfTree(root.children.get(i));
			if(value > count) {
				count = value;
			}
		}
		return count + 1;
	}
	
	public static void allNodesAtKDepth(TreeNode<Integer> root , int k) {
		if(k < 0) {
			return;
		}
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		for(int i = 0 ; i < root.children.size() ; i++ ) {
			allNodesAtKDepth(root.children.get(i) , k-1);
		}
	}
	
	public static int numLeafNodes(TreeNode<Integer> root) {
		if (root.children.size() == 0) {
			return 1;
		}
		int count = 0;
		for(int i = 0 ; i < root.children.size(); i++) {
			count += numLeafNodes(root.children.get(i));
		}
		return count;
	}
	
	public static int sumOfAllNodes(TreeNode<Integer> root) {
		int sum = root.data;
		for(int i = 0 ; i < root.children.size() ; i++) {
			sum += sumOfAllNodes(root.children.get(i)); 
		}
		return sum;
	}
	
	public static int numNodesGreaterThanX(TreeNode<Integer> root , int x) {
		
		if (root.data > x ) {
			return 1;
		}
		
		int count = 0;
		for(int i = 0 ; i < root.children.size(); i++) {
			count += numNodesGreaterThanX(root.children.get(i) , x);
			
			}
		
		return count ;
	}
	
	public static boolean xIsPresent(TreeNode<Integer> root , int x ) {
		if (root.data == x) {
			return true;
		}
		boolean sol = false ;
		for(int i = 0 ; i < root.children.size(); i++) {
			sol = xIsPresent(root.children.get(i) , x);	
			if(sol == true) {
				break;
			}
		}
		return sol;
	}
	

	public static void main(String[] args) {
		
//		TreeNode<Integer> root = takeInputRecursive();
		TreeNode<Integer> root = takeInputLevelWise();
//		printRecursive(root);
		
		printLevelWise(root);
		
//		System.out.println("Number of nodes are " + numNodes(root));
//		
//		System.out.println("Largest node is " + largestNode(root));
	
//		System.out.println("Height of The tree is " + hieghtOfTree(root));
	
//		 allNodesAtKDepth(root , 2);
		
//		System.out.println("Number of Leaf nodes are " + numLeafNodes(root));
		
//		System.out.println("Sum of all nodes are " + sumOfAllNodes(root));
		
//		System.out.println("Number of nodes greater then x are " + numNodesGreaterThanX(root , 2));
		
//		System.out.println("Is X is pesent in the tree --->  "+ xIsPresent(root , 2));
		
		
	}

}
