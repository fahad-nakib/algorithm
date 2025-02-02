#include <bits/stdc++.h>
using namespace std;
void dfs(int i,int j,int initialColor,int newColor,vector<vector<int>> &image)
{
	int row = image.size();
	int col = image[0].size();
	if(i<0 || j<0) return;
	if(i>=row || j>=col) return;
	if(image[i][j] != initialColor) return;

	image[i][j] = newColor;

	dfs(i-1,j,initialColor,newColor,image);
	dfs(i+1,j,initialColor,newColor,image);
	dfs(i,j-1,initialColor,newColor,image);
	dfs(i,j+1,initialColor,newColor,image);
}
vector<vector<int>> floodFill (int sr,int sc, int newColor, vector<vector<int>> & image){
	int initialColor = image[sr][sc];
	if(initialColor != newColor){	
	dfs(sr,sc,initialColor,newColor,image);
	}
	return image;
}

int main()
{
	vector<vector<int>> image;
	int row,col;
	cin >> row >> col;
	for (int i = 0; i < row; ++i)
	{
		vector<int> temp;
		for(int j=0; j< col; ++j){
			int x ;
			cin >> x;
			temp.push_back(x);
		}
		image.push_back(temp);
		temp.clear();
	}
	int sr,sc,newColor;
	cin >> sr >> sc >> newColor;
	floodFill(sr,sc,newColor,image);

	for (int i = 0; i < image.size(); ++i)
	{
		for (int j = 0; j < image[0].size(); ++j)
		{
			cout << image[i][j] << " ";
		}
		cout << endl;
	}
	return 0;
}