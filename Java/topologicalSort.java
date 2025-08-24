import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class topologicalSort {
    static ArrayList<Integer>[]list;
    static Stack<Integer> stack = new Stack<>();
    static boolean []visited;
    static int []parent;
    static int c=0;
    static void dfs(int src)
    {
        visited[src] = true;
        if (list[src] == null) return;
        for (int child : list[src]) {
            parent[child] = src;
            if (child == parent[src]) continue;
            if (visited[child]){
                c++;
                System.out.println("back edge : "+ src + " --> " + child);
                continue;
            }
            System.out.println("Tree edge : "+ src+" --> "+ child);
            dfs(child);
        }
        stack.add(src);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter no of Vertex and edge : ");
        int vertex, edge;
        System.out.println("Enter the number of vertex : ");
        vertex = sc.nextInt();
        System.out.println("Enter the number of edges : ");
        edge = sc.nextInt();
        list = new ArrayList[vertex];
        visited = new boolean[vertex];
        parent = new int[vertex];
        for (int i=0; i< vertex; i++)
        {
            list[i] = new ArrayList<>();
        }
        System.out.println("Enter adj list : ");
        for (int i=0; i<edge; i++)
        {
            int u,v;
            u = (int)sc.next().charAt(0)-65;
            v= (int)sc.next().charAt(0)-65;
            list[u].add(v); list[v].add(u);
        }
        for (int i=0; i<vertex; i++)
        {
            if (visited[i]) continue;
            dfs(i);
        }
        if (c != 0)
        {
            System.out.println("Cycle Exist !!");
            System.out.println("Topological sort not possible..");
        }else {
            System.out.println("Topological Order : ");
            while (!stack.isEmpty())
            {
                int sk = stack.pop();
                char ch = (char)(sk+65);
                System.out.print(ch+" ");
            }
        }
    }
}

/*
/home/student_user/IdeaProjects/Mahady HAsan Fahim/src
5 7
0 1
0 2
0 3
1 2
1 3
2 4
3 4

8 5
A B
B C
B D
C E
F G

A B
B C
B D
C E
F G
E A

1 2
2 3
2 4
3 5
6 7

5 6
A B
A D
B C
B D
D C
D E
ANS = A B D C E  OR  A B D E C

 */