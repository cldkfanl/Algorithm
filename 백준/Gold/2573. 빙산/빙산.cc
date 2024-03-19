#include <bits/stdc++.h>
#include<iostream>
using namespace std;

//아이디어는 어렵지 않은듯
//dfs
int dx[4] = { 0, -1, 0, 1 };
int dy[4] = { 1, 0, -1, 0 };
int N, M;
vector<vector<int>> arr;
vector<vector<int>> arr_check;
vector<vector<bool>> visited;
int year = 0;
int cnt = 0;

void dfs(int x, int y) {
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
        int nx = dx[i] + x;
        int ny = dy[i] + y;
        if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && arr[nx][ny] != 0) {
            dfs(nx, ny);
        }
    }
}

int iceberg_cnt() {
    int iceberg = 0;
    visited.assign(N, vector<bool>(M, false));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (arr[i][j] != 0 && !visited[i][j]) {
                dfs(i, j);
                iceberg++;
            }
        }
    }

    return iceberg;
}

void ice_check(int x, int y) {
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
            continue;
        }
        if (arr[nx][ny] == 0) {
            arr_check[x][y]++;
        }
    }
    
}

void ice() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            arr_check[i][j] = 0;
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (arr[i][j] != 0) {
                ice_check(i, j);
            }
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            arr[i][j] -= arr_check[i][j];
            if (arr[i][j] < 0) {
                arr[i][j] = 0;
            }
            if (arr[i][j] == 0 && arr_check[i][j] > 0) {
                cnt--;
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
    arr_check.resize(N, vector<int>(M));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            int tmp;
            cin >> tmp;
            if (tmp != 0) {
                cnt++;
            }
            arr[i][j] = tmp;
        }
    }
    while (true) {
        year++;
        ice();
        if (iceberg_cnt() >= 2) {
            cout << year;
            break;
        }
        else if (cnt == 0) {
            cout << 0;
            break;
        }
    }


    return 0;
}