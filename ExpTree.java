import java.util.*;

// Node of ExpTree
class Node
{
    char data;
    Node left;
    Node right;
    Node(char data)
    {
        this.data=data;
        left=null;
        right=null;
    }
}

// Create Expression Tree
class createExpTree
{
    // To check if char is Operator
    boolean isOperator(char c)
    {
        if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^')
        return true;
        else
        return false;
    }
    // To create Expression Tree
    Node Tree(String postfix)
    {
        _stackNode stack=new _stackNode(100);
        Node temp=null;
        for(int i=0;i<postfix.length();i++)
        {
            if(isOperator(postfix.charAt(i)))
            {
                temp = new Node(postfix.charAt(i));
                temp.right = stack.pop();
                temp.left = stack.pop();
                stack.push(temp);
            }
            else
            {
                temp = new Node(postfix.charAt(i));
                stack.push(temp);
            }
        }
        temp = stack.pop();
        return temp;
    }
    // Print Tree in Inorder
    void inorder(Node root){
        if(root==null) return;
 
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
}

// Class for Stack of type Node
class _stackNode
{
    
    int size,top;
    Node stack[];
    _stackNode(int n)
    {
        size=n;
        top=-1;
        stack=new Node[n];
    }
    void push(Node a)
    {
        if(isFull())
        {
            System.out.println("Stack Overflow!!");
        }
        else
        {
            stack[++top]=a;
            //System.out.println(stack[top]+" was pushed");
        }
    }
    Node pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow!!");
            return null;
        }
        else
        {
            Node temp=peek();
            //System.out.println(peek()+" was popped");
            --top;
            return temp;
        }
    }
    Node peek()
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

// Driver class
public class ExpTree
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter postfix expression: ");
        String postfix=sc.nextLine();
        createExpTree ob=new createExpTree();
        Node r = ob.Tree(postfix);
        System.out.println("Infix Expression:-");
        ob.inorder(r);
        sc.close();
    }
}
