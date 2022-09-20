import java.util.*;
class _stackADT
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int ch;
        System.out.println("Enter size of stack:");
        _intstack obj=new _intstack(sc.nextInt());
        do
        {
            System.out.println("\nMenu:-\n1.Push\n2.Pop\n3.Current length\n4.Peek\n5.Display\n6.IsEmpty?\n7.IsFull?\n8.Exit\nEnter choice:");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.print("Enter element:");
                obj.push(sc.nextInt());
                break;
                case 2:
                obj.pop();
                break;
                case 3:
                System.out.println("Current length of stack is: "+obj.length());
                break;
                case 4:
                if(obj.isEmpty())
                {
                    System.out.println("Stack is empty!");
                }
                else
                {
                    System.out.println("Top element is: "+obj.peek());
                }
                break;
                case 5:
                System.out.println(obj.isEmpty()?"Stack is empty!":"Current stack is:-");
                obj.display();
                System.out.println("");
                break;
                case 6:
                System.out.println(obj.isEmpty()?"Stack is empty.":"Stack isn't empty.");
                break;
                case 7:
                System.out.println(obj.isFull()?"Stack is full.":"Stack isn't full.");
                break;
                case 8:
                System.out.println("Finished!!");
                break;
                default:System.out.println("Invalid input!!");
            }
        }while(ch!=8);
    }
}
