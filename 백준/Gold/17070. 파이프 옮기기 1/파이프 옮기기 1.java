import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[][] map;
    static int output = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N + 1][N + 1];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        DFS(1, 2, 0);
        System.out.println(output);
    }
    public static void DFS(int x, int y, int direction) {
        if (x == N && y == N) {
            output++;
            return;
        }
        switch (direction) {
        case 0:
            if (y + 1 <= N && map[x][y + 1] == 0) { // 동쪽
                DFS(x, y + 1, 0);
            }
            break;
        case 1:
            if (x + 1 <= N && map[x + 1][y] == 0) { // 남쪽
                DFS(x + 1, y, 1);
            }
            break;
        case 2:
            if (y + 1 <= N && map[x][y + 1] == 0) { // 동쪽
                DFS(x, y + 1, 0);
            }
 
            if (x + 1 <= N && map[x + 1][y] == 0) { // 남쪽
                DFS(x + 1, y, 1);
            }
            break;
        }
        if (y + 1 <= N && x + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, 2);
        }
    }
 
}
