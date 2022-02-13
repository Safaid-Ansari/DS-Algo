package LinkedListDataStructure;

import java.util.Scanner;

public class MergeSort {
	
	public static Node<Integer> takeInput()
	{
		Scanner s=new Scanner(System.in);
		int data=s.nextInt();
	 
		Node<Integer> head=null,tail=null;
		
		while(data!=-1)
		{
			Node<Integer> currentNode=new Node<Integer>(data);
			if(head==null)
			{
				head=currentNode;
				tail=currentNode;
			}
			else
			{
				tail.next=currentNode;
				tail=currentNode;
			}
			data=s.nextInt();
		}
		return head;
	}
	
	
	
	 public static Node<Integer> getMiddle(Node<Integer> head)
	    {
	        if (head == null)
	            return head;

	        Node<Integer> slow = head, fast = head;

	        while (fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
	    
	    
	    
	   public static Node<Integer> sortedMerge(Node<Integer> a, Node<Integer> b)
	    {
		   Node<Integer> result = null;
	        /* Base cases */
	        if (a == null)
	            return b;
	        if (b == null)
	            return a;

	        /* Pick either a or b, and recur */
	        if (a.data <= b.data) {
	            result = a;
	            result.next = sortedMerge(a.next, b);
	        }
	        else {
	            result = b;
	            result.next = sortedMerge(a, b.next);
	        }
	        return result;
	    }

		public static Node<Integer> mergeSort(Node<Integer> head) {
			//Your code goes here
	        
	         // Base case : if head is null
	        if (head == null || head.next == null) {
	            return head;
	        }

	        // get the middle of the list
	        Node<Integer> middle = getMiddle(head);
	        Node<Integer> nextofmiddle = middle.next;

	        // set the next of middle node to null
	        middle.next = null;

	        // Apply mergeSort on left list
	        Node<Integer> left = mergeSort(head);

	        // Apply mergeSort on right list
	        Node<Integer> right = mergeSort(nextofmiddle);

	        // Merge the left and right lists
	        Node<Integer> sortedlist = sortedMerge(left, right);
	        return sortedlist;
		}
		
		public static void printR(Node<Integer>head)
		{
			if(head==null)
				return;
			System.out.print(head.data+" ");
			printR(head.next);
		}

	public static void main(String[] args) {
		
		Node<Integer> head=takeInput();
		
		Node<Integer> result=mergeSort(head);
		printR(result);

	}

}
