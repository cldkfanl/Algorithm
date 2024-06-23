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

    int N, M, r, c, d;

    cin >> N >> M;
    cin >> r >> c >> d;

    int cnt = 0;
    vector<vector<int>> room(N, vector<int>(M));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> room[i][j];
        }
    }
    
    while (true) {
        bool clean = false;
        if (room[r][c] == 0) {
            room[r][c] = 2;
            cnt++;
        }
        for (int i = 0; i < 4; i++) {
            int nd = (d + 3) % 4;
            int nx = fx[nd] + r;
            int ny = fy[nd] + c;
            d = nd;
            if (room[nx][ny] == 0) {
                r = nx;
                c = ny;
                clean = true;
                break;
            }
        }
        if(!clean) {      //청소할 곳이 없으면
            int nx = r - fx[d];
            int ny = c - fy[d];
            if (room[nx][ny] != 1) {
                r = nx;
                c = ny;
            }
            else {
                break;
            }
        }
    }
    cout << cnt << endl;

    return 0;
}