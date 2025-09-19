import java.util.ArrayList;
import java.util.Scanner;

class c_component {
    Scanner sc = new Scanner(System.in);
    int v, e;
    c_component(){
        for (int i=0; i<=v; i++)
        {
            g[i] = new ArrayList<>();
        }
    }
    {
        v = sc.nextInt();e = sc.nextInt();
    }
    ArrayList<Integer> g[] = new ArrayList[e+10];
    boolean[] visited = new boolean[v+10];
    public void dfs(int vertex)
    {
        visited[vertex] = true;
        for (int child : g[vertex]) {
            if (visited[child]) continue;
            dfs(child);
        }
    }
    public void addEdge(){
        for (int i= 0; i<e; i++)
        {
            int x,y;
            x = sc.nextInt(); y = sc.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
    }
}
public class connectedComponent {
    public static void main(String[] args) {
        c_component c = new c_component();
        int ct = 0;
        c.addEdge();
        for (int i=1; i<=c.v; i++)
        {
            if (c.visited[i]) continue;
            ct++;
            c.dfs(i);

        }
        System.out.println(ct);

    }
}
/*
8 6
1 2
2 3
2 4
3 5
6 7
1 5
 */
