import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static class Data implements Comparable<Data> {
        int y, x, bd, cnt;

        public Data(int y, int x, int bd, int cnt) {
            this.y = y;
            this.x = x;
            this.bd = bd;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Data other) {
            return Integer.compare(this.cnt, other.cnt);
        }
    }

    static int W, H;
    static int sy, sx;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] WH = br.readLine().split(" ");
        W = Integer.parseInt(WH[0]);
        H = Integer.parseInt(WH[1]);
        map = new char[H][W];
        visited = new boolean[H][W][4][4];

        boolean isfind = false;
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C' && !isfind) {
                    isfind = true;
                    map[i][j] = '.';
                    sy = i;
                    sx = j;
                }
            }
        }

        System.out.println(solution());
    }

    static int solution() {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int nd = 0; nd < 4; nd++) {
            pq.add(new Data(sy, sx, nd, 0));
            visited[sy][sx][nd][nd] = true;
        }

        while (!pq.isEmpty()) {
            Data cur = pq.poll();
            int y = cur.y;
            int x = cur.x;
            int bd = cur.bd;
            int cnt = cur.cnt;

            if (map[y][x] == 'C') return cnt;

            for (int nd = 0; nd < 4; nd++) {
                int ny = y + dy[nd];
                int nx = x + dx[nd];
                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if (map[ny][nx] == '*' || visited[ny][nx][bd][nd]) continue;
                visited[ny][nx][bd][nd] = true;
                if (nd != bd) pq.add(new Data(ny, nx, nd, cnt + 1));
                else pq.add(new Data(ny, nx, nd, cnt));
            }
        }

        return -1; // C에 도달할 수 없는 경우
    }
}