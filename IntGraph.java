import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
class IntGraph
{
	private LinkedList<Integer> adjList[];
	private boolean visited1[];
	private boolean visited2[];
	int[] s_t,e_t,l;
	int time=0,vertices,level=0,flag=0;
	Stack<Integer> d=new Stack<>();
	Queue<Integer> b=new LinkedList<>();

	// Constructor
	IntGraph(int vertices)
	{
		adjList=new LinkedList[vertices];
		visited1=new boolean[vertices];
		visited2=new boolean[vertices];
		s_t=new int[vertices];
		e_t=new int[vertices];
		l=new int[vertices];
		this.vertices=vertices;
		for(int i=0;i<vertices;i++)
			adjList[i]=new LinkedList<Integer>();
	}

	// Add an adge
	void addEdge(int a,int b)
	{
		adjList[a].add(b);
	}

	// Print edges
	void dispEdges()
	{
        for (int i=0;i<vertices;i++)
        {
            System.out.print(i+" --> ");
            for (int loop:adjList[i])
            {
                System.out.print(loop+"->");
            }
            System.out.print("null\n");
        }
    }

    // Print Start time and End time
    void StEt()
    {
        System.out.println("Vertice\tS_t\tE_t");
        for (int i = 0; i < vertices; i++)
        {
            System.out.println(i + "\t\t" + s_t[i] + "\t" + e_t[i]);
        }
    }

    // Print DFS
    void printDFS(int vertex)
    {
        System.out.print("DFS: ");
        d.push(vertex);
        System.out.print(vertex+" ");
        visited1[vertex]=true;
        time++;
        s_t[vertex]=time;
        Iterator<Integer> t=adjList[vertex].listIterator();
        while (!d.empty())
        {
            if (t.hasNext())
            {
                int n = t.next();
                if (!visited1[n])
                {
                    d.push(n);
                    visited1[n] = true;
                    System.out.print(n + " ");
                    time++;
                    s_t[n]=time;
                    t=adjList[n].listIterator();
                }
                else if(t.hasNext())
                {
                    continue;
                }
            }
            else if(!t.hasNext())
            {
                int p=d.peek();
                int flag=0;
                t=adjList[p].listIterator();
                Iterator<Integer> temp=adjList[p].listIterator();
                while (temp.hasNext())
                {
                    int m = temp.next();
                    if (!visited1[m])
                    {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                {
                    time++;
                    d.pop();
                    e_t[p] = time;
                }
            }

        }
        System.out.println("\n");
    }


    // Print BFS
    void printBFS(int vertex)
    {
        System.out.print("BFS: ");
        System.out.print(vertex + " ");
        b.add(vertex);
        visited2[vertex] = true;
        for (int i = 0; i < vertex; i++)
        {
            visited2[vertex] = false;
        }
        while (!b.isEmpty())
        {
            Iterator<Integer> t = adjList[b.peek()].listIterator();
            level = l[b.peek()] + 1;
            b.remove();
            while (t.hasNext())
            {
                int n = t.next();
                if (!visited2[n])
                {
                    System.out.print(n + " ");
                    b.add(n);
                    visited2[n] = true;
                    l[n] = level;
                }
            }
        }
    }

    // Print vertice levels
    void printlevels()
    {
        System.out.println("Vertice\tlevel");
        for (int i = 0; i < vertices; i++)
        {
            System.out.println(i + "\t\t" + l[i]);
        }
    }

    // Driver code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of vertices: ");
        int vertices = sc.nextInt();
        IntGraph g = new IntGraph(vertices);
        System.out.print("Enter 1 to add edge and 2 to exit:");
        int ch = sc.nextInt();
        while (ch != 2) {
            System.out.println("\nEnter v and w");
            int v = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(v, w);
            System.out.print("\n Next choice=");
            ch = sc.nextInt();
        }
        System.out.println("\n");
        g.dispEdges();
        System.out.println("\n");
        g.printDFS(0);
        System.out.println("\n");
        g.StEt();
        System.out.println("\n");
        g.printBFS(0);
        System.out.println("\n");
        g.printlevels();
    }
}