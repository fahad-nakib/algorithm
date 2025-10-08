import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Indegree_topology {
    static ArrayList<Integer>[] list;
    static int[] inDegree; static int cur_count;
    static Queue<Integer> que;
    static Queue<Integer> ansQue;

    static int bfs(int src) {
        //System.out.println(src);
        int count = 0;
        que.add(src);
        inDegree[src] = -1;
        while (!que.isEmpty()) {
            int cur_value = que.poll();
            count++;
            ansQue.add(cur_value);
            for (int child : list[cur_value]) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    que.add(child);
                    inDegree[child] = -1;
                }
            }
        }
        return count;
    }
    static void run_bfs(int vertex)
    {
        for (int i = 0; i < vertex; i++) {
            if (inDegree[i] == 0) {
                cur_count += bfs(i);
            }
        }
        if (cur_count == vertex) {
            System.out.println("loop not exist..");
            while (!ansQue.isEmpty()) {
                int q = ansQue.poll();
                char ch = (char) (q + 65);
                System.out.print(ch + " --> ");
            }
        } else {
            System.out.println("loop exist..");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int vertex, edge;
        vertex = sc.nextInt();
        edge = sc.nextInt();
        list = new ArrayList[vertex];
        inDegree = new int[vertex];
        que = new LinkedList<>();
        ansQue = new LinkedList<>();
        for (int i = 0; i < vertex; i++) {
            inDegree[i] = 0;
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge; i++) {
            int u, v;
            u = (int) sc.next().charAt(0) - 65;
            v = (int) sc.next().charAt(0) - 65;
            list[u].add(v);
            
            inDegree[v]++;
        }
        int cur_count = 0;  // Keep track how many vertex has visited
        for (int i = 0; i < vertex; i++) {
            if (inDegree[i] == 0) {
                cur_count += bfs(i);
            }
        }
        if (cur_count == vertex) {
            System.out.println("loop not exist..");
            while (!ansQue.isEmpty()) {
                int q = ansQue.poll();
                char ch = (char) (q + 65);
                System.out.print(ch + " --> ");
            }
        } else {
            System.out.println("loop exist..");
        }
    }
}

/*
not exist in directed case :

8 6
A B
B C
B D
C E
F G
A E

exist in directed case  :

8 6
A B
B C
B D
C E
F G
E A

5 6
A B
A D
B C
B D
D C
D E
ANS = A B D C E  OR  A B D E C

 */