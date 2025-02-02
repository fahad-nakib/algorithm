#include<bits/stdc++.h>
using namespace std;
const int N = 1e5+10;
vector<int> tree[N];
int hight[N],depth[N];
void dfs(int vertex , int par=0)
{
	for(int child : tree[vertex]){
		if(child == par) continue;
		depth[child] = depth[vertex] + 1;
		dfs(child,vertex);
		hight[vertex] = max(hight[vertex], hight[child]+1); 
	}
}
int main()
{
	int v;
	cin >> v;
	for (int i = 0; i < v-1; ++i)
	{
		int v1,v2;
		cin >> v1 >> v2;
		tree[v1].push_back(v2);
		tree[v2].push_back(v1);
	}
	dfs(1);

	for (int i = 1; i <= v; ++i)
	{
		cout << depth[i] << " " << hight[i] << endl;
	}
	return 0;

}