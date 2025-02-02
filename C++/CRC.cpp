#include<bits/stdc++.h>
using namespace std;

char data[20]; char div[20]; char temp[4]; char total[100];

int i , j , datalen , divlen , len , flag=1;

void check ( )
{
for( j =0; j<divlen ; j++)
data[j]= total[j];
while( j<=len )
{
if (data[0]== '1')
	for( i = 1 ; i <divlen ; i++)
		data[i]= ((data[i] == div[i]) ? '0' : '1' );
for( i =0; i<divlen -1; i++)
	data[i]=data[i +1] ;
data[i]= total[j++];
}
}
int main( )
{
cout << " Enter the total bit of data : " << endl ;
cin >>datalen;
cout <<" Enter the total bit of divisor " << endl ;
cin >> divlen;
len = datalen + divlen - 1;
cout << "Enter the data : " <<endl;
cin >> data;
cout << "Enter the divisor " << endl;
cin >> div ;
for ( i =0; i<datalen ; i++)
{
total[i]=data[i];
temp[i]=data[i];
}
for( i=datalen ; i<len ; i++)
	total[i]='0';
	check ( ) ;
for( i =0; i<divlen; i++)
	temp[i+datalen ]=data[i];
cout << "transmitted Code Word: " << temp << endl ;
cout << "Enter the received code word : " << endl ;
cin >> total;
check ( ) ;
for( i =0; i<divlen - 1; i++){
if(data[i]=='1')
{
flag=0;
break ;
}
}
if(flag==1)
	cout << "successful!!" << endl ;
else
	cout << "received code word contains errors..." << endl;
}
