import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Lab4Kruskal {
    static class edge
    {
        int u, v, wt;
        edge(int u, int v, int wt)
        {
            this.u = u; this.v = v; this.wt = wt;
        }
    }
    static  int[] parent;
    static void  make(int vertex)
    {
        parent[vertex] = vertex;
    }
    static  int  find(int vertex)
    {
        if (parent[vertex] == vertex) return vertex;
        return parent[vertex] = find(parent[vertex]);
    }

    static void union(int a, int b)
    {
        a = find(a); b= find(b);
        if (a != b)
        {
            parent[b] = a;
        }
    }
    static  ArrayList<Lab4Kruskal.edge> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total_cost = 0;
        int vertex = sc.nextInt(); int edge = sc.nextInt();
        parent = new int[vertex];
        for (int i=0; i<vertex; make(i++));
        for (int i=0; i<edge ; i++)
        {
            int U, V , Wt;
            U = sc.nextInt(); V = sc.nextInt(); Wt = sc.nextInt();
            list.add(new edge(U,V,Wt));
        }
        list.sort(Comparator.comparing(o -> o.wt));
        int count = 0,prevWt = -1;
        for (Lab4Kruskal.edge Edge : list) {
            int wt = Edge.wt; int a = Edge.u; int b = Edge.v;
            if (count == 0 || prevWt == wt)
            {
                prevWt = wt;
                count++;
                continue;
            }
            else if (find(a) != find(b))
            {
                union(a,b);
                System.out.println(wt +" : " + a + " -> " + b);
                total_cost += wt;
            }
        }
        System.out.println("Second Best Minimum Cost Spanning Tree : "+ total_cost);
    }
}
//DistinctMST
/*
4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4

For mst
Output :
edge = 2->3,0->3, 0->1
cost = 19


for second bst mst :
Output :
5 : 0 -> 3
6 : 0 -> 2
10 : 0 -> 1
Cost : 21

 */
