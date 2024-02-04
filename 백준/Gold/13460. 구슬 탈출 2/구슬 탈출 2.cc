#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

//너무어렵다.... 도저히 안되겠어서 구글링해서 참조했음

struct INFO {
    int ry, rx, by, bx, cnt;
};

INFO start;
char map[10][11];

int bfs() {
    int dy[] = { -1,1,0,0 };
    int dx[] = { 0,0,-1,1 };

    int visited[10][10][10][10] = { 0, };
    queue<INFO> q;
    q.push(start);
    visited[start.ry][start.rx][start.by][start.bx] = 1;

    int ans = -1;

    while (!q.empty()) {
        INFO cur = q.front();
        q.pop();

        // 10회 넘어갈 경우
        if (cur.cnt > 10) {
            break;
        }

        // red 구슬 탈출
        if (map[cur.ry][cur.rx] == 'O' and map[cur.by][cur.bx] != 'O') {
            ans = cur.cnt;
            break;
        }

        for (int i = 0; i < 4; i++) {
            int nx_ry = cur.ry;
            int nx_rx = cur.rx;
            int nx_by = cur.by;
            int nx_bx = cur.bx;

            // red 벽이나 구멍일 때 까지 한 방향으로 이동
            while (1) {
                if (map[nx_ry][nx_rx] != '#' && map[nx_ry][nx_rx] != 'O') {
                    nx_ry += dy[i];
                    nx_rx += dx[i];
                }
                else {
                    if (map[nx_ry][nx_rx] == '#') { //벽일경우 전 위치로
                        nx_ry -= dy[i];
                        nx_rx -= dx[i];
                    }
                    break;
                }
            }

            // blue 벽이나 구멍일 때 까지 한 방향으로 이동
            while (1) {
                if (map[nx_by][nx_bx] != '#' && map[nx_by][nx_bx] != 'O') {
                    nx_by += dy[i];
                    nx_bx += dx[i];
                }
                else {
                    if (map[nx_by][nx_bx] == '#') { //벽일경우 전 위치로
                        nx_by -= dy[i];
                        nx_bx -= dx[i];
                    }
                    break;
                }
            }


            //red, blue가 겹치는 경우
            if (nx_ry == nx_by && nx_rx == nx_bx) {
                if (map[nx_ry][nx_rx] != 'O') {
                    int red_dist = abs(nx_ry - cur.ry) + abs(nx_rx - cur.rx);
                    int blue_dist = abs(nx_by - cur.by) + abs(nx_bx - cur.bx);

                    if (blue_dist > red_dist) {
                        nx_by -= dy[i];
                        nx_bx -= dx[i];
                    }
                    else {
                        nx_ry -= dy[i];
                        nx_rx -= dx[i];
                    }
                }
            }

            //방문표시, 여부확인
            if (!visited[nx_ry][nx_rx][nx_by][nx_bx]) {
                visited[nx_ry][nx_rx][nx_by][nx_bx] = true;
                INFO next;
                next.ry = nx_ry;
                next.rx = nx_rx;
                next.by = nx_by;
                next.bx = nx_bx;
                next.cnt = cur.cnt + 1;

                q.push(next);
            }
        }
    }

    return ans;
}


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N, M;
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        cin >> map[i];
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (map[i][j] == 'R') {
                start.ry = i;
                start.rx = j;
            }
            else if (map[i][j] == 'B') {
                start.by = i;
                start.bx = j;
            }
        }
    }
    start.cnt = 0;

    int ans = bfs();
    cout << ans << "\n";

    return 0;
}
