import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class BFS {
    Scanner sc = new Scanner(System.in);
     ArrayList<Integer> g[];
    Queue<Integer> que = new LinkedList<>();
    boolean[] visited;
    int v, e;

    BFS(int v, int e) {
        this.v = v;
        this.e = e;
        g = new ArrayList[v + 1];
        visited = new boolean[v+1];
        for (int i = 0; i <= v; i++) {
            g[i] = new ArrayList<Integer>();
        }
    }

    public void bfsl(int vertex)
    {
        que.add(vertex);
        visited[vertex] = true;
        while (!que.isEmpty()){
            int cur = que.poll();
            System.out.println(cur);
            for (int value: g[cur]) {
                if (visited[value]) continue;
                que.add(value);
                visited[value] = true;
            }
        }
    }
    public void addEdge(int x, int y){
            g[x].add(y);
            g[y].add(x);
    }
}
public class BFSalgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v,e;
        v = sc.nextInt(); e = sc.nextInt();
        BFS b = new BFS(v,e);
        for (int i=0; i<e; i++)
        {
            int x,y;
            x = sc.nextInt(); y = sc.nextInt();
            b.addEdge(x,y);
        }

        b.bfsl(1);
       // b.print();
    }
}
