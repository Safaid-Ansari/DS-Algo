package BinarySearchTree;

import java.util.ArrayList;

import BinaryTree.BinaryTreeNode;

public class FindPathInBST {

	
	 public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
	        if(root == null) {
	            return null;
	        }
	        if(root.data == data) {
	            ArrayList<Integer> output = new ArrayList<Integer>();
	            output.add(root.data);
	            return output;
	        }else if(data < root.data){
	            ArrayList<Integer> leftOutput = getPath(root.left , data);
	            if(leftOutput != null) {
	                leftOutput.add(root.data);
	            }
	            return leftOutput;
	        }else{
	            ArrayList<Integer> rightOutput = getPath(root.right , data);
	            if(rightOutput != null) {
	                rightOutput.add(root.data);
	            }
	            return rightOutput;
	        }
	    }
}
