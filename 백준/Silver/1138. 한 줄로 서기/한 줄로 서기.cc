#include<iostream>
#include<fstream>
#include<vector>
using namespace std;

int main(){

    int N;
    cin>>N;
    vector<vector<int>> arr(N,vector<int>(2));

    for(int i=1; i<=N; i++){
        arr[i-1][0] = i;
        cin>>arr[i-1][1];
    }
    vector<int> v(N);
    for(int i=0; i<N; i++){
        v[i] = -1;
    }
    for(int i=0; i<N; i++){
        int cnt = 0;
        int cnt2 = 0;
        while(true){
            if(v[cnt2] == -1){
                if(cnt == arr[i][1]){
                    v[cnt2] = arr[i][0];
                    break;
                }
                cnt++;
                cnt2++;
            }
            else{
                cnt2++;
            }
        }
    }
    for(int i=0; i<N; i++){
        cout<< v[i]<<" ";
    }
    return 0;
}