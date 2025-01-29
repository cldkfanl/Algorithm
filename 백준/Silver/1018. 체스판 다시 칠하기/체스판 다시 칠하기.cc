#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int CheckChecker(vector<vector<bool>> arr, int x, int y) {
    int cntB = 0;
    int cntW = 0;
    for (auto i = 0; i < 8; i++) {
        for (auto j = 0; j < 8; j++) {
            bool isEven = ((i + j) % 2 == 0);
            if (arr[x + i][y + j] != isEven) {
                cntB++;
            }
            if (arr[x + i][y + j] != !isEven) {
                cntW++;
            }
        }
    }
    return min(cntB, cntW);
}



int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int N, M;
    cin >> N >> M;

    vector<vector<bool>> arr(N, vector<bool>(M));

    for (auto i = 0; i < N; i++) {
        string input;
        cin >> input;
        for (auto j = 0; j < M; j++) {
            arr[i][j] = (input[j] == 'B');
        }
    }
    int minVal = 64;
    for (int i = 0; i <= N - 8; i++) {
        for (int j = 0; j <= M - 8; j++) {
            minVal = min(minVal, CheckChecker(arr, i, j));
        }
    }

    cout << minVal << endl;


    return 0;
}