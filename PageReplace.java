import java.util.*;
public class PageReplace
{
    int size;
    int[] cache,page,priority;
    PageReplace(int size,int cache[],int page[])
    {
        this.size=size;
        this.cache=cache;
        this.page=page;
        priority=new int[size];
        for(int i=0;i<size;i++)
        priority[i]=-1;
    }
    boolean checkHit(int a)
    {
        int flag=0;
        for(int i=0;i<size;i++)
        {
            if(cache[i]==a)
            {
                flag=1;
                break;
            }
        }
        return flag==1?true:false;
    }

    void loop()
    {
        for(int i=0;i<page.length;i++)
        {
            if(checkHit(page[i]))
            {
                hitPriority(i);
                print("hit");
            }
            else
            {
                insert(page[i]);
                missPriority();
                print("miss");
            }
        }
    }

    void insert(int a)
    {

    }

    void hitPriority(int i)
    {
        int pri=priority[i];
        for(int j=0;j<size;j++)
        {
            if(priority[i]>pri && cache[i]>-1)
            priority[i]--;
        }
        priority[i]=size;
    }

    void missPriority(int i)
    {
        int j=0;
        if(isFull())
        {
            
        }
        else
        {
            do
            {
                if(cache[j]==-1)
                cache[j]=page[i];
            }while(j++<size);
        }
    }

    boolean isFull()
    {
        int flag=0;
        for(int i=0;i<cache.length;i++)
        if(cache[i]<0)
        flag++;
        if(flag==0)
        return true;
        else
        return false;
    }
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int size,n;
        System.out.print("Enter size of cache: ");
        size=sc.nextInt();
        int cache[]=new int[size];
        for(int i=0;i<cache.length;i++)
        cache[i]=-1;
        System.out.println("Enter no. of pages: ");
        n=sc.nextInt();
        int page[]=new int[n];
        for(int i=0;i<n;i++)
        page[i]=sc.nextInt();

        PageReplace ob=new PageReplace(size,cache,page);
        ob.loop();




        
        sc.close();
    }
}
