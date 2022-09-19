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
    int length()
    {
        return top+1;
    }
    void display()
    {
        int temp[]=new int[top+1];
        for(int i=0;i<=top;i++)
        temp[i]=stack[i];
        System.out.println(stack);
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