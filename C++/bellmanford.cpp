#include<bits/stdc++.h>
using namespace std;
const int N = 1e5;
const int inf = 1e9;
vector<pair<int,int>> g[N];
vector<int> dis(N,inf);

bool bellmanFord(int source ,int v, int e)
{
	bool change = false, ans = false;
	dis[source] = 0;
	for (int i = 0; i < v; ++i)
	{
		for (int i = 1; i <=v; ++i)
		{
			for(auto &ptr : g[i]){
				int x = i;
				int y = ptr.first;
				int wt = ptr.second;
				int distent = dis[x] + wt;
				if(distent < dis[y]){
					dis[y] = distent;
					change = true;
				}
			}
		}
		if(!change) break;
		change = false; 
	}
	ans = true;
	for (int i = 1; i <=v; ++i)
	{
		for(auto &ptr : g[i]){
			int x = i;
			int y = ptr.first;
			int wt = ptr.second;
			int distent = dis[x] + wt;
			if(distent < dis[y]){
				ans = false;
			}
		}
	}
return ans;
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

	bellmanFord(1,v,e);
	if(bellmanFord(1,v,e)){
		cout << "distance list : " << endl;
		for (int i = 1; i <= v; ++i)
		{
			cout << i << " -> "<< dis[i] << endl;
		}
	}else{
		cout << "Negative edged cycle exist !!" << endl;
	}

	
}
/*
Input .....

6 9
1 2 6
1 3 4
1 4 5
2 5 -1
3 2 -2
3 5 3
4 3 -2
4 6 -1
5 6 3

Output...
1 -> 0
2 -> 1
3 -> 3
4 -> 5
5 -> 0
6 -> 3

Input...

4 5
1 2 4
1 3 5
2 4 7
3 2 7
4 3 -15

Output...
 -> Negative edged cycle exist !!
*/