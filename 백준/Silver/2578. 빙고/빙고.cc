#include <bits/stdc++.h>
#include<iostream>
using namespace std;

bool check[5][5] = {};

bool bingo() {
    int num = 0;
    for (int i = 0; i < 5; i++) {
        if (check[i][0] && check[i][1] && check[i][2] && check[i][3] && check[i][4]) {
            num++;
        }
        if (check[0][i] && check[1][i] && check[2][i] && check[3][i] && check[4][i]) {
            num++;
        }
    }
    if (check[0][0] && check[1][1] && check[2][2] && check[3][3] && check[4][4]) {
        num++;
    }
    if (check[4][0] && check[3][1] && check[2][2] && check[1][3] && check[0][4]) {
        num++;
    }
    if (num >= 3) {
        return true;
    }
    return false;
}


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int arr[5][5] = {};
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> arr[i][j];
            check[i][j] = false;
        }
    }
    int cnt = 0;
    while (true) {
        int num;
        cin >> num;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (num == arr[i][j]) {
                    check[i][j] = true;
                }
            }
        }
        if (bingo() == true) {
            cnt++;
            cout << cnt << endl;
            break;
        }
        else {
            cnt++;
        }
    }



    return 0;
}
 