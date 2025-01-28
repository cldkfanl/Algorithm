#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int N, M;
    
    vector<int> basket;
    cin >> N >> M;
    for (auto i = 0; i <= N; i++) {
        basket.push_back(i);
    }

    for (auto i = 0; i < M; i++) {
        int I, J;
        cin >> I >> J;
        int tmp1 = basket[I];
        int tmp2 = basket[J];
        basket[I] = tmp2;
        basket[J] = tmp1;
    }

    for (auto i = 1; i <= N; i++) {
        cout << basket[i] << " ";
    }

    return 0;
}