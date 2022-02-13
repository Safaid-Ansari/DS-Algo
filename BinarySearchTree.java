package BinarySearchTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import BinaryTree.BinaryTreeNode;

class Pair{
    LinkedList<Integer> head;
    LinkedList<Integer> tail;
}
public class BinarySearchTree {
	
	
	
public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot,int parentData,boolean isLeft)
	
	{
		if(isRoot)
		{
			System.out.println("Enter Root Data");
		}else {
			if(isLeft)
			{
				System.out.println("Enter Left Child of "+parentData);
			}else {
				System.out.println("Enter Right Child of "+parentData);
			}
		}
		
		
		Scanner s=new Scanner(System.in);
		
		int rootdata=s.nextInt();
		
		
		if(rootdata==-1)
		{
			return null;
		}
		
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootdata);
	    BinaryTreeNode<Integer> rootleft=takeTreeInputBetter(false,rootdata,true);
	    BinaryTreeNode<Integer> rootright=takeTreeInputBetter(false,rootdata,false);
	    
	    root.left=rootleft;
	    root.right=rootright;
	    
	    return root;
	}


   public static boolean SearchInBST(BinaryTreeNode<Integer> root , int data)
   {
	  if(root==null)
	 {
		return false;
	 }
	  if(root.data==data)
	  {
		  return true;
	  }
	  
	  if(root.data < data)
	  {
		  return SearchInBST(root.right,data);
	  }
	  
	  return SearchInBST(root.left,data);
	   
   }
   public static int minimum(BinaryTreeNode<Integer> root)
   {
	   if(root==null)
	   {
		   return Integer.MAX_VALUE;
	   }
	   
	   int leftMin=minimum(root.left);
	   int rightMin=minimum(root.right);
	   
	   return Math.min(root.data, Math.min(leftMin, rightMin));
   }
   
   public static int maximum(BinaryTreeNode<Integer> root)
   {
	   if(root==null)
	   {
		   return Integer.MIN_VALUE;
	   }
	   
	   int leftMax=maximum(root.left);
	   int rightMax=maximum(root.right);
	   
	   return Math.max(root.data, Math.max(leftMax, rightMax));
	   
   }
   public static boolean IsBST(BinaryTreeNode<Integer> root)
   {
	   if(root==null)
	   {
		   return true;
	   }
	   
	   int leftMax=maximum(root.left);
	   if(leftMax >= root.data )
	   {
		   return false;
	   }
	   
	   int rightMin=minimum(root.right);
	   
	   if(rightMin <=root.data)
	   {
		   return false;
	   }
	   
	   boolean isLeftBST =IsBST(root.left);
	   boolean isRightBST=IsBST(root.right);
	   
	   return isLeftBST && isRightBST;
   }
   
   public static IsBSTReturn IsBSTBetter(BinaryTreeNode<Integer> root)
   {
	   if(root== null)
	   {
		   IsBSTReturn ans=new IsBSTReturn(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
		   return ans;
	   }
	   IsBSTReturn leftAns= IsBSTBetter(root.left);
	   IsBSTReturn rightAns=IsBSTBetter(root.right);
	   
	   int min=Math.min(root.data, Math.min(leftAns.min, rightAns.min));
	   int max=Math.max(root.data, Math.max(leftAns.max, rightAns.max));
	   
	   boolean IsBST=false;
	   
	   if(leftAns.max >= root.data)
	   {
		   IsBST=false;
	   }
	   if(rightAns.min <= root.data)
	   {
		   IsBST=false;
	   }
	   
	   if(!leftAns.isBST)
	   {
		   IsBST=false;
	   }
	   if(!rightAns.isBST)
	   {
		   IsBST=false;
	   }
	   
	   IsBSTReturn ans=new IsBSTReturn(min,max,IsBST);
	   
	   return ans;
	   
	   
   }
   
   public static boolean IsBST3(BinaryTreeNode<Integer> root , int minRange , int maxRange)
   {
	   if(root== null)
	   {
		   return true;
	   }
	   if(root.data < minRange || root.data > maxRange)
	   {
		   return false;
	   }
	   
	   boolean isLeftwithinRange=IsBST3(root.left, minRange, root.data-1);
	   boolean isRightwithinRange=IsBST3(root.right,root.data, maxRange);
	   
	   return isLeftwithinRange && isRightwithinRange;
	   
   }
   
   
	
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		
        Arrays.sort(arr);

   // construct a balanced BST and return the root node of the tree
   return convert(arr, 0, arr.length - 1, null);
	}

 public static BinaryTreeNode<Integer> convert(int[] keys, int low, int high, BinaryTreeNode<Integer> root)
{
   // base case
   if (low > high) {
       return root;
   }

   // find the middle element of the current range
   int mid = (low + high) / 2;

   // construct a new node from the middle element and assign it to the root
   root = new BinaryTreeNode<Integer> (keys[mid]);

   // left subtree of the root will be formed by keys less than middle element
   root.left = convert(keys, low, mid - 1, root.left);

   // right subtree of the root will be formed by keys more than the
   // middle element
   root.right = convert(keys, mid + 1, high, root.right);

   return root;
}
   public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		 /* base case */
  if (root == null) { 
      return; 
  } 

  /* Since the desired o/p is sorted, recurse for left subtree first 
   If root->data is greater than k1, then only we can get o/p keys 
   in left subtree */
  if (k1 < root.data) { 
      elementsInRangeK1K2(root.left, k1, k2); 
  } 

  /* if root's data lies in range, then prints root's data */
  if (k1 <= root.data && k2 >= root.data) { 
      System.out.print(root.data + " "); 
  } 

  /* If root->data is smaller than k2, then only we can get o/p keys 
   in right subtree */
  if (k2 > root.data) { 
      elementsInRangeK1K2(root.right, k1, k2); 
  } 
}
   
   
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		
        if (root == null)
            return -1;
  
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (root.data > a && root.data > b)
            return getLCA(root.left, a, b);
  
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (root.data < a && root.data < b)
            return getLCA(root.right, a, b);
  
        return root.data;
	}
	
	
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		// Write your code here
        
        
        int sum = findSum(root);
        transform(root, sum);

	}
    
    public static int findSum(BinaryTreeNode<Integer> root)
    {
        if (root == null) {
            return 0;
        }
 
        return root.data + findSum(root.left) + findSum(root.right);
    }
 
    // Function to modify the BST such that every key is updated to
    // contain the sum of all greater keys
    public static int transform(BinaryTreeNode<Integer> root, int sum)
    {
        // base case
        if (root == null) {
            return sum;
        }
 
        // update the left subtree
        sum = transform(root.left, sum);
 
        // modify the sum to contain the sum of all greater keys
        sum = sum - root.data;
 
        // update the root to contain the sum of all greater keys
        root.data += sum;
 
        // update the right subtree
        sum = transform(root.right, sum);
 
        return sum;
    }
   
   public static void printDetailed(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.data+" : ");
		if(root.left!=null)
		{
			System.out.print("L"+root.left.data+", ");
		}
		if(root.right!=null)
		{
			System.out.print("R"+root.right.data);
		}
		
		System.out.println();
		printDetailed(root.left);
		printDetailed(root.right);
	}

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root=takeTreeInputBetter(true,0,true);
		
		printDetailed(root);
		
		System.out.println(SearchInBST(root,5));
		

	}

}
