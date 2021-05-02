package tree;

public class TreeUse {
	
	public static void main(String[] args) {
		
//		TreeNode<Integer> root = new TreeNode<Integer>(4);
//		TreeNode<Integer> node1 = new TreeNode<Integer>(1);
//		TreeNode<Integer> node2 = new TreeNode<Integer>(2);
//		TreeNode<Integer> node3 = new TreeNode<Integer>(3);
//		TreeNode<Integer> node4 = new TreeNode<Integer>(4);
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node1.children.add(node4);
		
		TreeNode<Integer> root = new TreeNode<Integer>(0);
		TreeNode<Integer> node1 = new TreeNode<Integer>(1);
		TreeNode<Integer> node2 = new TreeNode<Integer>(2);
		root.children.add(node1);
		root.children.add(node2);
		
		System.out.println(root.data);
	}

}
