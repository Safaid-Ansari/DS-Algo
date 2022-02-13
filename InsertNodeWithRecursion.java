package LinkedListDataStructure;

import java.util.Scanner;

public class InsertNodeWithRecursion {

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
	
	public static Node<Integer> InsertR(Node<Integer> head, int ele, int pos)
	{
		if(head==null && pos>0)
		{
			return head;
		}
		if(pos==0)
		{
			Node<Integer> newNode=new Node<Integer>(ele);
			newNode.next=head;
			return newNode;
		}
		else
		{
			head.next=InsertR(head.next,ele,pos-1);
			return head;
		}
	}
	public static Node<Integer> DeleteNodeRec(Node<Integer> head , int pos)
	{
		if(head==null && pos>=0)
		{
			return head;
		}
		if(pos==0)
		{
			return head.next;
		}
		else
		{
			head.next=DeleteNodeRec(head.next,pos-1);
			return head;
		}
	}
	
	public static Node<Integer> ReverseLinkedList(Node<Integer> head)
	{
		if(head==null || head.next==null)
		{
			return head;
		}
		Node<Integer> result=ReverseLinkedList(head.next);
		head.next.next=head;
		
		head.next=null;
		return result;
	}
	
	
	public static int findNode(Node<Integer> head, int n) {
		// Write your code here.
        Node<Integer> temp=head;
        
        if(temp==null)
        {
            return -1;
        }
        else
        {
            if(temp.data!=n)
            {
                int k=findNode(temp.next,n);
                if(k!=-1)
                    return k+1;
                return -1;
            }
            else
                return 0;
        }
	}
	
	public static Node<Integer> MidPoint(Node<Integer> head)
	{
		Node<Integer> slow=head,fast=head;
		if(head==null)
		{
			return head;
		}
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
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
//      head=InsertR(head,40,2);
//      head=DeleteNodeRec(head,3);
//      head=ReverseLinkedList(head);
      head=MidPoint(head);
      System.out.print(head.data);
      // int x= findNode(head,n);
//      printR(head);
	}

}
