package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class LargestBST {
	
	
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		// Write your code here
         if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }
 
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
	}

    
    
     public static int size(BinaryTreeNode<Integer> root)
    {
        // base case: empty tree has size 0
        if (root == null) {
            return 0;
        }
 
        // recursively calculate the size of the left and right subtrees and
        // return the sum of their sizes + 1 (for root node)
        return size(root.left) + 1 + size(root.right);
    }
    
    public static boolean isBST(BinaryTreeNode<Integer>  node, int min, int max)
    {
        // base case
        if (node == null) {
            return true;
        }
 
        // if the node's value falls outside the valid range
        if (node.data < min || node.data > max) {
            return false;
        }
 
        // recursively check left and right subtrees with updated range
        return isBST(node.left, min, node.data) &&
            isBST(node.right, node.data, max);
    }

}
