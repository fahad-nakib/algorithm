#include<bits/stdc++.h>
using namespace std;
const int N = 1e5;
int dp[N];

// (n)th index Fibonacci number using for loop....
int basic_fib(int n)
{
	int first = 0;
	int second = 1;
	int fib = 0;
	if(n == 0) return first;
	if(n == 1) return second;
	for (int i = 2; i <= n; ++i)
	{
		fib = first +second;
		first = second;
		second = fib;
	}
	return fib;
}

// (n)th index Fibonacci number using recurson....
int basic_fib2(int n)
{
	if(n==0) return 0;		// if(n == 0 || n == 1) return n;
	if(n==1) return 1;
	return basic_fib2(n-1) + basic_fib2(n-2);
}

// (n)th index Fibonacci number using dynamic programming....
int dynamic_fib(int n){
	if(n == 0 || n == 1) return n;
	if(dp[n] != -1) return dp[n];
	return dp[n] = dynamic_fib(n-1) + dynamic_fib(n-2);
}
int main()
{
	memset(dp,-1,sizeof(dp));
	int kase;
	cin >> kase;
	while(kase--)
	{
		int n; 
		cin >> n;
		cout << dynamic_fib(n) << " " ;
	}

}
/*
input ...
8
0 1 2 3 4 5 6 7

output...
0 1 1 2 3 5 8 13 

*/