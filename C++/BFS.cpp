#include<bits/stdc++.h>
using namespace std;
const int N = 1e5+10;
vector<int> g[N];

bool vis[N];

void bfs(int vertex){
	queue<int> q;
	q.push(vertex);
	
	vis[vertex] = true;
	while(!q.empty()){
		int cur_value = q.front();
		cout << cur_value << " ";
		q.pop();
		for(int child : g[cur_value]){

			if(!vis[child]){
				q.push(child);
			    vis[child] = true;
			}
		}
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
	bfs(1);
	return 0;
}