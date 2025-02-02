#include<bits/stdc++.h>
using namespace std;
const int N = 1e5;
int h[N];
int dp[N];
int func(int i)
{
	if(i == 0) return 0;
	if(dp[i] != -1) return dp[i];
	int cost;
	//cost = min(cost,func(i-1) + abs(h[i] - h[i-1]));

	// way 1 
	cost = func(i-1) + abs(h[i] - h[i-1]);

	// way 2
	if(i>1)
	cost = min(cost,func(i-2) + abs(h[i] - h[i-2]));
	return dp[i] = cost;
}
int main()
{
	memset(dp,-1,sizeof(dp));
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		cin >> h[i];
	}
	//cout << n ;
	cout << func(n-1);
	return 0;
}