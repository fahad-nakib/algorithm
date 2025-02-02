#include<bits/stdc++.h>
using namespace std;
const int N = 1e5+10;
vector<int> g[N];
int sb_tr_sum[N], st_evn_cnt[N];

void dfs(int vertex , int par)
{
	for(int child : g[vertex])
	{
		if(child == par) continue;
		
		dfs(child, vertex);
		sb_tr_sum[vertex] += sb_tr_sum[child];
		st_evn_cnt[vertex] += st_evn_cnt[child];
	}
	sb_tr_sum[vertex] += vertex;
	if(vertex % 2 == 0) st_evn_cnt[vertex]++;
}
int main()
{
	int v;
	cin >> v;
	for (int i = 0; i < v-1; ++i)
	{
		int x,y;
		cin >> x >> y;
		g[x].push_back(y);
		g[y].push_back(x);
	}
	dfs(1,0);
	for (int i = 1; i <= v; ++i)
	{
		cout << sb_tr_sum[i] << " " << st_evn_cnt[i] << endl;
	}
	return 0;
}