import java.util.*;
public class PrimeAlgorithm {
    static class edge{
        int u,v,wt;
        edge(int u, int v, int wt)
        {
            this.u = u; this.v = v; this.wt = wt;
        }
    }
    static ArrayList<edge> []list;
    static int VERTEX,no_of_mst;
    static boolean []visited;
    static ArrayList<PrimeAlgorithm.edge> que = new ArrayList<>();
    static ArrayList<Integer> visited_wt = new ArrayList<>();
    static void bfs(int src)
    {
        //int count =0;
        que.add(new PrimeAlgorithm.edge(src,src,0));
        while (!que.isEmpty())
        {
            que.sort(Comparator.comparing(o -> o.wt ));
            PrimeAlgorithm.edge cur_edge = que.remove(0);

            int cur_u = cur_edge.u;  int cur_value = cur_edge.v;  int cur_wt = cur_edge.wt;
            if (visited[cur_value])continue;
            visited[cur_value] = true;
            //______________________________________________________________________
            char ch_cur_value, ch_cur_u;                           // Print MST edge
            ch_cur_u = (char)(cur_u + 65);
            ch_cur_value = (char)(cur_value + 65);
            //System.out.println(ch_cur_u + " -> "+ch_cur_value+ " : " + cur_wt);
            //------------------------------------------------------------------------
            //count++;
            for (PrimeAlgorithm.edge Edge: list[cur_value])
            {
                int u = Edge.u;int v = Edge.v; int w = Edge.wt;
                if (visited[v]) continue;
                visited_wt.add(w);
                que.add(new PrimeAlgorithm.edge(u,v,w));
                //if (count == VERTEX) return;
            }
            Collections.sort(visited_wt);
            if (!visited_wt.isEmpty()){
                int st = visited_wt.get(0);
                for (int i : visited_wt) {
                    if (st == i)
                    {
                        no_of_mst++;
                    }
                }
                visited_wt.clear();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertex and edges : ");
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        VERTEX = vertex;
        list = new ArrayList[vertex];
        visited = new boolean[vertex];
        for (int i=0; i<vertex; i++)
        {
            list[i] = new ArrayList<>();
        }
        System.out.println("Enter edges : ");
        for (int i=0; i<edge; i++)
        {
            int U,V,W;
            U = (int)sc.next().charAt(0) - 65;
            V = (int)sc.next().charAt(0) - 65;
            W = sc.nextInt();
            list[U].add(new PrimeAlgorithm.edge(U,V,W));
            list[V].add(new PrimeAlgorithm.edge(V,U,W));
        }
        System.out.println("Enter source node : ");
        int src = (int) sc.next().charAt(0)- 65;
        bfs(src);
        System.out.println("Number of distinct MST : "+no_of_mst);
    }
}

/*

5 8
A B 9
A C 5
A D 2
B D 6
B E 5
C D 4
C E 5
D E 4
A

Output :
A -> A : 0
A -> D : 2
D -> C : 4
D -> E : 4
E -> B : 5


INPUT....
5 6
A C 3
C B 10
C E 6
C D 2
B D 4
E D 1
B

OUTPUT...
10 = 4+2+1+3



5 6
5 6
A B 2
A C 1
A D 1
B D 1
C E 2
D E 2
A

5 6
A B 1
A C 1
A D 1
B D 1
C E 1
D E 1
A

3 3
A B 1
A C 1
B C 1
A


6 8
A B 4
A C 4
B C 2
C E 2
C D 3
C F 4
D F 3
E F 3
 */