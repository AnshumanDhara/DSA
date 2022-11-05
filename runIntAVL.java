import java.util.*;
class runIntAVL
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        createIntAVL obj = new createIntAVL();   
        int ch;
        do      
        {  
            System.out.println("\nMenu:\n");  
            System.out.println("1. Insert a node");
            System.out.println("2. Display AVL Tree in In order");
            System.out.println("3. Exit");
            ch = sc.nextInt();              
            switch (ch)  
            {  
                case 1 :   
                    System.out.println("Please enter an element to insert in AVL Tree");  
                    obj.insertdata( sc.nextInt() );                       
                    break;                            
                case 2 :   
                    System.out.println("\nDisplay AVL Tree in In order");  
                    obj.inorder();  
                    break;
                case 3:
                System.out.println("Finished!!");
                break;
                default :   
                System.out.println("Invalid input");      
            }                         
        } while (ch!=3);       
    }
}