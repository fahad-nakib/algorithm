#include<bits/stdc++.h>
using namespace std;

string stuffing(string data,int consecutive)
{
	string stuffedData = "";
	int dataConsecutive = 0;
    for (int i=0; i<data.length(); i++)
    {
       if (data[i]=='1'){
         dataConsecutive++;
      }
       else {
         dataConsecutive = 0;
      }
       if(dataConsecutive == consecutive-1){
        	 stuffedData += "10";
          dataConsecutive = 0;
        }
       else { stuffedData += data[i];}
    }
    return stuffedData;
}

string de_stuffing(string stuffedData,int consecutive)
{
	string deStuffedData = "";
    int stuffConsecutive = 0;
    int skip =0;
    for (int i=0; i<stuffedData.length(); i++) {
         if (skip ==1)
         {
            skip=0;
            continue;
         }
        if (stuffedData[i]=='1'){
          	stuffConsecutive++;
        }
        else { stuffConsecutive = 0;}

        if (stuffConsecutive == consecutive-1){
            deStuffedData += stuffedData[i]; 
             stuffConsecutive = 0;
            skip =1;

        }else{
            deStuffedData += stuffedData[i];
        }
        
    }
    return deStuffedData;
}

int main(){
	string data,flag;
	cout<< "Enter Data : " << endl;
	cin >> data ;
	cout << "Enter flag :" << endl;
	cin >> flag;
	int consecutive =1; int count=1;
    for (int i=0; i< flag.length()-1; i++)
    {
       if (flag[i]==flag[i+1]&& flag[i]== '1'){count++;}
       else {count = 1;}
       consecutive = max(consecutive,count);
    }

    string stuffedData = stuffing(data,consecutive);
    string deStuffedData = de_stuffing(stuffedData,consecutive);
    cout <<"Original Data   : " <<data << endl;
	cout <<"Stufed Data     : " <<stuffedData << endl;
	cout <<"De-stufed Data  : " <<deStuffedData << endl;
	
}