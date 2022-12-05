//Error if two alternate paths from 0,0
import java.util.*;
class ratinamaze{
    public static void main(String[] args) {
        intSTACK i = new intSTACK();
        intSTACK j = new intSTACK();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the square for maze: ");
        int n = sc.nextInt();
        int [][] maze = new int[n][n];
        int [][] visited = new int[n][n];
        System.out.print("Enter the number of squares you want to block: ");
        int b = sc.nextInt();
        System.out.println("Enter the coordinates of the squares you want to block (Top-left block is 0,0): ");
        for(int k = 0; k < b; k++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            maze[x][y]=1;
            visited[x][y]=1;
        }
        visited[0][0]=1;
        i.push(0);
        j.push(0);
        int p = 0;
        int q = 0;
        int flag = 0;
        while(true){
            if(p+1!=n && maze[p+1][q]==0 && visited[p+1][q]==0){
                i.push(++p);
                j.push(q);
                visited[p][q]=1;
                System.out.println("Right ");
            }
            else if(q+1!=n && maze[p][q+1]==0 && visited[p][q+1]==0){
                i.push(p);
                j.push(++q);
                visited[p][q]=1;
                System.out.println("Down ");
            }
            else if(p-1!=-1 && maze[p-1][q]==0 && visited[p-1][q]==0){
                i.push(--p);
                j.push(q);
                visited[p][q]=1;
                System.out.println("Left ");
            }
            else if(q-1!=-1 && maze[p][q-1]==0 && visited[p][q-1]==0){
                i.push(p);
                j.push(--q);
                visited[p][q]=1;
                System.out.println("Up ");
            }
            else{
                i.pop();
                j.pop();
                p=i.peek();
                q=j.peek();
            }
            if(p==n-1 && q==n-1)
                break;
            if(p==0 && q==0 && visited[p][q] == 1){
                flag=1;
                break;
            }
        }
        if(flag == 0)
        {
            i.printreverseSTACK();
            j.printreverseSTACK();

        }
        else
        {
            System.out.println("Maze cannot be solved.");
        }
        sc.close();
    }
}
class intSTACK
{
    int stack[];
    int size;
    int top;
    intSTACK()
    {
        size = 100;
        top = -1;
        stack = new int[size];
    }
    void push(int n)
    {
        if(!isFull())
        {
            stack[++top] = n;
            //System.out.println(n + " has been pushed.");
        }
        else
        {
            System.out.println("STACK OVERFLOW.");
        }
    }
    void pop()
    {
        if(!isEmpty())
        {
            //System.out.println(peek() + " has been popped.");
            top--;
        }
        else
        {
            System.out.println("STACK UNDERFLOW.");
        }
    }
    int peek()
    {
        return stack[top];
    }
    boolean isEmpty()
    {
        return top == -1;
    }
    boolean isFull()
    {
        return top == (size - 1);
    }
    void printreverseSTACK(){
        for(int i = 0; i<= top; i++)
        {
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
}