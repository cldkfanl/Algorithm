#include <bits/stdc++.h>
#include<iostream>
using namespace std;

//ccw 알고리즘...
//세개의 점의 외적의 결과로 구분한다.
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    pair<int, int> fir;
    pair<int, int> sec;
    pair<int, int> thr;

    cin >> fir.first >> fir.second;
    cin >> sec.first >> sec.second;
    cin >> thr.first >> thr.second;

    int cmp;
    cmp = (sec.first - fir.first) * (thr.second - fir.second) - (thr.first - fir.first) * (sec.second - fir.second);
    if (cmp == 0) {
        cout << 0 << endl;
    }
    else if (cmp > 0) {
        cout << 1 << endl;
    }
    else {
        cout << -1 << endl;
    }
   
    
    return 0;
}
 