#include <bits/stdc++.h>
#include<iostream>
using namespace std;
int N, M;
vector<int> result, inDegree;
vector<vector<int>> graph;



void topologySort() {
    queue<int> q;
    //진입차수가 0인 접점을 큐에 삽입
    for (int i = 1; i <= N; i++) {
        if (inDegree[i] == 0) {
            q.push(i);
        }
    }
    //N번 반복
    for (int i = 0; i < N; i++) {
        //큐가 비어있다면(진입차수가 0이 아니라면(사이클이 있다면))
        if (q.empty()) {
            return;
        }

        //비어있지 않은 경우
        int cur = q.front();

        //방문정보 저장
        result[i] = cur;
        q.pop();

        for (int j = 0; j < graph[cur].size(); j++) {
            int nxt = graph[cur][j];
            inDegree[nxt]--;
            if (inDegree[nxt] == 0) {
                q.push(nxt);
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

    //0으로 초기화
    inDegree.assign(N + 1, 0);
    result.assign(N + 1, 0);
    graph.assign(N + 1, vector<int>(0, 0));

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        graph[a].emplace_back(b);
        inDegree[b]++;
    }
    topologySort();


    //출력
    for (int i = 0; i < N; i++) {
        cout<<result[i] << " ";
    }


    return 0;
}
 