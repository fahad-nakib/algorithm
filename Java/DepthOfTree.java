import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DepthOfTree {
    static ArrayList<Integer>[] list;
    static int[] height,depth,parent;
    static Queue<Integer> que = new LinkedList<>();
    static void bfs(int source)
    {
        depth[source] = 0; parent[source] = -1;
        que.add(source);
        while (!que.isEmpty())
        {
            int cur_value = que.poll();
            System.out.println(cur_value);
            for (int child : list[cur_value]) {
                if (child == parent[cur_value]) continue;
                parent[child] = cur_value;
                depth[child] = depth[cur_value]+1;
                que.add(child);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex,edge;
        vertex = sc.nextInt(); edge = sc.nextInt();
        list = new ArrayList[vertex];
        height = new int[vertex]; depth = new int[vertex]; parent = new int[vertex];
        for (int i=0; i<vertex; i++)
        {
            list[i] = new ArrayList<>();
        }
        for (int i=0; i<edge; i++)
        {
            int u = (int) sc.next().charAt(0)-65;
            int v = (int) sc.next().charAt(0)-65;
            list[u].add(v); list[v].add(u);
        }
        int source = (int) sc.next().charAt(0)-65;
        bfs(source);
        for (int i=0; i<vertex; i++)
        {
            System.out.print(depth[i]+" ");
        }
    }
}
/*

6 5
A B
A F
B C
B D
C E
A

*/