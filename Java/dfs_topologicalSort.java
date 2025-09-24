import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class dfs_topologicalSort {
    static ArrayList<Integer>[]list;
    static Stack<Integer> stack = new Stack<>();
    static boolean []visited;
    static int []parent;
    static int c=0;
    static void dfs(int src)
    {
        visited[src] = true;
        for (int child : list[src]) {
            if (visited[child]) continue;
            dfs(child);
        }
        stack.push(src);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter no of Vertex and edge : ");
        int vertex, edge;
       // System.out.println("Enter the number of vertex : ");
        vertex = sc.nextInt();
        //System.out.println("Enter the number of edges : ");
        edge = sc.nextInt();
        list = new ArrayList[vertex];
        visited = new boolean[vertex];
        parent = new int[vertex];
        for (int i=0; i< vertex; i++)
        {
            list[i] = new ArrayList<>();
        }
        //System.out.println("Enter adj list : ");
        for (int i=0; i<edge; i++)
        {
            int u,v;
            u = (int)sc.next().charAt(0)-65;
            v= (int)sc.next().charAt(0)-65;
            list[u].add(v);
        }
        for (int i=0; i<vertex; i++)
        {
            if (visited[i]) continue;
            dfs(i);
        }
        while (!stack.isEmpty())
        {
            int value = stack.pop();
            char ch = (char)(value+65);
            System.out.println(ch);
        }
    }
}
/*

5 6
A B
A D
B C
B D
D C
D E
ANS = A B D C E  OR  A B D E C


5 7
A B
A D
B C
B D
D C
D E
E B
ans : contain cycle
 */