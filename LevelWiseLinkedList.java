package BinarySearchTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import LinkedListDataStructure.Node;

import BinaryTree.BinaryTreeNode;
public class LevelWiseLinkedList {

	
	
	
	public static ArrayList<Node<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
        // Write your code here
       if (root == null) {
            return null;		
        }		
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();		
        pendingNodes.add(root);
        int currentLevelRemaining = 1;	   
        int nextLevelCount = 0;
        Node<Integer> currentLevelHead = null;		
        Node<Integer> currentLevelTail = null;		
        ArrayList<Node<Integer>> output = new ArrayList<>();	
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;				
            currentNode = pendingNodes.remove();				
            Node<Integer> newNode = new Node<Integer>(currentNode.data);				
            if (currentLevelHead == null) {					
                currentLevelHead = newNode;
                currentLevelTail = newNode;
            }
            else {
                currentLevelTail.next = newNode;
                currentLevelTail = newNode;
            }
            if (currentNode.left != null) {
                pendingNodes.add(currentNode.left);
                nextLevelCount++;
            }
            if (currentNode.right != null) {
                pendingNodes.add(currentNode.right);
                nextLevelCount++;
            }	
            currentLevelRemaining--;
            if (currentLevelRemaining == 0) {
                output.add(currentLevelHead);
                currentLevelHead = null;
                currentLevelTail = null;
                currentLevelRemaining = nextLevelCount;
                nextLevelCount=0;
            }
        }
        return output;
    }
}
