#include<bits/stdc++.h>
using namespace std;
const int N = 1e5+10;

vector<int> g[N];
bool vis[N];
int no_path = 0;

void dfs(int vertex, int dest)
{
	if(vertex == dest){
		no_path++;
		return;
	}
	vis[vertex] = true;
	for(int child : g[vertex]){
		if (vis[child]){
			continue;
		}
		dfs(child,dest);
	}
	vis[vertex] = false;
}

int main()
{
	int n,m;
	cin >> n >> m;
	for (int i = 0; i < m; ++i)
	{
		int v1,v2;
		cin >> v1 >> v2;
		g[v1].push_back(v2);
		g[v2].push_back(v1);
	}
	int u,v;
	cin >> u >> v;
	dfs(u,v);
	cout << "no_path : " << no_path << endl;
}
/*
8 10
0 1
1 2
1 3
2 4
2 5
3 5
3 7
4 6
5 6
7 6
0 6
*/