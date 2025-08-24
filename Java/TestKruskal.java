import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class testy{
//    int a,b,c;
//    public test(int a, int b, int c)
//    {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//    }
    public void make(int vertex, int parent[], int size[]){
        parent[vertex] = vertex;
        size[vertex] = 1;
    }
    public int find(int vertex,int parent[])
    {
        if (parent[vertex] == vertex) return vertex;
        return parent[vertex] = find(parent[vertex],parent);
    }
    public void union(int a, int b, int parent[],int size[])
    {
        a = find(a,parent); b = find(b,parent);
        if(a != b){
           if (size[a] < size[b]) {
               int temp = a;
               a=b;b=temp;
           }
           parent[b] = a;
           size[a] += size[b];
            //System.out.println(size[a]);
        }
    }
}
class makeList{
    int a, b, wt;
    makeList(int a, int b, int wt)
    {
        this.a = a;
        this.b = b;
        this.wt = wt;
    }
}

public class TestKruskal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<makeList> allList = new ArrayList<>();
        testy ts = new testy();
        int v, e;
        v = sc.nextInt(); e = sc.nextInt();
        int parent[] = new int[v+1];
        int size[] = new int[v+1];
        for (int i =1; i<=v; i++)
        {
            ts.make(i,parent,size);
        }
        for (int i =1; i<=e; i++)
        {
            int x, y, wt ;
            wt = sc.nextInt();x = sc.nextInt(); y = sc.nextInt();
            allList.add(new makeList(x,y,wt));
        }
        Collections.sort(allList, new Comparator<makeList>() {
            @Override
            public int compare(makeList o1, makeList o2) {
                return Integer.valueOf(o1.wt).compareTo(o2.wt);
            }
        });

        for (makeList makeList : allList)
        {
            int a = makeList.a;
            int b = makeList.b;
            int wt = makeList.wt;
            if (ts.find(a,parent)== ts.find(b,parent)) continue;
            ts.union(a,b,parent,size);
            System.out.println(wt + " : "+a + " -> "+ b);
        }
    }
}
