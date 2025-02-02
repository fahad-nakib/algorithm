#include<bits/stdc++.h>
using namespace std;
const int N = 1e5;
vector<int> g[N];
int parent[N];
int size[N];

void make(int vertex){
	parent[vertex] = vertex;
	size[vertex] = 1;
}

int find(int vertex){
	if(vertex == parent[vertex]) return vertex;
	find(parent[vertex]);
}

void Union(int x, int y)
{
	int a = find(x); int b = find(y);
	if(a != b){
		if(size[a] < size[b]) swap(a,b);
		parent[b] = a;
		size[a] += size[b];
	}
}
int main()
{
	int v,e;
	cin >> v >> e; 
	for (int i = 0; i < v; ++i)
	{
		int vertex;
		cin >> vertex;
		make(vertex);
	}
	for (int i = 0; i < e; ++i)
	{
		int x,y;
		cin >> x >> y;
		Union(x,y);
	}

	int k;
	cin >> k;
	while(k--)
	{
		int par;
		cin >> par;
		cout << "root of "<< par << " : " << find(par) << endl;
	}
	cout << "size of : " << size[1] << endl;
	cout << "size of : " << size[3] << endl;
	cout << "size of : " << size[7] << endl;
	for (int i = 1; i <= v; ++i)
	{
		cout << "parent of " << i << ": " << parent[i] << endl;
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

Out put ...

1
1
1
1
5
5
7
7

*/