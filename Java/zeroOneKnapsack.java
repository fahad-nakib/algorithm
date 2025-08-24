import java.util.Scanner;

public class zeroOneKnapsack {
    static int[] value;
    static int[] wt;
    static int[] prev;

    static int maxProfit(int index, int cur_size)
    {
        if (index < 0) return 0;
        int ans =  maxProfit(index-1, cur_size);
        if (cur_size - wt[index] >= 0 )
        {
            int prev_ans = ans;
            ans = Math.max(ans,maxProfit(index-1,cur_size - wt[index])+value[index]);
            if(prev_ans<ans)
            {
                prev[index-1]=index;
            }
        }
      return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total_item = sc.nextInt();
        value = new int[total_item];
        wt = new int[total_item];
        prev = new int[total_item];

        int size = sc.nextInt();

        for (int i=0; i< total_item; i++)
        {
            wt[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        prev[total_item-1] = -1;
       int ans =  maxProfit(total_item-1,size);
        System.out.println(ans);
        for (int i=0; i<prev.length;i++)
        {
            System.out.println(prev[i]);
        }
    }
}
/*
3 8
3 30
4 50
5 60
 */