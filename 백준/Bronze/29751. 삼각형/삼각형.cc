#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    int W, H;
    cin >> W >> H;

    double output = 0;

    output = (double)W * (double)H / 2;

    printf("%.1f", output);

    return 0;
}