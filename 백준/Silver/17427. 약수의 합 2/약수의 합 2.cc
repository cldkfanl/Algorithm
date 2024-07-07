#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    int N;
    cin >> N;
    long output = 0;
    for (int i = 1; i <= N; i++) {
        output += N / i * i;
    }
    cout << output << endl;
    return 0;
}