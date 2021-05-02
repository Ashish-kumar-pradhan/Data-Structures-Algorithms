package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructingTree {
	
	public static BinaryTreeNode<Integer> buildTreeHelper(int in[] , int pre[] , int inS , int inE , int preS , int preE){
		if(inS > inE) {
			return null;
		}
		int rootData = pre[preS];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		int rootInIndex = -1;
		for (int i = inS ; i <= inE  ; i++) {
			if(in[i] == rootData) {
				rootInIndex = i ;
				break;
			}
		}
		int leftInS = inS;
		int leftInE = rootInIndex - 1 ;
		int leftPreS = preS + 1 ;
		int leftPreE = leftInE - leftInS + leftPreS;
		int rightInS = rootInIndex + 1 ;
		int rightInE = inE ;
		int rightPreS = leftPreE + 1 ;
		int rightPreE = preE;
		
		root.left = buildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);
		root.right = buildTreeHelper(in, pre, rightInS, rightInE, rightPreS, rightPreE);
		return root;
	
	}
	
	public static BinaryTreeNode<Integer> buildTree(int in[] , int pre[]){
		return buildTreeHelper(in , pre , 0 , in.length -1 ,0 , pre.length - 1 );
	}
	
	public static void printTree(BinaryTreeNode<Integer> root) {
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
		
		int in[] = {4 , 2 , 5 , 1 , 3 , 7};
		int pre[] = {1 , 2 , 4 , 5 , 3 , 7};
		
		BinaryTreeNode<Integer> root = buildTree(in , pre);
		printTree(root);
		

	}

}
