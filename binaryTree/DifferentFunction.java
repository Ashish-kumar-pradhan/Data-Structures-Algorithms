package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DifferentFunction {
	
	
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
	
	public static int numNodes(BinaryTreeNode<Integer> root) {
		int count = 1;
		if(root == null) {
			return 0 ;
		}
		count += numNodes(root.left);
		count += numNodes(root.right);
		
		return count   ;
	}
	
	public static int hightOfTree(BinaryTreeNode<Integer> root) {
		int count = 0 ;
		if(root == null) {
			return 0;
		}
		int leftHeight = hightOfTree(root.left);
		int rightHeight = hightOfTree(root.right);
		
		if (leftHeight > rightHeight) {
			count = leftHeight;
		} else {
			count = rightHeight;
		}
		
		return count + 1 ;		
	}
	
	public static boolean isNodePresent(BinaryTreeNode<Integer> root , int x) {
		if(root == null ) {
			return false;
		}
		
		boolean ans = false ;
		if(root.data == x) {
			return true ;
		}
		ans = isNodePresent(root.left , x) || isNodePresent(root.right , x);
		return ans;
	}
	
	
	public static int numLeafNodes(BinaryTreeNode<Integer> root) {
		int count = 0 ;
		if(root == null ) {
			return 0 ;
		}
		if (root.left == null && root.right == null ) {
			return 1;
		}
		
		count += numLeafNodes(root.left);
		count += numLeafNodes(root.right);
		
		return count;
	}
	
	public static int diameterRecursively(BinaryTreeNode<Integer> root) {
		if(root == null ) {
			return 0;
		}
		int option1 = hightOfTree(root.left) + hightOfTree(root.right);
		int option2 = diameterRecursively(root.left);
		int option3 =  diameterRecursively(root.right);
		
		int ans = Math.max(option1, Math.max(option2, option3));
		
		return ans;
	} 
	
	public static Pair<Integer,Integer> diameterHeight(BinaryTreeNode<Integer> root) {
		if(root == null) {
			Pair<Integer , Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		Pair<Integer , Integer> lo = diameterHeight(root.left);
		Pair<Integer , Integer> ro = diameterHeight(root.right); 
	    int height = 1 + Math.max(lo.first, ro.first);
	    
	    int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		
		int diameter = Math.max(option1, Math.max(option2, option3));
		
		Pair<Integer, Integer> output = new Pair<>();
		output .first = height;
		output.second = diameter;
		
		return output;
	}
	
	
	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null ) {
			return ;
		}
		System.out.print(root.data+" ");
		
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(BinaryTreeNode<Integer> root) {
		if(root == null ) {
			return ;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root == null ) {
			return ;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		
		System.out.print(root.data+" ");
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		BinaryTreeNode<Integer> root = takeInputLevelWise();
//		printLevelWise(root);

//		System.out.println("Number of Nodes are "+numNodes(root));

//		System.out.println("The height of Tree is "+hightOfTree(root));
		
//		System.out.println(isNodePresent(root , 2));
		
//		System.out.println(numLeafNodes(root));
		
//		System.out.println(diameterRecursively(root));
		
//		preOrder(root);
//		System.out.println();
//		inOrder(root);
//		System.out.println();
//		postOrder(root);
		
		System.out.println("Diameter : "+ diameterHeight(root).second);

	}

}
