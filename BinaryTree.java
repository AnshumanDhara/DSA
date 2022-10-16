import java.util.*;
class Node
{
    int data;
    Node left;
    Node right;
    Node()
    {}
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }
}
class Tree
{
    int count=1;
    Node root;
    public void create(Node x)
    {
        Scanner sc=new Scanner(System.in);
        Node node=new Node();
        node=x;
        if(root==null)
        {
            root=x;
        }
        System.out.println("Enter 1.Yes 2.No to enter element left to:"+ node.data);
        int choice=sc.nextInt();
        if(choice==1)
        {
            count++;
            System.out.println("Enter the data to left of:"+ node.data);
            int n=sc.nextInt();
            node.left=new Node(n);
            this.create(node.left);
        }
        else
        {
            node.left=null;
        }
        System.out.println("Enter 1.Yes 2.No to enter element right to:"+ node.data);
        choice=sc.nextInt();
        if(choice==1)
        {
            count++;
            System.out.println("Enter the data to right to:"+node.data);
            int n=sc.nextInt();
            node.right=new Node(n);
            this.create(node.right);
        }
        else
        {
            node.right=null;
        }
    }
    void inorder(Node a)
    {
        if(a!=null)
        {
            this.inorder(a.left);
            System.out.println(a.data);
            this.inorder(a.right);
        }
    }
    void preorder(Node a)
    {
        if(a!=null)
        {
            System.out.println(a.data);
            this.preorder(a.left);
            this.preorder(a.right);
        }
    }
    void postorder(Node a)
    {
        if(a!=null)
        {
            this.postorder(a.left);
            this.postorder(a.right);
            System.out.println(a.data);
        }
    }
    void showcount()
    {
        System.out.println("Number of nodes:"+count);
    }
    void mirror()
    {
        root=mirror(root);
    }
    Node mirror(Node node)
    {
        if(node==null)
        {
            return node;
        }
        else
        {
            Node left=mirror(node.left);
            Node right=mirror(node.right);
            node.left=right;
            node.right=left;
            return node;
        }
    }
}
class BinaryTree
{
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
    Tree bi=new Tree();
    System.out.println("Enter the root value of tree");
    int root=sc.nextInt();
    Node r=new Node(root);
    bi.create(r);
    System.out.println("Inorder of tree");
    bi.inorder(r);
    System.out.println("Preorder of tree");
    bi.preorder(r);
    System.out.println("Postorder of tree");
    bi.postorder(r);
    bi.showcount();
    bi.mirror();
    System.out.println("Tree was mirrored.\nInorder of tree");
    bi.inorder(r);
    }
}