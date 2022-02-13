package LinkedListDataStructure;

import java.util.Scanner;

public class DeleteEveryN_Nodes {
	
	
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
	
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
		//Your code goes here
        
        if(head==null)
            return head;
        if(M==0)
            return null;
        if(N==0)
            return head;
       Node<Integer> curr=head,t;
        int count;
        while(curr!=null)
        {
        for(count=1;count<M && curr!=null;count++)
        {
            curr=curr.next;
        }
        if(curr==null)
            return head;
        t=curr.next;
        for(count=1;count<=N && t!=null;count++)
        {
            t=t.next;
        }
        curr.next=t;
        curr=t;
        }
        return head;

	}
     public static void print(Node<Integer> head) 
     
     {
    	 while(head!=null)
    	 {
    		System.out.print(head.data+" ");
    		head=head.next;
    	 }
     }
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Node<Integer> head=takeInput();
		int m=sc.nextInt();
		int n=sc.nextInt();
		head=skipMdeleteN(head,m,n);
		print(head);
		

	}

}
