#include <bits/stdc++.h>
#include<iostream>
using namespace std;





int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    int fibo[41];
    fibo[0] = 1;
    fibo[1] = 1;
    fibo[2] = 2;
    for (int i = 3; i <= 40; i++) {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
    }
    int N, M;
    cin >> N >> M;
    bool check[41] = {};
    for (int i = 0; i < M; i++) {
        int num;
        cin >> num;
        check[num] = true;
    }
    int output = 1;
    int cnt = 0;
    for (int i = 1; i <= N; i++) {
        if (!check[i]) {
            cnt++;
        }
        else {
            output *= fibo[cnt];
            cnt = 0;
        }
    }
    output *= fibo[cnt];

    cout << output << endl;
    return 0;
}