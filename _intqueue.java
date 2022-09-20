public class _intqueue
{
    int front,rear,size;
    int queue[];
    _intqueue(int n)
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
            System.out.println("Queue overflow!!");
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
            System.out.println(queue[++front]+" was deleted");
        }
    }
    int length()
    {
        return (rear-front);
    }
    int peek()
    {
        return queue[front+1];
    }
    void display()
    {
        for(int i=0;i<length();i++)
        {
            System.out.print(queue[front+1+i]+" ");
        }
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
