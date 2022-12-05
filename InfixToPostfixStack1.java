import java.util.*;

class CharStack
    {
        char stack[];
        int size,top,length;
        CharStack(int size)
        {
            this.size=size;
            stack=new char[size];
            top=0;
            length=0;
        }

        void push(char c)
        {
            if(isFull())
            {
                System.out.println("Queue Overflow");
            }
            else
            {
                stack[top++]=c;
                length++;
                System.out.println(c+" was pushed");
            }
        }

        void pop()
        {
            if(top==0)
            {
                System.out.println("Queue Underflow");
            }
            else
            {
                System.out.println(stack[top--]+" was removed");
                length--;
            }
        }

        char peek()
        {
            return stack[top];
        }

        boolean isFull()
        {
            return size==length?true:false;
        }

        boolean isEmpty()
        {
            return top==0?true:false;
        }
    }

public class InfixToPostfixStack1
{
    int getPriority(char c)
    {
        if(c=='*' || c=='/')
        return 2;
        else if(c=='+' || c=='-')
        return 1;
        else
        return -1;

    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int i;
        char c;
        InfixToPostfixStack ob=new InfixToPostfixStack();
        System.out.println("Enter infix expression:-");
        String s=sc.nextLine();
        CharStack operators=new CharStack(s.length());
        CharStack ans=new CharStack(s.length());
        operators.push('#');
        for(i=0;i<s.length();i++)
        {
            c=s.charAt(i);
            // Alphabet
            if((c>=65 && c<=90) || (c>=97 && c<=122))
            {
                ans.push(c);
            }
            // Operator
            else
            {
                int icp=ob.getPriority(c),isp=ob.getPriority(operators.peek());
                do
                {
                    if(icp>isp)
                    {
                        operators.push(c);
                    }
                    else
                    {
                        ans.push(operators.peek());
                        operators.pop();
                        operators.push(c);
                    }
                }while(!(icp>isp));
            }
        }
        while(operators.peek()!='#')
        {
            ans.push(operators.peek());
            operators.pop();
        }
        while(!ans.isEmpty())
        {
            System.out.print(ans.peek()+" ");
            ans.pop();
        }
        sc.close();
    }
}