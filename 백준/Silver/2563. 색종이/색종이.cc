#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int arr[101][101] = {};
    int N;
    cin >> N;
    for (int i = 0; i < N; i++) {
        int x, y;
        cin >> x >> y;
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                arr[x + j][y + k]++;
            }
        }
    }
    int size = 0;
    for (int i = 0; i < 101; i++) {
        for (int j = 0; j < 101; j++) {
            if (arr[i][j] > 0) {
                size++;
            }
        }
    }
    cout << size << endl;

    return 0;
}