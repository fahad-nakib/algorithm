#include<bits/stdc++.h>
using namespace std;
const int N = 1e5;
int h[N];
int dp[N];
int k;
int func(int i){
	if(i==0) return 0;
	if(dp[i] != -1) return dp[i];
	int cost = INT_MAX;
	for (int j = 1; j <= k; ++j)
	{
		if(i-j >= 0)
		cost = min(cost , func(i-j) + abs(h[i] - h[i-j])); 
	}
	return dp[i] = cost;
}
int main()
{
	int n;
	memset(dp,-1,sizeof(dp));
	cin >> n >> k;
	//cout << n << k;
	for (int i = 0; i < n; ++i)
	{
		cin >> h[i];
	}
	cout << func(n-1);
	//return 0;

}