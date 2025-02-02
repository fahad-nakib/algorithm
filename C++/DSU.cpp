#include<bits/stdc++.h>
using namespace std;
const int N = 1e5;
int parent[N];

void make(int v)
{
	parent[v] = v;
}

int find(int v)
{
	if(v == parent[v]) return v;
	return find(parent[v]);
}

void Union(int x , int y)
{
	int a = find(x);
	int b = find(y);
	if(a != b){
		parent[y] = x;
	}
}
int main()
{
	int v,e;
	cin >> v >> e;
	for (int i = 0; i < v; ++i)
	{
		int x;
		cin >> x;
		make(x);
	}
	for (int i = 0; i < e; ++i)
	{
		int x,y;
		cin >> x >> y;
		Union(x,y);
	}

	int k;
	cin >> k;
	for (int i = 1; i <= k; ++i)
	{
		cout <<"root "<< i << " : "<<  find(i) << endl ;
	}
	for (int i = 1; i <= k; ++i)
	{
		cout <<"parent "<< i << " : "<<  parent[i] << endl ;
	}
}

/*
Input....

8 5
1 2 3 4 5 6 7 8
1 2
1 3
2 4
5 6
7 8
8
1
2
3
4
5
6
7
8

Out put ... it's variable ( not exact !! )

1
1
1
1
5
5
7
7

*/