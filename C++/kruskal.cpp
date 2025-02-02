#include<bits/stdc++.h>
using namespace std;
const int N = 1e5+10;
int parent[N], size[N];

void make(int v)
{
	parent[v] = v;
	size[v] = 1;
}

int find(int v){
	if(parent[v] == v ) return v;
	return parent[v] = find(parent[v]);
}

void Union(int a, int b)
{
	a = find(a);
	b = find(b);
	if(a != b)
	{
		if(size[b] > size[a]) swap(a,b);
		parent[b] = a;
		size[a] += size[b]; 
	}
}
int main()
{
	vector<pair<int,pair<int,int>>> edge;
	int v,e;
	cin >> v >> e;
	for (int i = 1; i <= v; ++i)
	{
		make(i);
	}
	for (int i = 0; i < e; ++i)
	{
		int x,y,wt;
		cin >> wt >> x >> y;
		edge.push_back({wt,{x,y}});
	}
	sort(edge.begin(),edge.end());
	for(auto &edg : edge)
	{
		int wt = edg.first;
		int u = edg.second.first;
		int v = edg.second.second;
		if(find(u) == find(v)) continue;
		cout << wt << " : "<< u << " -> " << v << endl;
		Union(u,v);
	}
}

/* 
Input ....

v,e
wt,u,v

6 9
1 1 2
5 1 3
2 2 3
2 2 4
1 2 5
2 3 5
3 4 5
1 4 6
2 5 6

Output ....
1 -> 2
2 -> 5
4 -> 6
2 -> 3
2 -> 4

*/