#include<bits/stdc++.h>
using namespace std;
bool plindrom(string str){
	for (int i = 0; i < str.length()/2; ++i)
	{
		if (str[i] == str[str.length()-i-1])
		{
			//result = true;
		}else{
			//result = false;
			return 0;
		}
	}
	return 1;
}
main(){
	string str = "abcdcba";

	if (plindrom(str))
	{
		cout << "YES";
	}else{
		cout << "NO"; 
	}
}