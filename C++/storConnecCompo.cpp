#include<bits/stdc++.h>
using namespace std;

const int N = 1e5+10;
vector<int> g[N];
vector<vector<int>> contd_compo;
vector<int> curnt_compo;
bool vis[N];

void dfs(int &vertex)
{
	curnt_compo.push_back(vertex);
	vis[vertex] = true;
	for(int &child : g[vertex]){
		i f (vis[child])
		{
			continue;
		}
		dfs(child);
	}
}

int main()
{
	int n,e,count = 0;
	cin >> n >> e;
	for (int i = 0; i < e; ++i)
	{
		int u,v;
		cin >> u >> v;
		g[u].push_back(v);
		g[v].push_back(u);
	}
	for (int i = 1; i <= n ; ++i)
	{
		if (vis[i])
		{
			continue;
		}else{
			curnt_compo.clear();
			dfs(i);
			contd_compo.push_back(curnt_compo);
			count++;
		}
		
	}
	cout << count << endl;

	// ** printing the stored connected component **


	for(auto &c_c : contd_compo){
		for(auto &c : c_c){
			cout << c << " ";
		}
		cout << endl;
	}

	// ** printing the stored connected component **

	/*for (int i = 0; i < count; ++i)
	{
		for (int j = 0; j < contd_compo[i].size(); ++j)
		{
			cout << contd_compo[i][j] << " " ;
		}
		cout << endl;
	}*/
	
	return 0;
}