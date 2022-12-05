//improve code
import java.util.*;
public class _DLL
{
    Node head=null;
    int length=0;
    
    // Node for DLL
    class Node
    {
        int data;
        Node prev;
        Node next;
        Node(int data)
        {
            this.data=data;
            prev=next=null;
        }
    }
    
    // Getter method
    int getLength()
    {return length;}

    // Add value at first location
    void addFirst(int data)
    {
        Node newNode=new Node(data);
        if(head!=null)
        {
            newNode.next=head;
            head.prev=newNode;
        }
        head=newNode;
        System.out.println("Data was inserted");
        length++;
    }

    // Add value after data d
    void addAfter(int d,int data)
    {
        // Flag to check if d found or not
        Node newNode=new Node(data);
        Node temp=head;
        int flag=0;
        if(temp!=null)
        {
            while(temp!=null)
            {
                if(temp.data==d)
                {
                    flag=1;
                    break;
                }
                temp=temp.next;
            }
        }

        // If d is found, then insert (take corner case)
        if(flag==0)
        {
            System.out.println("Data not found");
        }
        else
        {
            if(temp.next==null)
            {
                newNode.prev=temp;
                temp.next=newNode;
            }
            else
            {
                Node temp2=temp.next;
                temp.next=newNode;
                newNode.prev=temp;
                temp2.prev=newNode;
                newNode.next=temp2;
            }
            System.out.println("Data was inserted");
            length++;
        }
    }

    // Both work, which one is better?
    void addBefore(int d,int data)
    {
        Node newNode=new Node(data);
        Node temp=head;
        int flag=0;
        /*if(temp==null)
        {
            System.out.println("Data not found");
            return;
        }
        else if(temp.next==null)
        {
            if(temp.data==d)
            {
                flag=1;
                newNode.next=temp;
                temp.prev=newNode;
                head=newNode;
            }
        }
        else
        {
            while(temp!=null)
            {
                if(temp.data==d)
                {
                    Node temp2=temp.prev;
                    newNode.next=temp;
                    newNode.prev=temp2;
                    temp2.next=newNode;
                    temp.prev=newNode;
                    flag=1;
                    break;
                }
                temp=temp.next;
            }
        }
        if(flag==0)
        System.out.println("Data not found");
        else
        System.out.println("Data was inserted");*/

        if(temp!=null)
        {
            if(temp.data==d)
            {
                newNode.next=temp;
                temp.prev=newNode;
                head=newNode;
                flag=1;
            }
            else
            {
                while(temp!=null)
                {
                    if(temp.data==d)
                    {
                        Node temp2=temp.prev;
                        newNode.next=temp;
                        newNode.prev=temp2;
                        temp2.next=newNode;
                        temp.prev=newNode;
                        flag=1;
                        break;
                    }
                    temp=temp.next;
                }
            }
        }
        if(flag==0)
        System.out.println("Data not found");
        else
        {
            System.out.println("Data was inserted");
            length++;
        }
    }

    // Add value at end
    void addLast(int data)
    {
        Node newNode=new Node(data);
        Node temp=head;
        if(temp==null)
        {
            head=newNode;
            System.out.println("Data was inserted");
            length++;
            return;
        }
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        newNode.prev=temp;
        temp.next=newNode;
        System.out.println("Data was inserted");
        length++;
    }

    // Display Doubly Linked List
    void disp()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        _DLL ob=new _DLL();
        int ch,val,pos;
        System.out.println("\nMenu:-\n1.Add First\n2.Add Last\n3.Add After\n4.Add Before\n5.Display\n6.Length\n7.Exit");
        do
        {
            System.out.print("\nEnter your choice: ");
            ch=sc.nextInt();
            System.out.println();
            switch(ch)
            {
                case 1:
                System.out.print("Enter value: ");
                val=sc.nextInt();
                ob.addFirst(val);
                break;
                case 2:
                System.out.print("Enter value: ");
                val=sc.nextInt();
                ob.addLast(val);
                break;
                case 3:
                System.out.print("Enter loc(data), value: ");
                pos=sc.nextInt();
                val=sc.nextInt();
                ob.addAfter(pos,val);
                break;
                case 4:
                System.out.print("Enter loc(data), value: ");
                pos=sc.nextInt();
                val=sc.nextInt();
                ob.addBefore(pos,val);
                break;
                case 5:
                System.out.println("Doubly Linked List:-");
                ob.disp();
                break;
                case 6:
                System.out.println("Length: "+ob.getLength());
                break;
                case 7:
                System.out.println("Finished!!");
                break;
                default:
                System.out.println("Invalid Input!!");
            }
        }while(ch!=7);
        sc.close();
    }
}