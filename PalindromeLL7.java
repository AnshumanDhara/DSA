import java.util.*;

public class PalindromeLL7
{
    Node head=null;
    
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


    void addLast(int value)
    {
        Node newNode=new Node(value);
        Node temp=head;
        if(head==null)
        {
            head=newNode;
            return;
        }
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
    }

    void addFirst(int value)
    {
        Node newNode=new Node(value);
        newNode.next=head;
        head=newNode;
    }

    void clear()
    {
        head=null;
    }

    Node reverse()
    {
        PalindromeLL7 ob2=new PalindromeLL7();
        Node temp=head;
        while(temp!=null)
        {
            ob2.addFirst(temp.data);
            temp=temp.next;
        }
        return ob2.head;
    }
    
    int check()
    {
        int flag=1;
        Node temp=head;
        Node temp2=reverse();
        while(temp!=null)
        {
            if(temp.data!=temp2.data)
            {
                flag=0;
                break;
            }
            temp=temp.next;
            temp2=temp2.next;
        }
        return flag;
    }

    void disp()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        PalindromeLL7 ob=new PalindromeLL7();
        System.out.println("\nMenu:-\n1.Add data\n2.New LL\n3.Check if Palindrome\n4.Display LL\n5.Exit");
        int ch;
        do
        {
            System.out.print("\nEnter your choice: ");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.print("Enter data: ");
                ob.addLast(sc.nextInt());
                break;
                case 2:
                System.out.print("Linklist cleared");
                ob.clear();
                break;
                case 3:
                int pal=ob.check();
                if(pal==1)
                System.out.println("Palindrome");
                else
                System.out.println("Not Palindrome");
                break;
                case 4:
                System.out.println("Linked List:-");
                ob.disp();
                break;
                case 5:
                System.out.print("Finished!!");
                break;
                default:System.out.println("Invalid Input");
            }
        }while(ch!=5);
        sc.close();
    }
}