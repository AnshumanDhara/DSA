package DSA.Experiments.Exp_2;
import java.util.*;
class Queue_ADT
{
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n,ch;
        System.out.println("Enter size of queue:");
        n=sc.nextInt();
        IntQueue obj=new IntQueue(n);
        do
        {
            System.out.println("Menu:-\n1.Insert\n2.Delete\n3.No. of elements\n4.Peek\n5.Display\n");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("Enter element:");
                obj.insert(sc.nextInt());
                break;
                case 2:
                obj.delete();
                break;
                case 3:
                obj.length();
                break;
                case 4:
                obj.peek();
                break;
                case 5:
                obj.display();
                break;
                default:System.out.println("Invalid input!!");
            }
        }while(ch!=6);
    }
}