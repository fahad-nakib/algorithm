import java.util.ArrayList;
import java.util.Scanner;
class Graph{
    Scanner sc = new Scanner(System.in);
    int N;
    ArrayList<Integer> g[];

    boolean[] visited = new boolean[N+1];
    Graph(int N){
        this.N = N;
        g = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i=0; i<N+1 ; i++)
        {
            g[i] = new ArrayList<Integer>();
        }
    }
    public void addEdge(int x, int y)
    {
            g[x].add(y);
            g[y].add(x);
    }
    public  void dfs(int vertex){
        visited[vertex] = true;
        System.out.println(vertex);
        for (int child : g[vertex]) {
            System.out.println("parant : "+vertex+", child : "+child);
            if(visited[child] == true) continue;
            dfs(child);
        }
    }
   /* public void printGraph(int i){
        Iterator<Integer> it = g[i].listIterator();
        while (it.hasNext()){
            System.out.println(it.next() + " ");
        }
        i++;
        printGraph(i);
    }*/
}
public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int N = sc.nextInt();
        Graph G = new Graph(e);
        for (int i = 0; i < N; i++){
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            G.addEdge(x,y);
        }
        G.dfs(1);

    }
}
/*
input...
6 9
1 3
1 5
3 5
3 6
3 4
3 2
2 6
4 6
5 6
 */
