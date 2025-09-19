import java.util.Scanner;

public class CoinChangeWays {
    public static int countWays(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coins;
        System.out.println("Enter number of coins : ");
        int n = sc.nextInt();
        coins = new int[n];
        System.out.println("Enter the coins : ");
        for (int i=0; i<n; i++ )
        {
            coins[i]= sc.nextInt();
        }
        System.out.println("Enter the amount : ");
        int amount = sc.nextInt();
        int ways = countWays(coins, amount);
        System.out.println("Number of ways to make change: " + ways);
    }
}
