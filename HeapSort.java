import java.util.*;
public class HeapSort
{
    int heap[];
    int size;
    int temp;
    HeapSort(int size)
    {
        this.size=size;
        temp=size;
        heap=new int[size+1];
    }
    void buildHeap()
    {
        int i;
        for(i=(size+1)/2;i>=1;i--)
        heapify(i);
    }
    void heapify(int i)
    {
        int l=2*i,r=2*i+1;
        if(2*i>size)
        l=-1;
        if(2*i+1>size)
        r=-1;
        if(l==-1 && r==-1)
        return;
        else if(r==-1 && heap[i]<heap[l])
        {
            swap(i,l);
            heapify(l);
        }
        else
        {
            if(heap[i]<heap[r] || heap[i]<heap[l])
            {
                if(heap[l]>heap[r])
                {
                    swap(i,l);
                    heapify(l);
                }
                else
                {
                    swap(i,r);
                    heapify(r);
                }
            }
        }
    }
    void swap(int a,int b)
    {
        int temp;
        temp=heap[a];
        heap[a]=heap[b];
        heap[b]=temp;
    }
    void print()
    {
        int i;
        for(i=1;i<=temp;i++)
        System.out.print(heap[i]+" ");
    }
    void heapSort()
    {
        int i;
        for(i=size;i>=2;i--)
        {
            swap(i,1);
            size--;
            heapify(1);
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int i;
        System.out.println("Enter size of heap: ");
        HeapSort ob=new HeapSort(sc.nextInt());
        System.out.println("Enter elements of heap: ");
        for(i=1;i<=ob.size;i++)
        ob.heap[i]=sc.nextInt();
        ob.buildHeap();
        System.out.println("\nInitial heap:-");
        ob.print();
        ob.heapSort();
        System.out.println("\nSorted heap:-");
        ob.print();
    }
}
