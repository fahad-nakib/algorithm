import java.util.ArrayList;
import java.util.Scanner;

class findCycle{
    Scanner sc = new Scanner(System.in);
    int v ,e ;
    findCycle(){
        for (int i=0; i<=v; i++)
        {
            g[i] = new ArrayList<Integer>();
        }
    }
    {
        v = sc.nextInt(); e = sc.nextInt();
    }
    int N = (int) 1e5;

    ArrayList<Integer> g[] = new ArrayList[N];
    boolean[] visited = new boolean[N];
    public void addEdge(){

        for (int i=0; i<e; i++)
        {
            int x,y;
            x = sc.nextInt(); y = sc.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
    }
    public boolean dfs(int vertex, int par){
        boolean isCycle = false;
        visited[vertex] = true;
        for (int child : g[vertex]) {
            if(visited[child] && child==par) continue;
            if (visited[child]) return true;
            isCycle = isCycle || dfs(child,vertex);
        }
        return isCycle;
    }
}

public class graphCycle {
    public static void main(String[] args) {
        findCycle f = new findCycle();
        f.addEdge();
        for (int i=1; i<=f.v; i++)
        {
            if (f.visited[i]) continue;
            if (f.dfs(i,0)){
                System.out.println("loop exist ");
                break;
            }
            else {
                System.out.println("not exist");
            }
        }


    }
}
/*
exist :
8 6
1 2
2 3
2 4
3 5
6 7
1 5

8 6
A B
B C
B D
C E
F G
A E

not exist :
8 5
1 2
2 3
2 4
3 5
6 7

8 5
A B
B C
B D
C E
F G
A
 */