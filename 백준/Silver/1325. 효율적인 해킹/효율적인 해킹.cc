#include <stdio.h>
#include <iostream>
using namespace std;
#include <vector>
#include <algorithm>

int N, M;
const int MAX = 10001;
bool flag[MAX];
vector<int> map[MAX];
vector<pair<int, int>> v;
int cnt = 1;

void dfs(int v) {
    flag[v] = true;

    for (int i = 0; i < map[v].size(); i++) {
        int tmp = map[v][i];

        if (!flag[tmp]) {
            flag[tmp] = true;
            dfs(tmp);
            cnt++;
        }
    }
}
void resetflag() {
    for (int i = 0; i <= N; i++) {
        flag[i] = false;
    }
}

int main() {
    cin >> N >> M;
    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        map[b].push_back(a);
    }

    for (int i = 1; i <= N; i++) {
        dfs(i);
        resetflag();
        v.push_back(make_pair(i, cnt));
        cnt = 1;
    }

    int maxcnt = -1;
    for (int i = 0; i < v.size(); i++) {
        if (v[i].second > maxcnt) {
            maxcnt = v[i].second;
        }
    }
    for (int i = 0; i < v.size(); i++) {
        if (v[i].second == maxcnt) {
            cout << v[i].first << " ";
        }
    }

}