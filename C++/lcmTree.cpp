#include<bits/stdc++.h>
using namespace std;
const int N = 1e5+10;
vector<int> g[N];
int par[N];

void dfs(int vertex, int p)
{
	par[vertex] = p;
	for(int child : g[vertex]){
		if(child == p) continue;
		dfs(child,vertex);
	}
}
vector<int> path(int &node){
	vector<int> ans;
	while(node != 0){
		ans.push_back(node);
		node = par[node];
	}
	reverse(ans.begin(), ans.end());
	return ans;
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
	int v1,v2,len;
	cin >> v1 >> v2;
	vector<int> path1 = path(v1);
	vector<int> path2 = path(v2);
	len = min(path1.size(),path2.size());
	//cout << len << endl;

	/*for (int i = 0; i < path1.size(); ++i)
	{
		cout << path1[i] << " ";
	}

	for (int i = 0; i < path2.size(); ++i)
	{
		cout << path2[i] << " ";
	}*/

	int LCA = 0;
	for (int i = 0; i < len; ++i)
	{
		if(path2[i] == path1[i]){
			LCA = path1[i];
		}else{
			break;
		}
	}
	cout << LCA << endl;
}