#include <bits/stdc++.h>
#include<iostream>
using namespace std;

vector<int> SwitchBasket(vector<int> basket, int start, int end) {
    vector<int> tmp(basket.size());
    copy(basket.begin(), basket.end(), tmp.begin());
    for (auto i = 0; i < end - start + 1; i++) {
        basket[start + i] = tmp[end - i];
    }
    return basket;
}

int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int N, M;
    
    vector<int> basket;
    cin >> N >> M;
    for (auto i = 1; i <= N; i++) {
        basket.push_back(i);
    }

    for (auto i = 0; i < M; i++) {
        int I, J;
        cin >> I >> J;
        basket = SwitchBasket(basket, I-1, J-1);
    }

    for (auto i = 0; i < N; i++) {
        cout << basket[i] << " ";
    }

    return 0;
}