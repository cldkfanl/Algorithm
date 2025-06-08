#include <bits/stdc++.h>
#include<iostream>

using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, F;
    cin >> N >> F;

    N = (N / 100) * 100;

    while (N % F != 0) {
        N++;
    }
    cout << (N % 100) / 10 << N % 10;


    return 0;
}