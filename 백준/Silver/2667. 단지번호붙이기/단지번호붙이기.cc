#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int N, nowcnt;
int arr[25][25];
bool flag[25][25];

int fx[4] = { 0,1,-1,0 };
int fy[4] = { -1,0,0,1 };

void dfs(int x, int y) {
    flag[x][y] = true;
    for (int i = 0; i < 4; i++) {
        int nx = x + fx[i];
        int ny = y + fy[i];
        if (nx >= 0 && ny >= 0 && nx < N && ny < N && !flag[nx][ny] && arr[nx][ny] == 1) {
            dfs(nx, ny);
            nowcnt++;
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    string line;
    vector<int> arrsize;
    for (int i = 0; i < N; i++) {
        cin >> line;
        for (int j = 0; j < N; j++) {
            arr[i][j] = line[j] - '0';
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (arr[i][j] && !flag[i][j]) {
                nowcnt = 1;
                dfs(i, j);
                arrsize.push_back(nowcnt);
            }
        }
    }
    sort(arrsize.begin(), arrsize.end());
    cout << arrsize.size() << endl;;
    for (int i = 0; i < arrsize.size(); i++) {
        cout << arrsize[i] << endl;
    }

    return 0;
}