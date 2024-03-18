#include <bits/stdc++.h>
#include<iostream>
using namespace std;

//너무 귀찮게하는 문제
//배열 값 복원 시 복원 위치 확인할 것
int dx[4] = { 0, -1, 0, 1 };
int dy[4] = { 1, 0, -1, 0 };
int N, M;
vector<vector<int>> arr;
vector<pair<int, int>> cctv;
int output = 987654321;

void check(int x, int y, int dir) {
    dir %= 4;
    while (1) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        x = nx;
        y = ny;
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
            return;
        }
        if (arr[nx][ny] == 6) {
            return;
        }
        if (arr[nx][ny] != 0){
            continue;
        }
        arr[nx][ny] = -1;

    }
}



void dfs(int idx) {
    if (idx == cctv.size()) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        output = min(output, cnt);
        return;
    }

    int x = cctv[idx].first;
    int y = cctv[idx].second;

    vector<vector<int>> tmp(N, vector<int>(M,0));

    for (int dir = 0; dir < 4; dir++) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        switch (arr[x][y]) {
        case 1 : 
            check(x, y, dir);
            break;

        case 2:
            check(x, y, dir);
            check(x, y, dir+2);
            break;
        case 3:
            check(x, y, dir);
            check(x, y, dir+1);
            break;
        case 4:
            check(x, y, dir);
            check(x, y, dir+1);
            check(x, y, dir+2);
            break;
        case 5:
            check(x, y, dir);
            check(x, y, dir + 1);
            check(x, y, dir + 2);
            check(x, y, dir + 3);
            break;
        }
        dfs(idx + 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
    }
}


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

   
    cin >> N >> M;
    arr.resize(N, vector<int>(M));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            int tmp;
            cin >> tmp;
            arr[i][j] = tmp;
            if (arr[i][j] != 0 && arr[i][j] != 6) {
                cctv.push_back({ i,j });
            }
        }
    }
    dfs(0);

    cout << output;
    return 0;
}