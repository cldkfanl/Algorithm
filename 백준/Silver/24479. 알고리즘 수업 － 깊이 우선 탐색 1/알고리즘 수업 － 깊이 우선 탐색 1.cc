#include <bits/stdc++.h>
#include<iostream>
using namespace std;

vector<int> graph[100001];
bool flag[100001] = { false };
int result[100001];
int cnt = 0;

void dfs(int R) {
    if (flag[R]) {
        return;
    }
    flag[R] = true;
    cnt++;
    result[R] = cnt;

    for (int i = 0; i < graph[R].size(); i++) {
        dfs(graph[R][i]);
    }
}


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int N, M, R;

    cin >> N >> M >> R;

    

    for (int i = 0; i < M; i++) {
        int fir, sec;
        cin >> fir >> sec;
        graph[fir].push_back(sec);
        graph[sec].push_back(fir);
    }
    for (int i = 1; i <= N; i++) {
        sort(graph[i].begin(), graph[i].end());
    }

    dfs(R);

    for (int i = 1; i <= N; i++) {
        printf("%d\n", result[i]);
    }

    return 0;
}