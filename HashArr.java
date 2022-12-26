// Allow quadriatic probing
// Change size of Hash Map
// Error: values being shown as inserted, at deleted locations
// E.g.: size:7; insert: 45,67,18,9,27; fullHash; delete 44,18,27; fullHash; insert:13(err),1,5; fullHash; hash; done
import java.util.*;
public class HashArr
{
    // Global variables
    int size,currSize;
    int[] data;
    String[] key;

    // Constructor
    HashArr(int size)
    {
        this.size=size;
        currSize=0;
        data=new int[size];
        key=new String[size];
        for(int i=0;i<size;i++)
        key[i]="E";
    }
    
    // Get hash value
    int hashVal(int n)
    {
        return n%size;
    }

    // Insert a value
    void add(int n)
    {
        int start=hashVal(n);
        int i=start;
        do
        {
            if(key[i]=="E")
            {
                key[i]="O";
                data[i]=n;
                currSize++;
                System.out.println("Value inserted at "+i);
                return;
            }
            // Error here
            else if(key[i]=="D")
            {
                key[i]="O";
                System.out.println("Value inserted at "+i);
            }
            else
            {
                i=(i+1)%size;
            }
        }while(i!=start);
        if(i==start)
        System.out.println("No space in HashMap!!");
    }

    // Search a value, Return index if found and -1 if not found.
    int find(int n)
    {
        int start=hashVal(n);
        int i=start;
        do
        {
            if(data[i]==n && key[i]=="O")
            return i;
            i=(i+1)%size;
        }while(i!=start);
        return -1;
    }

    // Delete a value
    void del(int n)
    {
        int pos=find(n);
        if(pos==-1)
        System.out.println(n+" not present!!");
        else
        {
            key[pos]="D";
            System.out.println(n+" was deleted");
            currSize--;
        }
    }

    // Print HashMap
    void print()
    {
        System.out.println("\nHashMap:-");
        for(int i=0;i<size;i++)
        {
            if(key[i]=="O")
            System.out.println(data[i]);
        }
    }

    // Print entire HashMap
    void printFull()
    {
        System.out.println("\nHashMap:-");
        for(int i=0;i<size;i++)
        {
            System.out.println(i+"\t"+key[i]+"\t"+data[i]);
        }
    }

    // check if HashMap is full
    boolean isFull()
    {
        return currSize==size?true:false;
    }

    // Driver code
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int s,ch,f;
        System.out.print("\nEnter size of HashMap: ");
        s=sc.nextInt();
        HashArr hash=new HashArr(s);
        do
		{
			System.out.println("\nMenu:-\n1.Add value\n2.Delete value\n3.Find value\n4.Print HashMap\n5.Print full HashMap\n6.Exit");
			System.out.print("Enter choice: ");
            ch=sc.nextInt();
			switch(ch)
			{
				case 1:
				System.out.print("\nEnter value to be inserted: ");
				hash.add(sc.nextInt());
				break;
				case 2:
				System.out.print("\nEnter value to be deleted: ");
				hash.del(sc.nextInt());
				break;
				case 3:
				System.out.print("\nEnter value to be searched: ");
				f=hash.find(sc.nextInt());
                if(f==-1)
                System.out.println("Value not found!!");
                else
                System.out.println("Value found at index "+f);
				break;
				case 4:
				hash.print();
				break;
                case 5:
				hash.printFull();
				break;
                case 6:
				System.out.println("Finished!!");
				break;
				default:
				System.out.println("Invalid Input");
			}
		}while(ch!=6);
        sc.close();
    }
}