import java.util.*;
class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data=data;
		next=null;
	}
}
class LinkedList
{
	Node head;
	LinkedList insert(LinkedList list,int a)
	{
		Node new_node=new Node(a);
		if(list.head==null)
		{
			list.head=new_node;
		}
		else
		{
			Node last=list.head;
			while(last.next!=null)
			{
				last=last.next;
			}
			last.next=new_node;
		}
		return list;
	}
	void print(LinkedList list)
	{
		Node currNode=list.head;
		System.out.println("Linked list is:- ");
		while(currNode!=null)
		{
			System.out.print(currNode.data+" ");
			currNode=currNode.next;
		}
	}
}
class _LLADT
{
    public static void main(String[] args)
	{
		int ch;
		Scanner sc=new Scanner(System.in);
		LinkedList list=new LinkedList();
		do
		{
			System.out.println("\nMenu:-\n1.Enter a no.\n2.Print LL\n3.Exit\nEnter choice:-");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:
				list.insert(list,sc.nextInt());
				break;
				case 2:
				list.print(list);
				break;
				case 3:
				System.out.println("Finished!!");
				break;
				default:
				System.out.println("Invalid input!!");
			}
		}while(ch!=3);
	}
}