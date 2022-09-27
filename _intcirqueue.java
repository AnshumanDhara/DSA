public class _intcirqueue
{
    int queue[];
    int front,rear;
    int size,temp;
    _intcirqueue(int n)
    {
        front=0;
        rear=0;
        size=n;
        queue=new int[n];
    }
    void insert(int a)
    {
        if(isFull())
        {
            System.out.println("Queue is full!!");
        }
        else
        {
            queue[rear]=a;
            rear=(rear+1)%size;
            System.out.println(a+" was inserted");
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
            System.out.println(queue[front]+ " was deleted");
            front=(front+1)%size;
        }
    }
    int peek()
    {
        return queue[front];
    }
    int length()
    {
        return rear<front?(rear+size)-front:rear-front;
    }
    void display()
    {
        temp=front;
        while(temp%size!=rear)
        {
            System.out.print(queue[temp]+" ");
            temp++;
        }
    }
    boolean isEmpty()
    {
        return front==rear?true:false;
    }
    boolean isFull()
    {
        return (front-rear)%size==1?true:false;
    }
}
