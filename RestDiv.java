import java.util.*;
public class RestDiv
{
    int q_int,m_int,q_sign,m_sign,count;
    String a="",q,add_m,sub_m,m;

    // Constructors
    RestDiv()
    {}
    RestDiv(String a,String q,String q_1,String add_m,String sub_m)
    {
        this.a=a;
        this.q=q;
        this.add_m=add_m;
        this.sub_m=sub_m;
    }

    //Setter method
    void setCount()
    {
        count=q.length();
    }

    // Convert int to binary num string
    String binary(int n)
    {
        String last="";
        int i=(int)(Math.log(n)/Math.log(2));
        while(i>=0)
        {
            if(Math.pow(2,i)<=n)
            {
                n-=Math.pow(2,i);
                last+="1";
            }
            else
            last+="0";
            i--;
        }
        return last;
    }

    // 2's complement of binary num string
    String comp_2(String s)
    {
        StringBuilder string=new StringBuilder(s);
        for(int i=0;i<string.length();i++)
        {
            if(string.charAt(i)=='0')
            string.setCharAt(i,'1');
            else
            string.setCharAt(i,'0');
        }
        s=string.toString();
        return add(s,"1");
    }

    //1 means -ve sign
    int sign(int n)
    {
        return n<0?1:0;
    }

    // Add two binary num strings of different lengths
    String add(String s1,String s2)
    {
        int carry=0,sum=0,a,b;
        String last="";
        if(s1.length()>s2.length())
        s2=zeroes(s1,s2);
        else
        s1=zeroes(s2,s1);
        for(int i=s1.length()-1;i>=0;i--)
        {
            a=Integer.parseInt(String.valueOf(s1.charAt(i)));
            b=Integer.parseInt(String.valueOf(s2.charAt(i)));
            sum=(a+b+carry)%2;
            if((a==1 && b==1)||(a==1 && carry==1)||(carry==1 && b==1))
            carry=1;
            else
            carry=0;
            last=Integer.toString(sum)+last;
        }
        return last;
    }

    // Add extra zeroes to front of s_Z
    String zeroes(String s1,String s_z)
    {
        int l=s_z.length();
        for(int i=0;i<(s1.length()-l);i++)
        {
            s_z="0"+s_z;
        }
        return s_z;
    }

    // Shift left
    void lt_shift()
    {
        a=a.substring(1)+q.charAt(0);
        q=q.substring(1)+"_";
    }

    // Contains entire loop section
    void loop()
    {
        System.out.println(a+" "+q+" "+count+" Start");
        do
        {
            System.out.println(a+" "+q+" "+count+" LT SHIFT");
            lt_shift();
            System.out.println(a+" "+q+" "+count+" SUB M");
            a=add(a,sub_m);
            if(a.charAt(0)=='1')
            {
                q=q.substring(0,q.length()-1)+"0";
                System.out.println(a+" "+q+" "+count+" ADD M");
                a=add(a,add_m);
            }
            else
            {
                q=q.substring(0,q.length()-1)+"1";
            }
            System.out.println(a+" "+q+" "+count+" Count--");
        }while(--count!=0);
        System.out.println(a+" "+q+" "+count+" Final");
    }

    // Print result
    void print()
    {
        if((q_sign+m_sign)%2==0)
        {
            System.out.println("Quotient: "+q+"\n"+(q_int/m_int)+"\n"+"Remainder: "+a+"\n"+(q_int%m_int));
        }
        else
        {
            System.out.println("Do not Enter -ve numbers!!");
            System.out.println("Quotient: "+q+"\n"+"Remainder: "+a);
            //System.out.println("Binary: "+comp_2(a+q)+"\n"+"Result: "+((-1)*q_int*m_int));
        }
    }
    // Driver code
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        // Create object
        RestDiv ob=new RestDiv();
        System.out.print("Enter Dividend(Q) and Divisor(M): ");
        ob.q_int=sc.nextInt();
        ob.m_int=sc.nextInt();
        // Check if -ve
        ob.q_sign=ob.sign(ob.q_int);
        ob.m_sign=ob.sign(ob.m_int);
        ob.q_int=Math.abs(ob.q_int);
        ob.m_int=Math.abs(ob.m_int);
        // Convert to binary
        ob.q=ob.binary(ob.q_int);
        ob.m=ob.binary(ob.m_int);
        // Add extra zeroes
        if(ob.q.length()>ob.m.length())
        ob.m=ob.zeroes(ob.q,ob.m);
        else
        ob.q=ob.zeroes(ob.m,ob.q);
        ob.m="0"+ob.m;
        // If -ve then 2's comp
        if(ob.q_sign==1)
        ob.q=ob.comp_2(ob.q);
        if(ob.m_sign==1)
        ob.m=ob.comp_2(ob.m);
        // Set count
        ob.setCount();
        // Initialize
        for(int i=0;i<ob.count+1;i++) // a
        ob.a+="0";
        ob.add_m=ob.m; // add_m
        ob.sub_m=ob.comp_2(ob.m); // sub_m
        System.out.println("Initialization:-");
        System.out.println("Q: "+ob.q);
        System.out.println("M: "+ob.m);
        System.out.println("Add_M: "+ob.add_m);
        System.out.println("Sub_M: "+ob.sub_m);
        System.out.println("Count: "+ob.count);
        ob.loop();
        ob.print();
        sc.close();
    }
}