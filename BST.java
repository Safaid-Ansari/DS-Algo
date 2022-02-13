package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class BST {
	
	private BinaryTreeNode<Integer> root;
	private int size;
 
	public static boolean isPresentHelper(BinaryTreeNode<Integer> root , int x)
	{
		if(root== null)
		{
			return false;
		}
		if(root.data==x)
		{
			return true;
		}
		if(x<root.data)
		{
			return isPresentHelper(root.left,x);
		}
		else
		{
			return isPresentHelper(root.right,x);
		}
	}
	public boolean isPresent(int x)
	{
		return isPresentHelper(root,x);
	}
	
	private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root , int data)
	{
		
		if(root==null)
		{
			BinaryTreeNode<Integer> newRoot=new BinaryTreeNode<Integer>(data);
			return newRoot;
		}
		
		if(data>= root.data)
		{
			root.right=insertHelper(root.right,data);
		}
		else
		{
			root.left=insertHelper(root.left,data);
		}
		return root;
	}
	public void insert(int x)
	{
		root=insertHelper(root,x);
		size++;
		
	}
	
	private static BSTDeleteReturn DeleteHelper(BinaryTreeNode<Integer>root , int x)
	{
		if(root==null)
		{
			return new BSTDeleteReturn(null,false);
		}
		if(root.data < x)
		{
			BSTDeleteReturn outputRight=DeleteHelper(root.right,x);
			root.right=outputRight.root;
			outputRight.root=root;
			return outputRight;
		}
		if(root.data > x)
		{
			BSTDeleteReturn outputLeft=DeleteHelper(root.left,x);
			root.left=outputLeft.root;
			outputLeft.root=root;
			return outputLeft;
		}
		
		// 0 childen
		if(root.left==null && root.right==null)
		{
			return new BSTDeleteReturn(null,true);
		}
		// only left child is present 
		if(root.left!=null && root.right==null) {
			return new BSTDeleteReturn(root.left,true);
		}
		if(root.left==null && root.right!=null)
		{
			return new BSTDeleteReturn(root.right,true);
		}
		// both children are present 
		
		
		int rightMin=minimum(root.right);
		root.data=rightMin;
		BSTDeleteReturn OutputRight =DeleteHelper(root.right,rightMin);
		root.right=OutputRight.root;
		return new BSTDeleteReturn(root,true);
		
	}
	public boolean DeleteData(int x)
	{
		BSTDeleteReturn Output=DeleteHelper(root,x);
		root=Output.root;
		if(Output.deleted)
		{
			size--;
		}
		return Output.deleted;
	}
	
	private static  int minimum(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return Integer.MAX_VALUE;
		}
		
		int leftmin=minimum(root.left);
		int rightmin=minimum(root.right);
		
		return Math.min(root.data, Math.min(leftmin, rightmin));
		
	}
	public int size()
	{
		return size;
	}
	
	private static void printTreeHelper(BinaryTreeNode<Integer> node )
	{
		if(node==null)
		{
			return ;
		}
		System.out.print(node.data +" :  " ); 
		if(node.left!=null)
		{
			System.out.print("L"+node.left.data+",");
			
		}
		if(node.right!=null)
		{
			System.out.print("R"+node.right.data+",");
		}
		
		System.out.println();
		printTreeHelper(node.left);
		printTreeHelper(node.right);
		return;
	}
	public void printTree()
	{
	    printTreeHelper(root);	
	}
}
