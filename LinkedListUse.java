package LinkedListDataStructure;

import java.util.Scanner;

public class LinkedListUse {

//	public static Node<Integer> CreateLinkedList()
//	{
//		Node<Integer> n1=new Node<>(10);
//		Node<Integer> n2=new Node<>(20);
//		Node<Integer> n3=new Node<>(30);
//		Node<Integer> n4=new Node<>(40);
//		
//		n1.next=n2;
//		n2.next=n3;
//		n3.next=n4;
//		n4=null;
//		return(n1);
//	}
//	 

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
	
	public static Node<Integer> Insert(Node<Integer> head, int ele, int pos)
	{
		Node<Integer> NodeToBeInsert=new Node<Integer>(ele);
		if(pos==0 )
		{
			NodeToBeInsert.next=head;
			return NodeToBeInsert;
		}
		else
		{
			int count=0;
			Node<Integer> prev=head;
			while(count<pos-1 && prev!=null)
			{
				count++;		
				prev=prev.next;
			}
			if(prev!=null)
			{
				NodeToBeInsert.next=prev.next;
				prev.next=NodeToBeInsert;
			}
			return head;
		}
		
	}
	
	public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
		
        
         if(head==null )
            return head;
        if(pos==0)
            return head.next;
        int count=0;
        Node<Integer> temp=head;
        while(temp!=null && count<pos-1)
        {
            temp=temp.next;
            count++;
        }
        if(temp==null)
            return head;
        if(temp.next!=null)
            temp.next=temp.next.next;
         
        
        return head;
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

	public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2)
	{
		if(head1==null)
		{
			return head2;
		}
		if(head2==null)
		{
			return head1;
		}
		
		Node<Integer> t1=head1,t2=head2;
		Node<Integer> head=null, tail=null;
		
		if(t1.data<=t2.data)
		{
			head=t1;
			tail=t1;
			t1=t1.next;
		}
		else
		{
			head=t2;
			tail=t2;
			t2=t2.next;
		}
		
		while(t1!=null && t2!=null)
		{
			if(t1.data<=t2.data)
			{
				tail.next=t1;
				tail=t1;
				t1=t1.next;	
			}
			else
			{
				tail.next=t2;
				tail=t2;
				t2=t2.next;
			}
		}
		
		// One list is Over
		if(t1!=null)
		{
			// First list is remaining
			tail.next=t1;
		}
		else
		{
			tail.next=t2;
		}
		return head;
	}  
	public static void printIthNode(Node<Integer> head, int i){
		//Your code goes here
    
	      Node<Integer>current=head;
	       int count=0;
	       while(current!=null)
	       {
	    	   if(count==i)
	    	   {
	    		 System.out.print(current.data);
	    	   }
	    	   count++;
	    	   current=current.next;
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
	
	public static void increment(Node<Integer> head)
	{
	    Node<Integer> temp=head;
	    while(temp!=null)
	    {
	    	temp.data++;
	    	System.out.print(temp.data+" ");
	    	temp=temp.next;
	    }
	    
	}
	
	
	public static int length(Node<Integer> head)
	{
		Node<Integer> temp=head;
		int count=0;
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		return count;
	}	
	
	
	public static void main(String[] args) {
		
//		Node<Integer> head = takeInput();
		
		//head=deleteNode(head,4);
		
		//printIthNode(head,3);
		
//		int result=findNode(head,34);
//		System.out.println(result);
		
	  // head=Insert(head,100,4);
		
		//print(head);
		//increment(head);
		
		Node<Integer> head1=takeInput();
		Node<Integer> head2=takeInput();
		
		Node<Integer> result=merge(head1,head2);
		print(result);
		
		
		

	}

}
