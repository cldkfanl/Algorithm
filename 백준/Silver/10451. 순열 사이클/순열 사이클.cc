#include <bits/stdc++.h>
#include<iostream>
using namespace std;

vector<int> arr[1001];
bool check[1001];

void dfs(int fir) {
    check[fir] = true;
    for (int i = 0; i < arr[fir].size(); i++) {
        int nxt = arr[fir][i];
        if (!check[nxt]) {
            dfs(nxt);
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    




    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        int N;
        cin >> N;
        for (int j = 1; j <= N; j++) {
            arr[j].clear();
            check[j] = false;
        }
        for (int j = 1; j <= N; j++) {
            int V;
            cin >> V;
            arr[j].push_back(V);
        }
        int cnt = 0;
        for (int j = 1; j <= N; j++) {
            if (!check[j]) {
                dfs(j);
                cnt++;
            }
        }

        cout << cnt << endl;
    }


    return 0;
}
 