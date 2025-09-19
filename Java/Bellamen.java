import java.util.ArrayList;
import java.util.Scanner;
class BelamenList{
    int x,y,wt;
    BelamenList(int x, int y, int wt)
    {
        this.x = x;
        this.y = y;
        this.wt = wt;
    }
}
public class Bellamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BelamenList> blList = new ArrayList<>();

        int v, e;
        v = sc.nextInt();
        e = sc.nextInt();

        // Taking Edge Input
        for (int i = 0; i < e; i++) {
            int x, y, wt;
            x = sc.nextInt();
            y = sc.nextInt();
            wt = sc.nextInt();
            blList.add(new BelamenList(x, y, wt));
        }



        int[] cost = new int[v + 1];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i <= v; i++) {
            cost[i] = INF;
        }
        cost[1] = 0;
        // Main Operation
        for (int i = 1; i < v ; i++) {
            boolean change = false;
            for (BelamenList blElement : blList) {
                int x = blElement.x;
                int y = blElement.y;
                int Wt = blElement.wt;
                if (cost[y] > cost[x]+Wt)
                {
                    cost[y] = cost[x] + Wt;
                    change = true;
                }
            }
            if (!change) {
                break;
            }else {
                change = false;
            }
        }


        // Printing Array list
            for (BelamenList blElement : blList) {
                int x = blElement.x;
                int y = blElement.y;
                int Wt = blElement.wt;
                if (cost[y] > cost[x]+Wt)
                {
                    System.out.println("Graph contain negative edge cycle !!");
                    return;
                }
            }
        for (BelamenList blElement : blList) {
            int x = blElement.x;
            int y = blElement.y;
            //int Wt = blElement.wt;
                System.out.println(x + " " + y + " " + cost[y]);
        }
         for (int i = 1; i < v+1; i++) {
             System.out.println(i + " -> " +cost[i]);
         }
    }
}
/*
Input ....
6 9
1 2 6
1 3 4
1 4 5
2 5 -1
3 2 -2
3 5 3
4 3 -2
4 6 -1
5 6 3

out put ...
1 -> 0
2 -> 1
3 -> 3
4 -> 5
5 -> 0
6 -> 3


Input ....

4 5
1 2 4
1 3 5
2 4 7
3 2 7
4 3 -15

Out put ....
 -> Negative edged cycle exist !!

 */