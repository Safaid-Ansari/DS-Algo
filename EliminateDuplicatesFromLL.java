package LinkedListDataStructure;

import java.util.Scanner;

public class EliminateDuplicatesFromLL {
	
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
	
	
public static Node<Integer> removeDuplicates(Node<Integer> head) {
		
		if(head == null || head.next == null)
            return head;
 
        Node<Integer> prev = head;    
        Node<Integer> temp = head.next;
 
        while(temp != null){
            if(temp.data.compareTo(prev.data) == 0)  //compare non primitive dataType like this not using == (VERY IMPORTANT THING TO NOTE)
            {
                prev.next = temp.next;
                temp = temp.next;
            }
            else{
                prev = temp;
                temp = temp.next; 
            }
        }
       return head;
        
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
		Node<Integer> head=takeInput();
		
		Node<Integer>head1=removeDuplicates(head);
		print(head1);

	}

}
