package LinkedListDataStructure;

import java.util.Scanner;

public class KReverse {

	
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
	
	
	public static Node<Integer> kReverse(Node<Integer>  head, int k) {
		if(head == null || k==0) 
            return head;

		Node<Integer>  prev = null;
		Node<Integer>  temp = head;
        int c = 0;

        while(temp != null && c < k ) {
        	Node<Integer>  next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            c++;
        }
        if(temp != null) {
            head.next = kReverse(temp,k);
        }
        return prev;
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
		
		Scanner s=new Scanner(System.in);
		int k=s.nextInt();
		
		head=kReverse(head,k);
		printR(head);
	}

}
