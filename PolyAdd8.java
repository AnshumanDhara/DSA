import java.util.*;

public class PolyAdd8
{
    Node head;

    class Node
    {
        int coeff;
        int exp;
        char var;
        Node next;
        Node(int coeff,char var,int exp)
        {
            this.coeff=coeff;
            this.var=var;
            this.exp=exp;
            next=null;
        }
    }
    
    void create(String s)
    {
        for(int i=0;i<s.length();)
        {
            int coeff,exp;
            char var;
            coeff=Integer.parseInt(s.substring(i,i+2));
            System.out.println(coeff);
            var=s.charAt(i+2);
            System.out.println(var);
            exp=Integer.parseInt(s.substring(i+3,i+4));
            System.out.println(exp);
            i+=4;
            addLast(coeff,var,exp);
            System.out.println();
        }
    }
    
    void addLast(int c,char character,int e)
    {
        Node newNode=new Node(c,character,e);
        Node temp=head;
        if(head==null)
        {
            head=newNode;
            return;
        }
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
    }

    PolyAdd8 add(PolyAdd8 p1,PolyAdd8 p2)
    {
        PolyAdd8 ans=new PolyAdd8();
        Node temp1;
        Node temp2;
        temp1=p1.head;
        temp2=p2.head;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.exp>temp2.exp)
            {
                ans.addLast(temp1.coeff,temp1.var,temp1.exp);
                temp1=temp1.next;
            }
            else if(temp2.exp>temp1.exp)
            {
                ans.addLast(temp2.coeff,temp2.var,temp2.exp);
                temp2=temp2.next;
            }
            else
            {
                ans.addLast(temp1.coeff+temp2.coeff,temp1.var,temp1.exp);
                temp1=temp1.next;
                temp2=temp2.next;
            }
        }
        return ans;
    }

    void disp()
    {
        Node temp=head;
        while(temp.next!=null)
        {
            System.out.print(temp.coeff+""+temp.var+""+temp.exp);
            temp=temp.next;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        String s1,s2;
        System.out.println("Enter 1st Polynomial(along with sign & exp of each term):-");
        s1=sc.next();
        System.out.println("Enter 2nd Polynomial(along with sign & exp of each term):-");
        s2=sc.next();
        PolyAdd8 poly1=new PolyAdd8();
        PolyAdd8 poly2=new PolyAdd8();
        PolyAdd8 poly3=new PolyAdd8();
        poly1.create(s1);
        poly2.create(s2);
        poly3=poly1.add(poly1,poly2);
        poly3.disp();
        sc.close();
    }
}