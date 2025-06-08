#include <bits/stdc++.h>
#include<iostream>
#include <unordered_map>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    int A, B, C, time;

    cin >> A >> B >> C >> time;

    A += time / 3600;
    time %= 3600;

    B += time / 60;
    time %= 60;

    C += time;

    if (C >= 60) { B += C / 60; C %= 60; }
    if (B >= 60) { A += B / 60; B %= 60; }
    if (A >= 24) { A %= 24; }

    cout << A << " " << B << " " << C;


    return 0;
}