import java.util.*;
import java.util.LinkedList;
public class Graph
{
    int V;
    LinkedList<Integer> adj[];
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        sc.close();
    }
}
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
	_LinkedList add(_LinkedList list,int a)
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
}