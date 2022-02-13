package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class BSTDeleteReturn {

	 BinaryTreeNode<Integer> root;
	boolean deleted;
	
	BSTDeleteReturn(BinaryTreeNode<Integer> root , boolean deleted)
	{
		this.root=root;
		this.deleted=deleted;
	}
}
