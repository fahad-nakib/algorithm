#include <bits/stdc++.h>
using namespace std;
const int N = 1e5+10;
vector<int> g[N];
int depth[N];

void dfs(int vertex, int par){

	for(int child : g[vertex])
	{
		if(child == par) continue;
		depth[child] = depth[vertex] + 1;
		dfs(child,vertex);
	}
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
	int mx_depth =0;
	int mx_d_node;
	for (int i = 0; i < v; ++i)
	{
		if(mx_depth < depth[i]){
			mx_depth = depth[i];
			mx_d_node = i;
		}
		depth[i] = 0;
	}
	dfs(mx_d_node,0);
	for (int i = 0; i < v; ++i)
	{
		if(mx_depth < depth[i]){
			mx_depth = depth[i];
		}
	}
	cout << mx_depth << endl;
	return 0;
}