import java.util.*;
public class _queueADT
{
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int ch;
        System.out.println("Enter size of queue:");
        _intqueue obj=new _intqueue(sc.nextInt());
        do
        {
            System.out.println("\nMenu:-\n1.Insert\n2.Delete\n3.Current length\n4.Peek\n5.Display\n6.IsEmpty?\n7.IsFull?\n8.Exit\nEnter choice:");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.print("Enter element:");
                obj.insert(sc.nextInt());
                break;
                case 2:
                obj.delete();
                break;
                case 3:
                System.out.println("Current length of queue is: "+obj.length());
                break;
                case 4:
                if(obj.isEmpty())
                {
                    System.out.println("Queue is empty!");
                }
                else
                {
                    System.out.println("Front element is: "+obj.peek());
                }
                break;
                case 5:
                System.out.println(obj.isEmpty()?"Queue is empty!":"Current queue is:-");
                obj.display();
                System.out.println("");
                break;
                case 6:
                System.out.println(obj.isEmpty()?"Queue is empty.":"Queue isn't empty.");
                break;
                case 7:
                System.out.println(obj.isFull()?"Queue is full.":"Queue isn't full.");
                break;
                case 8:
                System.out.println("Finished!!");
                break;
                default:System.out.println("Invalid input!!");
            }
        }while(ch!=8);
    }
}