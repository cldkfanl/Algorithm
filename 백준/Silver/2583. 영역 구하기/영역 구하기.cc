#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int fx[4] = { 0,1,-1,0 };
int fy[4] = { -1,0,0,1 };
int M, N, K;
vector<vector<int>> arr;
vector<vector<bool>> check;


int dfs(int x, int y) {
    check[x][y] = true;
    int area = 1;
    for (int i = 0; i < 4; i++) {
        int nx = fx[i] + x;
        int ny = fy[i] + y;
        if (nx >= 0 && ny >= 0 && nx < M && ny < N && !check[nx][ny] && arr[nx][ny] == 0) {
            area += dfs(nx, ny);
        }
    }
    return area;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> M >> N >> K;

    arr.resize(M, vector<int>(N, 0));
    check.resize(M, vector<bool>(N, false));

    for (int i = 0; i < K; i++) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        for (int j = x1; j < x2; j++) {
            for (int k = y1; k < y2; k++) {
                arr[k][j] = 1;
            }
        }
    }
    int len = 0;
    vector<int> size;
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            if (arr[i][j] == 0 && !check[i][j]) {
                len++;
                int num = dfs(i, j);
                size.push_back(num);
            }
        }
    }
    sort(size.begin(), size.end());
    cout << len << endl;
    for (int i = 0; i < size.size(); i++) {
        cout << size[i] << " ";
    }

    return 0;
}