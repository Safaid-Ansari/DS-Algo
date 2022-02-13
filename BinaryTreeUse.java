package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

import LinkedListDataStructure.Node;

public class BinaryTreeUse {
	
	
//	public static BinaryTreeNode<Integer> takeTreeInput()
//	{
//		
//		System.out.println("Enter Root Data");
//		
//		Scanner s=new Scanner(System.in);
//		
//		int rootdata=s.nextInt();
//		
//		
//		if(rootdata==-1)
//		{
//			return null;
//		}
//		
//		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootdata);
//	    BinaryTreeNode<Integer> rootleft=takeTreeInput();
//	    BinaryTreeNode<Integer> rootright=takeTreeInput();
//	    
//	    root.left=rootleft;
//	    root.right=rootright;
//	    
//	    return root;
//	}
	
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
	
public static int NumberOfNodes(BinaryTreeNode<Integer>root)
{
	if(root==null)
	{
		return 0;
	}
	int leftNodeCount=NumberOfNodes(root.left);
	int rightNodeCount=NumberOfNodes(root.right);
	return 1+leftNodeCount+rightNodeCount;
}
	
public static int  largest(BinaryTreeNode<Integer> root)
{
	if(root==null)
	{
		return -1;
	}
	int largestLeft=largest(root.left);
	int largestRight=largest(root.right);
	return Math.max(root.data, Math.max(largestLeft, largestRight));
	
}
	
public static void preOrder(BinaryTreeNode<Integer>root)
{
	if(root==null)
	{
		return ;
	}
	System.out.print(root.data+" ");
	preOrder(root.left);
	preOrder(root.right);
}
	
public static void postOrder(BinaryTreeNode<Integer>root)
{
	if(root==null)
	{
		return;
	}
	postOrder(root.left);
	postOrder(root.right);
	System.out.print(root.data+" ");
	
}
	
public static void inOrder(BinaryTreeNode<Integer> root)
{
	if(root==null)
	{
		return;
	}
	inOrder(root.left);
	System.out.print(root.data+" ");
    inOrder(root.right);	
}
	
public static int height(BinaryTreeNode<Integer> root)
{
	if(root==null)
	{
		return 0;
	}
	else
	{
		int Lheight=height(root.left);
		int Rheight=height(root.right);
		
		if(Lheight>Rheight)
		{
		   return 1+Lheight;	
		}
		else
		{
			return 1+Rheight;
		}
	}
}
	
public static boolean IsBalanced(BinaryTreeNode<Integer> root)
{
	
	if(root==null)
	{
		return true;
	}
	
	int leftheight=height(root.left);
	int rightheight=height(root.right);
	
	if(Math.abs(leftheight - rightheight) > 1)
	{
		return false;
	}
	
	boolean leftBalanced=IsBalanced(root.left);
	boolean rightBalanced=IsBalanced(root.right);
	
	return leftBalanced && rightBalanced;
	
}
	
public static int countNodesGreaterThanX(BinaryTreeNode<Integer>root, int x)
{
	if(root==null)
	{
		return 0;
	}
	
	int countLeft=countNodesGreaterThanX(root.left,x);
	int countRight=countNodesGreaterThanX(root.right,x);
	
	return (root.data>x?1:0)+countLeft+countRight;
}
	
public static int numOfLeafNode(BinaryTreeNode<Integer>root)
{
	if(root==null)
	{
		return 0;
	}
	if(root.left==null && root.right==null)
	{
		return 1;
	}
	
	return numOfLeafNode(root.left)+numOfLeafNode(root.right);
}
	
public static BinaryTreeNode<Integer> removeLeafNode(BinaryTreeNode<Integer> root)
{
	
	if(root==null)
	{
		return null;	
	}
	if(root.left==null && root.right==null)
	{
		return null;
	}
	
	root.left=removeLeafNode(root.left);
	root.right=removeLeafNode(root.right);
	return root;
}
public static void printAtDepthK(BinaryTreeNode<Integer> root, int k)
{
	if(root==null)
	{
		return ;
	}
	if(k==0)
	{
		System.out.print(root.data+" ");
		return;
	}
	
	printAtDepthK(root.left,k-1);
	printAtDepthK(root.right,k-1);
}
	
public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
    //Your code goes here
  if (root != null) {
       if (root.data == x) {
            return true;
          } else {
              return isNodePresent(root.left, x) || isNodePresent(root.right, x);
              }
      }
       return false;
     }


public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
	//Your code goes here
     if(root==null)
    return;

if (root.left != null && root.right != null)
{
    printNodesWithoutSibling(root.left);
    printNodesWithoutSibling(root.right);
}

// If left child is NULL and right
// is not, print right child
// and recur for right child
else if (root.right != null)
{
    System.out.print(root.right.data + " ");
    printNodesWithoutSibling(root.right);
}

// If right child is NULL and left
// is not, print left child
// and recur for left child
else if (root.left != null)
{
    System.out.print( root.left.data + " ");
    printNodesWithoutSibling(root.left);
}
 

   
}

public static void mirrorBinaryTree(BinaryTreeNode<Integer> root)
{
	if(root==null)
	{
		return ;
	}
	
	mirrorBinaryTree(root.left);
	mirrorBinaryTree(root.right);
	
	swap(root);
}

public static void swap(BinaryTreeNode<Integer>root)
{ 
	if(root==null)
	{
		return;
	}
	
	BinaryTreeNode<Integer> temp=root.left;
	root.left=root.right;
	root.right=temp;
			
}
	
	public static BalancedTreeReturn IsBalancedBetter(BinaryTreeNode<Integer> root)
	{
		 if(root== null)
		 {
		     int height=0;
		     boolean isBal=true;
		     
		     BalancedTreeReturn ans=new BalancedTreeReturn();
		     
		     ans.height=height;
		     ans.isBalanced=isBal;
		     return ans;
		 }
		 
		 BalancedTreeReturn leftBalanced=IsBalancedBetter(root.left);
		 BalancedTreeReturn rightBalanced=IsBalancedBetter(root.right);
		 boolean isBal=true;
		 int height= 1+Math.max(leftBalanced.height, rightBalanced.height);
		 
		 if(Math.abs(leftBalanced.height - rightBalanced.height) > 1)
		 {
			 isBal= false;
		 }
		 
		 
		 if(!leftBalanced.isBalanced || !rightBalanced.isBalanced)
		 {
			 isBal=false;
		 }
		 
		 BalancedTreeReturn ans = new BalancedTreeReturn();
		 ans.height=height;
		 ans.isBalanced=isBal;
		 return ans;
		 
	}
	
	
	
	
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root==null)
            return;
        BinaryTreeNode<Integer> duplicateNode=new BinaryTreeNode<Integer>(root.data);
        duplicateNode.left=root.left;
        root.left=duplicateNode;
        insertDuplicateNode(duplicateNode.left);
        insertDuplicateNode(root.right);
        return;
	}
	
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        // Write your code here
        helper(root,k,"");
    }
    private static void helper(BinaryTreeNode<Integer> root,int k,String s){
        if(root==null)
            return;
        if(root.left==null && root.right==null && root.data==k)
        {
            System.out.println(s+root.data);
            return;
        }
        s=s+root.data+" ";
   
        helper(root.left,k-root.data,s);
        helper(root.right,k-root.data,s);
        
    }
    
    
    
//    public static Pair<Integer,Integer> minmax(Pair<Integer,Integer> ans,BinaryTreeNode<Integer> root ){
//        if(root == null){
//            return ans;
//        }
//        if(root.data>ans.maximum){
//            ans.maximum=root.data;
//        }
//        if(root.data<ans.minimum){
//            ans.minimum=root.data;
//        }
//        
//        minmax(ans,root.left);
//        minmax(ans,root.right);
//         
//		return ans;
//    }

    public static ArrayList<Integer> NodeToRootPath(BinaryTreeNode<Integer> root , int x)
    {
    	if(root==null)
    	{
    		return null;
    	}
    	if(root.data == x)
    	{
    		ArrayList<Integer> Output=new ArrayList<Integer>();
    		Output.add(root.data);
    		return Output;
    	}
    	
    	ArrayList<Integer> leftOutput=NodeToRootPath(root.left,x);
    	if(leftOutput!=null)
    	{
    		leftOutput.add(root.data);
    		return leftOutput;
    	}
    	
    	ArrayList<Integer> rightOutput=NodeToRootPath(root.right,x);
    	if(rightOutput!=null)
    	{
    		rightOutput.add(root.data);
    		return rightOutput;
    	}
    	
    	return null;
    }
    
    
    
    public static boolean printLevel(BinaryTreeNode<Integer> root, int level)
    {
        // base case
        if (root == null) {
            return false;
        }
 
        if (level == 1)
        {
            System.out.print(root.data + " ");
 
            // return true if at least one node is present at a given level
            return true;
        }
 
        boolean left = printLevel(root.left, level - 1);
        boolean right = printLevel(root.right, level - 1);
 
        return left || right;
    }
 
    // Function to print level order traversal of a given binary tree
    public static void levelOrderTraversal(BinaryTreeNode<Integer> root)
    {
        // start from level 1 — till the height of the tree
        int level = 1;
 
        // run till printLevel() returns false
        while (printLevel(root, level)) {
            level++;
        }
    }
 
    public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int [] pre,int [] in, int siPre, int eiPre, int siIn, int eiIn)
    {
    	if(siPre>eiPre)
    	{
    		return null;
    	}
    	int rootData=pre[siPre];
    	BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
    	
    	int rootIndex=-1;
    	for(int i=siIn;i<=eiIn;i++) {
    		if(in[i]==rootData) {
    		rootIndex=i;
    		break;
    		}
    	}
    	 
    	// I am assuming that root actually is present in inorder
    	
    	int siPreLeft = siPre+1;
    	int siInLeft=siIn;
    	int eiInLeft = rootIndex-1;
 
    	int siInRight = rootIndex+1;
    	int eiPreRight = eiPre;
    	int eiInRight =eiIn;
    	
    	int leftSubtreeLength=eiInLeft-siInLeft+1;
    	
    	int eiPreLeft=siPreLeft + leftSubtreeLength-1;
    	int siPreRight=eiPreLeft+1;
    	
    	BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(pre,in,siPreLeft, eiPreLeft,siInLeft,eiInLeft);
    	BinaryTreeNode<Integer> right=buildTreeFromPreInHelper(pre,in,siPreRight,eiPreRight,siInRight,eiInRight);
    	
    	root.left=left;
    	root.right=right;
    	return root;
    	
    }
	public static BinaryTreeNode<Integer> buildTreeFromPreIn(int pre[],int in[])
	{
		BinaryTreeNode<Integer> root=buildTreeFromPreInHelper(pre,in,0,pre.length-1,0,in.length-1);
				return root;
	}
    public static void print(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print(root.data+" ");
		print(root.left);
		print(root.right);
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
		

		/*
		 * BinaryTreeNode<Integer> root=takeTreeInputBetter(true,0,true);
		 * 
		 * printDetailed(root); int result=height(root); System.out.println(result);
		 * result=countNodesGreaterThanX(root,5); System.out.println(result);
		 * System.out.println("Number of Nodes "+NumberOfNodes(root));
		 * System.out.println("Largest is "+largest(root));
		 * System.out.println("Number of Leaf Node "+numOfLeafNode(root));
		 * System.out.println("Print At Depth K "); printAtDepthK(root,2);
		 * System.out.println(isNodePresent(root,5));
		 * 
		 * mirrorBinaryTree(root); printDetailed(root);
		 * 
		 * 
		 * System.out.println("Is Balanced factor  "+IsBalanced(root));
		 * System.out.println("Is Balanced factor  "+IsBalancedBetter(root));
		 * 
		 * ArrayList<Integer> path=NodeToRootPath(root,5); if(path==null) {
		 * System.out.println("Path Not Found"); } else { for(int i:path) {
		 * System.out.println(i); } }
		 */
		
		
		int in[]= {4,2,5,1,3};
		int pre[]= {1,2,4,5,3};
		
		BinaryTreeNode<Integer> root=buildTreeFromPreIn(pre, in);
		
		printDetailed(root);

	}

}
