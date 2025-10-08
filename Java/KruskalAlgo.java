import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
class Kruskal {
    static class Edge{
        int a,b,wt;
        Edge(int a, int b,int wt)
        {
            this.a = a;
            this.b = b;
            this.wt = wt;
        }
    }
    int v,e;  int[] parent;  int[] size;
    public Kruskal(int v, int e)
    {
        parent = new int[v+1]; size = new int[v+1];
        this.v = v; this.e = e;
        for (int i=1; i<=v; make(i++));
    }
    public void make(int vertex)
    {
        parent[vertex] = vertex;
        size[vertex] = 1;
    }
    public int find(int vertex)
    {
        if (parent[vertex] == vertex) return vertex;
        return parent[vertex] = find(parent[vertex]);
    }
    public void union(int a, int b)
    {
        a = find(a); b= find(b);
        if (a != b)
        {
            if (size[a] < size[b]){
                int temp = a;
                a = b ; b = temp;
            }
            parent[b] = a;
            size[a] += size[b];
        }
    }
}
public class KruskalAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Kruskal.Edge> list = new ArrayList<>();
        int v , e ;
        v = sc.nextInt(); e = sc.nextInt();
        Kruskal k = new Kruskal(v,e);
        for (int i =0 ; i< e; i++) {
            int wt, x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            wt = sc.nextInt();
            list.add(new Kruskal.Edge(x, y,wt));
        }
        list.sort(Comparator.comparing(o -> o.wt));
        for (Kruskal.Edge edges: list) {
            int wt = edges.wt; int a = edges.a; int b = edges.b;
            //System.out.println(wt + " " + a + " "+ b);
            if (k.find(a) != k.find(b)){
                k.union(a,b);
                System.out.println(wt +" : " + a + " -> " + b);
            }
        }
//        for (int i=1; i<=v; i++){
//            System.out.println(k.size[i]);
//        }
    }
}

/*
4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4
 */