import javax.sound.sampled.SourceDataLine;

class IntStack
{
    int size,top;
    int stack[];
    IntStack(int n)
    {
        size=n;
        top=-1;
        stack=new int[n];
    }
    void push(int a)
    {
        if(!isFull())
        {
            stack[++top]=a;
            System.out.println(stack[top]+" was pushed");
        }
        else
        System.out.println("Stack Overflow!!");
    }
    void pop()
    {
        if(!isEmpty())
        {
            System.out.println(peek()+" was popped");
            --top;
        }
        else
        System.out.println("Stack Underflow!!");
    }
    int peek()
    {
        return stack[top];
    }
    boolean isEmpty()
    {
        return top==-1?true:false;
    }
    boolean isFull()
    {
        return top==size-1?true:false;
    }
}