#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int fy[4] = { 0,1,0,-1 };
int fx[4] = { -1,0,1,0 };

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int arr[41][2] = {};
    arr[0][0] = 1;
    arr[1][1] = 1;
    for (int i = 2; i <= 40; i++) {
        arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
        arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
    }

    int N;
    cin >> N;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        cout << arr[num][0] << " " << arr[num][1] << endl;
    }
    return 0;
}