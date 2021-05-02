package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Traversal {
	
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
	
	
	public static void levelOrder(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode = pendingNodes.remove();
			System.out.print(frontNode.data + " ");
			for(int i = 0 ; i < frontNode.children.size() ; i++) {
				pendingNodes.add(frontNode.children.get(i));
			}
		}
		
	}
	
	public static void preOrder(TreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		for(int i = 0 ; i < root.children.size() ; i++) {
			preOrder(root.children.get(i));
		}
	}
	

	public static void postOrder(TreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		for(int i = 0 ; i < root.children.size() ; i++) {
			postOrder(root.children.get(i));
		}
		System.out.print(root.data + " ");
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode<Integer> root = takeInputLevelWise();
		
		levelOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);

	}

}
