#include<bits/stdc++.h>
using namespace std;
const int N = 1e5;
int a[N];

//			      .....MY PROCESS.....
// int func(int j,int n)
// {
// 	int ans = 1;
// 	for (int i = j ; i < n ; ++i)
// 	{
// 		if(a[i] > a[j]) ans = max(ans,func(i,n) + 1);
// 	}
// 	return ans;
// }

// Treditional Process.................
int lis(int j){
	int ans =1;
	for (int i = 0; i < j; ++i)
	{
		if(a[i] < a[j]) ans = max(ans,lis(i) + 1);
	}
	return ans;
}


int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n ; ++i)
	{
		int x; 
		cin >> x;
		a[i] = x;
	}
	int ans = 0;
	for (int i = 0; i < n; ++i)
	{
		//ans = max(ans,func(i,n));		// My Process.....
		ans = max(ans , lis(i));		// Treditional Process...
	}
	cout << ans;
}