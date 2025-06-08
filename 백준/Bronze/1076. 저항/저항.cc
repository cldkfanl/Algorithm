#include <bits/stdc++.h>
#include<iostream>
#include <unordered_map>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    unordered_map<string, int> color = {
        {"black", 0},
        {"brown", 1},
        {"red", 2},
        {"orange", 3},
        {"yellow", 4},
        {"green", 5},
        {"blue", 6},
        {"violet", 7},
        {"grey", 8},
        {"white", 9}
    };

    string fir_color, sec_color, thr_color;

    cin >> fir_color >> sec_color >> thr_color;

    int fir = color[fir_color];
    int sec = color[sec_color];
    int thr = color[thr_color];

    long long res = (fir * 10 + sec) * pow(10, thr);

    cout << res;



    return 0;
}