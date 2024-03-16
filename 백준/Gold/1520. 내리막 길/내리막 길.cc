#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int M, N;
int arr[500][500] = {};
int cnt[500][500] = {};

int dx[4] = { 0,0,1,-1 };
int dy[4] = { -1,1,0,0 };

int down_check(int x, int y) {
    if (x == M - 1 && y == N - 1) {
        return 1;
    }
    if (cnt[x][y] != -1) {
        return cnt[x][y];
    }

    cnt[x][y] = 0;
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
            if (arr[nx][ny] < arr[x][y]) {
                cnt[x][y] = cnt[x][y] + down_check(nx, ny);
            }
        }
    }

    return cnt[x][y];
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> M >> N;

    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            cin >> arr[i][j];
            cnt[i][j] = -1;
        }
    }
    int result = down_check(0, 0);
    cout << result << endl;



    return 0;
}
 