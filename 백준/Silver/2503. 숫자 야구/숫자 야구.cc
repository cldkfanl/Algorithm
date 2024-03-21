#include<iostream>
#include<fstream>
#include<vector>
using namespace std;
//브루트포스
//조건문 설정 잘 하자
int cnt = 0;
int N;
int arr[101][3];
void baseball(int num){
    int a = num/100;
    int b = (num/10)%10;
    int c = num%10;
    bool check = true;
    if(a != 0 && b != 0 && c != 0 && a != b && a != c && b != c){
        for(int i=0; i<N; i++){
            int cmpa = arr[i][0]/100;
            int cmpb = (arr[i][0]/10)%10;
            int cmpc = arr[i][0]%10;
            int strike = 0;
            int ball = 0;
            if(a==cmpa) strike++;
            else if(b == cmpa || c == cmpa) ball++;
            if(b==cmpb) strike++;
            else if(a == cmpb || c == cmpb) ball++;
            if(c==cmpc) strike++;
            else if(a == cmpc || b == cmpc) ball++;

            if(!(strike == arr[i][1] && ball == arr[i][2])){
                check = false;
                break;
            }
        }
    }
    else{
        check = false;
    }
    if(check){
        cnt ++;
    }
}
int main(){

    cin>>N;

    for(int i=0; i<N; i++){
        cin >>arr[i][0]>>arr[i][1]>>arr[i][2];
    }
    for(int i=100; i<=999; i++){
        baseball(i);
    }

    cout<<cnt;
    return 0;
}