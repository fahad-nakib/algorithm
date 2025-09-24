import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class DistinctMST {
    static class edge
    {
        int u, v, wt;
        edge(int u, int v, int wt)
        {
            this.u = u; this.v = v; this.wt = wt;
        }
    }
    static int total_cost = 0,vertex,no_of_mst = 0;
    static ArrayList<Integer> last_index = new ArrayList<>();
    static int last_inx = -1;
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
    static  ArrayList<DistinctMST.edge> list = new ArrayList<>();
    static  ArrayList<DistinctMST.edge> unvisited_edge = new ArrayList<>();
    static  ArrayList<DistinctMST.edge> temp_mst = new ArrayList<>();
    static void count_MST(){
        for (DistinctMST.edge Edge : list) {
            int inx = list.indexOf(Edge);
            if (last_index.contains(inx)) continue;
            int un_wt= Integer.MAX_VALUE,un_a= Integer.MAX_VALUE,un_b= Integer.MAX_VALUE;
            if (!unvisited_edge.isEmpty()){
                unvisited_edge.sort(Comparator.comparing(o -> o.wt));
                DistinctMST.edge un_v_edge = unvisited_edge.remove(0);
                un_wt = un_v_edge.wt; un_a = un_v_edge.u; un_b = un_v_edge.v;
            }
            int wt = Edge.wt; int a = Edge.u; int b = Edge.v;
            if (un_wt <= wt) {
                if (find(un_a) != find(un_b))
                {
                    union(a,b);
                    temp_mst.add(new edge(un_a,un_b,un_wt));
                    total_cost += wt;
                    last_inx = inx;
                }
            }else {
                if (find(a) != find(b))
                {
                    union(a,b);
                    temp_mst.add(new edge(a,b,wt));
                    total_cost += wt;
                    last_inx = inx;
                }else {
                    unvisited_edge.add(new edge(a,b,wt));
                }
            }
        }
        last_index.add(last_inx);
        if (temp_mst.size() == (vertex-1)){
            while (!temp_mst.isEmpty())
            {
                DistinctMST.edge Tedge = temp_mst.remove(0);
                System.out.println(Tedge.u + " -> "+ Tedge.v + " : "+ Tedge.wt);
            }
            System.out.println("Minimum Cost Spanning Tree : "+ total_cost);
            no_of_mst++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        vertex = sc.nextInt(); int edge = sc.nextInt();
        parent = new int[vertex];
        for (int i=0; i<edge ; i++)
        {
            int U, V , Wt;
            U = sc.nextInt(); V = sc.nextInt(); Wt = sc.nextInt();
            list.add(new edge(U,V,Wt));
           // list.add(new edge(V,U,Wt));
        }
        list.sort(Comparator.comparing(o -> o.wt));
        int count = edge - (vertex-1);
        for (int i=0; i<count; i++)
        {
            for (int j=0; j<vertex; make(j++));
            total_cost = 0;
            count_MST();
        }
        System.out.println();
        System.out.println( "number of mst distinct MST : "+no_of_mst);
    }
}
//DistinctMSTdx,,
/*
4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4

Output :
edge = 2->3,0->3, 0->1
cost = 19

5 7
0 1 1
0 2 1
1 3 1
1 4 1
2 3 1
2 4 1
3 4 1

5 7
0 1 2
0 2 1
0 3 1
1 3 1
2 4 2
3 2 1
3 4 2


 */
