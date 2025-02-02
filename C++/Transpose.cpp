#include<bits/stdc++.h>
using namespace std;

void transpose(int &v, vector<int> g[], vector<int> trans[])
{
	for (int i = 1; i <= v; ++i)
	{
		for(int & value : g[i]){
			trans[value].push_back(i);
		}
	}
}

void print_vec(vector<int> g[], int v)
{
	for (int i = 1; i <= v; ++i)
	{
		for(int & value : g[i]){
			cout << i << " -> " << value << endl;
		}
	}
}

int main()
{
	int v,e;
	cin >> v >> e;
	vector<int> g[v+1];
	vector<int> trans[v+1];
	for (int i = 0; i < e; ++i)
	{
		int x,y;
		cin >> x >> y;
		g[x].push_back(y);
	}
	transpose(v,g,trans);
	print_vec(g,v);
	cout << endl;
	print_vec(trans,v);
}

/* 
Input ....

3 3
1 3
1 2
2 3

Output....
1 -> 3
1 -> 2
2 -> 3

2 -> 1
3 -> 1
3 -> 2
*/