#include <stdio.h>
#include <iostream>
using namespace std;
#include <queue>


int main() {
    int V, E, sum = 0;
    cin >> V >> E;
    //방문 여부 저장하는 배열
    vector<bool> visited(V + 1);
    //간선 정보 저장하는 그래프
    vector<vector<pair<int, int>>> map(V + 1, vector<pair<int, int>>());
    //우선순위큐(프림 알고리즘 사용)
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;


    for (int i = 0; i < E; i++) {
        int A, B, C;
        cin >> A >> B >> C;
        //무방향 그래프, 양쪽 간선정보 추가
        map[A].push_back({ B,C });
        map[B].push_back({ A,C });
    }
    pq.push({ 0,1 });

    //프림 알고리즘
    while (!pq.empty()) {
        //현재 정점, 가중치
        auto cur = pq.top();
        pq.pop();
        //만약 방문했다면 무시
        if (visited[cur.second]) {
            continue;
        }

        //현재 정점 방문 처리, 가중치 더함
        visited[cur.second] = true;
        sum += cur.first;

        //현재 정점과 연결된 모든 정점을 큐에 추가
        for (auto next : map[cur.second]) {
            if (visited[next.first]) {
                continue;
            }
            pq.push({next.second, next.first});
        }
    }

    //출력
    cout << sum;
    return 0;

}