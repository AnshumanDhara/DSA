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
class _LinkedList
{
	Node head;
	_LinkedList insert(_LinkedList list,int a)
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
	void print(_LinkedList list)
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
		_LinkedList list=new _LinkedList();
		do
		{
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
		sc.close();
	}
}