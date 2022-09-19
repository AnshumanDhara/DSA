public class IntQueue
{
    int front,rear,size;
    int queue[];
    IntQueue(int n)
    {
        size=n;
        front=-1;
        rear=-1;
        queue=new int[n];
    }
    void insert(int a)
    {
        if(isFull())
        {
            System.out.println("Queue overload!!");
        }
        else if(rear==size-1)
        {
            for(int i=front+1;i<=rear;i++)
            queue[i-1]=queue[i];
            front--;
            queue[rear]=a;
            System.out.println(queue[rear]+" was inserted");
        }
        else
        {
            queue[++rear]=a;
            System.out.println(queue[rear]+" was inserted");
        }
    }
    void delete()
    {
        if(isEmpty())
        {
            System.out.println("Queue underflow!!");
        }
        else
        {
            System.out.println(queue[front++]+" was deleted");
        }
    }
    int length()
    {
        return rear-front;
    }
    int peek()
    {
        return queue[rear];
    }
    void display()
    {
        int temp[]=new int[length()];
        for(int i=0;i<length();i++)
        {
            temp[i]=queue[front+1+i];
        }
        System.out.println(temp);
    }
    boolean isEmpty()
    {
        return front==rear?true:false;
    }
    boolean isFull()
    {
        return rear-front==size?true:false;
    }
}