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
	void addLast(int value)
	{
		Node newNode=new Node(value);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			Node last=head;
			while(last.next!=null)
			{
				last=last.next;
			}
			last.next=newNode;
		}
	}

	void addFirst(int value)
	{
		Node newNode=new Node(value);
		if(head==null)
		head=newNode;
		else
		{
			newNode.next=head;
			head=newNode;
		}
	}
	
	void addAfter(int value)
	{
		Node newNode=new Node(value);
		int flag=0;

	}

	void addBefore(int value)
	{
		Node newNode=new Node(value);
		Node temp=head;
		int flag=0;
	}

	void delete(int value)
	{
		
	}
	
	void print()
	{
		Node currNode=head;
		System.out.println("Linked List:-");
		while(currNode!=null)
		{
			System.out.print(currNode.data+" ");
			currNode=currNode.next;
		}
		System.out.println();
	}
}
class _LLADT
{
    public static void main(String[] args)
	{
		int ch;
		Scanner sc=new Scanner(System.in);
		_LinkedList list=new _LinkedList();
		System.out.println("\nMenu:-\n1.Add Last\n2.Add First\n3.Add After\n4.Add Before\n5.Delete\n6.Print LL\n7.Exit");
		do
		{
			System.out.print("\nEnter choice: ");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:
				System.out.print("Enter value: ");
				list.addLast(sc.nextInt());
				break;
				case 2:
				System.out.print("Enter value: ");
				list.addFirst(sc.nextInt());
				break;
				case 3:
				System.out.print("Enter loc(data), value: ");
				list.addAfter(sc.nextInt(),sc.nextInt());
				break;
				case 4:
				System.out.print("Enter loc(data), value: ");
				list.addBefore(sc.nextInt(),sc.nextInt());
				break;
				case 5:
				System.out.print("Enter value: ");
				list.delete(sc.nextInt());
				break;
				case 6:
				list.print();
				break;
				case 7:
				System.out.println("Finished!!");
				break;
				default:
				System.out.println("Invalid input!!");
			}
		}while(ch!=7);
		sc.close();
	}
}