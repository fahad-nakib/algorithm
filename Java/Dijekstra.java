import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Dijekstra {
    static int []distance;
    static int edge;
    static int edge_count = 0;
    static ArrayList<Dijekstra.edge>[]list;
    static Queue<Integer> que = new LinkedList<>();
    static  class edge {
        int v, wt;
        edge(int v, int wt){
            this.v = v; this.wt = wt;
        }
    }
    static void  bfs(int src)
    {
        distance[src] = 0;
        que.add(src);
        while (!que.isEmpty() && edge_count <= edge)
        {
            int cur_value = que.poll();
            for (Dijekstra.edge Edge: list[cur_value]) {
                edge_count++;
                int v = Edge.v; int wt= Edge.wt;
                que.add(v);
                if(distance[v] > (distance[cur_value]+wt))
                {
                    distance[v] = distance[cur_value]+wt;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter no of vertex and edges : ");
        int vertex = sc.nextInt();
        edge = sc.nextInt();
        list = new ArrayList[vertex];
        distance = new int[vertex];
        for (int i=0; i<vertex; i++)
        {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        //System.out.println("Enter Edges : ");
        for (int i=0; i<edge; i++)
        {
            int U,V,W;
            U = (int)sc.next().charAt(0) - 65; //char ch = (char)(i + 65);
            V = (int)sc.next().charAt(0) - 65;
            W = sc.nextInt();
            list[U].add(new Dijekstra.edge(V,W));
        }
        //System.out.println("Enter source node : ");
        int src = (int)sc.next().charAt(0)-65;
        bfs(src);
        System.out.println("Distance from source : ");
        for (int i=0; i<list.length; i++)
        {
            char ch = (char)(i + 65);
            System.out.println(ch + "--> "+distance[i]);
        }
    }
}
/*
case 1 :
input
6 9
A B 4
A C 5
B C 11
B D 9
B E 7
C E 3
D E 13
D F 2
E F 6
A

Output:
A -> 0
B -> 4
C -> 5
D -> 13
E -> 8
F -> 14


CASE 2
Input:
6 9
A B 1
A C 5
B C 2
B D 2
B E 1
C E 2
D E 3
D F 1
E F 2
A

Output...
A -> 0
B -> 1
C -> 3
D -> 3
E -> 2
F -> 4



CASE 3
Input....
3 3
A C 40
A B 10
B C 20
A
Output....
A -> 0
B -> 10
C -> 30
 */