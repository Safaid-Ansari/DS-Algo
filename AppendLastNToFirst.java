package LinkedListDataStructure;

import java.util.Scanner;

public class AppendLastNToFirst {
	
	
	
	public static Node<Integer> takeInput()
	{
		Scanner s=new Scanner(System.in);
		int data=s.nextInt();
		
		Node<Integer> head=null,tail=null;
		while(data!=-1)
		{
			Node<Integer> currentNode = new Node<Integer>(data);
			if(head==null)
			{
				// Make this node as head node
				head=currentNode;
				tail=currentNode;
			}else
			{
				
			  tail.next=currentNode;
			  tail=currentNode;
			}
			data=s.nextInt();
			  
		}
		return head;
	}
	
	public static int LengthIterative(Node<Integer>head){
		int count=0;
		while(head!=null)
		{
			count++;
			head=head.next;
		}
		return count;
	}

	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		//Your code goes here
		if (head == null || n == 0)
        { return head; }
        Node<Integer>temp1=head;
		Node<Integer>temp2=head;
		int length=LengthIterative(head);
		int i=0;
		while(i<length-n-1)
		{
			temp1=temp1.next;
			i++;
		}
		head=temp1.next;
		temp1.next=null;
		Node<Integer>tempHead=head;
		while(tempHead.next!=null)
		{
			tempHead=tempHead.next;
		}
		tempHead.next=temp2;
		return head;
		
	}
		
	public static void ReversePrint(Node<Integer> head)
	  {    
	      Node<Integer> curNode=head;

	      if(curNode!=null){
	          if(curNode.next!=null){
	              ReversePrint(curNode.next);
	          }
	          System.out.print(curNode.data+" ");
	      }
	  }
	
	public static void print(Node<Integer> head)
	{
		Node<Integer>temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Node<Integer> head=takeInput();
		int n=s.nextInt();
        head=appendLastNToFirst(head,n);
		print(head);
//		int result=LengthIterative(head);
//		System.out.println(result);
//	
//		ReversePrint(head);

	}

}
