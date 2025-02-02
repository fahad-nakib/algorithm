#include<bits/stdc++.h>
using namespace std;
const int N = 1e5;
vector<int> g[N];
vector<int> trans[N];

void print_vec(int v){
	for (int i = 1; i <= v; ++i)
	{
		for(int value : g[i]){
			cout << i << " -> " << value << endl;
		}
	}
}
void print_vec2(int v){
	for (int i = 1; i <= v; ++i)
	{
		for(int value : trans[i]){
			cout << i << " -> " << value << endl;
		}
	}
}
void transpose(int v)
{
	for (int i = 1; i <= v; ++i)
	{
		for(int value : g[i]){
			trans[value].push_back(i);
		}
	}
}

int main()
{
	int v,e;
	cin >> v >> e;
	for (int i = 0; i < e; ++i)
	{
		int x,y;
		cin >> x >> y;
		g[x].push_back(y);
	}
	transpose(v);
	print_vec(v);
	cout << endl ;
	print_vec2(v);
}

/* 
Input ....

4 5
1 3
2 1
3 2
3 4
2 4

Output....
1 -> 3
2 -> 1
2 -> 4
3 -> 2
3 -> 4

1 -> 2
2 -> 3
3 -> 1
4 -> 2
4 -> 3
*/