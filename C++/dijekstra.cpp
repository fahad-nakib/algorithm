#include<bits/stdc++.h>
using namespace std;
const int N = 1e5;
const int inf = 1e9;
vector<pair<int,int>> g[N];
vector<int> dis(N,inf);

void bfs(int vertex)
{
	queue<int> q;
	q.push(vertex);
	dis[vertex] = 0;
	while(!q.empty()){
		int cur_value = q.front();
		q.pop();
		for(auto &ptr : g[cur_value]){
			int child_v = ptr.first;
			int child_wt = ptr.second;
			int distent = dis[cur_value] + child_wt ;
			q.push(child_v);
			if(distent < dis[child_v]){
				dis[child_v] = dis[cur_value] + child_wt;
				cout << cur_value << " -> " << child_v << endl;
			}
		}
	}
}

int main()
{
	int v,e;
	cin >> v >> e;
	for (int i = 0; i < e; ++i)
	{
		int x , y , w ;
		cin >> x >> y >> w ;
		g[x].push_back({y,w});
	}
	bfs(1);
	cout << "distance list : " << endl;
	for (int i = 1; i <= v; ++i)
	{
		cout << i << " -> "<< dis[i] << endl;
	}

}
/*
1. Input....
3 3
1 3 40
1 2 10
2 3 20
1. Output....
1 -> 0
2 -> 10
3 -> 30

2. Input....

6 9
1 2 1
1 3 5
2 3 2
2 4 2
2 5 1
3 5 2
4 5 3
4 6 1
5 6 2

2. Output...
1 -> 0
2 -> 1
3 -> 3
4 -> 3
5 -> 2
6 -> 4
*/