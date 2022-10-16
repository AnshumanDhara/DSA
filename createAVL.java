class Node
{
    int data;
    Node left;
    Node right;
    int height;
    Node()
    {
        data=0;
        left=null;
        right=null;
        height=0;
    }
    Node (int data)
    {
        this.data=data;
        left=null;
        right=null;
        height=0;
    }
}
class createAVL
{
    private Node rootNode;       
    public createAVL()  
    {  
        rootNode = null; 
    }
    public boolean checkEmpty()  
    {  
        if(rootNode == null)  
            return true;  
        else   
            return false;  
    }
    public void insertdata(int data)  
    {  
        rootNode = insertdata(data, rootNode);  
    }
    private int getHeight(Node node )  
    {  
        return node == null ? -1 : node.height;  
    }  
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)  
    {  
    return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;  
    }  
    private Node insertdata(int data, Node node)  
    {  
        if (node == null)  
            node = new Node(data);  
        else if (data < node.data)  
        {  
            node.left = insertdata( data, node.left );  
            if( getHeight( node.left ) - getHeight( node.right ) == 2 )  
                if( data < node.left.data )  
                    node = LL( node );  
                else  
                    node = LL2( node );  
        }  
        else if( data > node.data )  
        {  
            node.right = insertdata( data, node.right );  
            if( getHeight( node.right ) - getHeight( node.left ) == 2 )  
                if( data > node.right.data)  
                    node = RR( node );  
                else  
                    node = RR2( node );  
        }  
        else
        node.height = getMaxHeight( getHeight( node.left ), getHeight( node.right ) ) + 1;  
        return node;  
          
    }
    int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return getHeight(N.left) - getHeight(N.right);
    }
    public void deletedata(int data)
    {
        rootNode=deletedata(data,rootNode);
    }
    private Node deletedata(int data, Node node)
    {
        if (rootNode == null)
            return rootNode;
        if (data < rootNode.data)
            rootNode.left = deletedata(data,rootNode.left);
        else if (data > rootNode.data)
            rootNode.right = deletedata(data,rootNode.right);
        else
        {
            if ((rootNode.left == null) || (rootNode.right == null))
            {
                Node temp = null;
                if (temp == rootNode.left)
                    temp = rootNode.right;
                else
                    temp = rootNode.left;
                if (temp == null)
                {
                    temp = rootNode;
                    rootNode = null;
                }
                else
                    rootNode = temp;
            }
            else
            {
                Node temp = minValueNode(rootNode.right);
                rootNode.data = temp.data;
                rootNode.right = deletedata(temp.data,rootNode.right);
            }
        }
        if (rootNode == null)
            return rootNode;
        rootNode.height = Math.max(getHeight(rootNode.left), getHeight(rootNode.right)) + 1;
        int balance = getBalance(rootNode);
        if (balance > 1 && getBalance(rootNode.left) >= 0)
            return RR(rootNode);
        if (balance > 1 && getBalance(rootNode.left) < 0)
        {
            rootNode.left = LL(rootNode.left);
            return RR(rootNode);
        }
        if (balance < -1 && getBalance(rootNode.right) <= 0)
            return LL(rootNode);
        if (balance < -1 && getBalance(rootNode.right) > 0)
        {
            rootNode.right = RR(rootNode.right);
            return LL(rootNode);
        }
        return node;
    }
    Node minValueNode(Node node)
    {
        Node current = node;
        while (current.left != null)
        current = current.left;
 
        return current;
    }
    private Node LL(Node node2)  
    {  
        Node node1 = node2.left;  
        node2.left = node1.right;  
        node1.right = node2;  
        node2.height = getMaxHeight( getHeight( node2.left ), getHeight( node2.right ) ) + 1;  
        node1.height = getMaxHeight( getHeight( node1.left ), node2.height ) + 1;  
        return node1;  
    }      
    private Node RR(Node node1)  
    {  
        Node node2 = node1.right;  
        node1.right = node2.left;  
        node2.left = node1;  
        node1.height = getMaxHeight( getHeight( node1.left ), getHeight( node1.right ) ) + 1;  
        node2.height = getMaxHeight( getHeight( node2.right ), node1.height ) + 1;  
        return node2;  
    }
    private Node LL2(Node node3)  
    {  
        node3.left = RR( node3.left );  
        return LL( node3 );  
    }
    private Node RR2(Node node1)  
    {  
        node1.right = LL( node1.right );  
        return RR( node1 );  
    }
    public void inorder()  
    {  
        inorder(rootNode);  
    }  
    private void inorder(Node head)  
    {  
        if (head != null)  
        {  
            inorder(head.left);  
            System.out.print(head.data+" ");  
            inorder(head.right);  
        }  
    }
}