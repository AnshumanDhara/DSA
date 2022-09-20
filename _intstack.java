class _intstack
{
    int size,top;
    int stack[];
    _intstack(int n)
    {
        size=n;
        top=-1;
        stack=new int[n];
    }
    void push(int a)
    {
        if(isFull())
        {
            System.out.println("Stack Overflow!!");
        }
        else
        {
            stack[++top]=a;
            System.out.println(stack[top]+" was pushed");
        }
    }
    void pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow!!"); 
        }
        else
        {
            System.out.println(peek()+" was popped");
            --top;
        }
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
        for(int i=0;i<=top;i++)
        {
            System.out.print(stack[i]+" ");
        }
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