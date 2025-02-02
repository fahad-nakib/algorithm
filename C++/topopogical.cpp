#include<bits/stdc++.h>
using namespace std;
const int N = 1e5;
vector<int> g[N];
bool vis[N];
stack<int> sk;
void dfs(int vertex)
{
	vis[vertex] = true;
	for(int child : g[vertex])
	{
		if(vis[child]) continue;
		dfs(child);
	}
	sk.push(vertex);
}

int main()
{
	int v,e;
	cin >> v >> e;
	for (int i = 0; i < e; ++i)
	{
		int x,y;
		cin >> x >> y;
		g[x].push_back(y);
	}
	for (int i = 1; i <= v; ++i)
	{
		if(vis[i]) continue;
		dfs(i);
	}
	cout << "size :" << sk.size() << endl;
	for (int i = 0; i < 5; ++i)
	{
		int top = sk.top();
		cout << top << endl ;
		sk.pop();
	}
}

