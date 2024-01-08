import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Loc{
		int x;
		int y;
		int size;
		int count;
		public Loc(int x, int y, int size, int count) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.count = count;
		}
	}
	static int N;
	static int arr[][];
	static int distance[][];
    static int[] dx = {-1,0, 1,0};
    static int[] dy = {0,-1, 0,1};
	static int sharksize = 2;
	static int sharkx = 0;
	static int sharky = 0;
	static int output = 0;
	static int fisheat = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        distance = new int[N][N];
        int count = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
            	arr[i][j] = Integer.parseInt(st.nextToken());
            	if(arr[i][j] != 0 && arr[i][j] != 9) {
            		count++;
            	}
            	if(arr[i][j] == 9) {
            		sharkx = i;
            		sharky = j;
            	}
            }
        }
        while (count-- > 0) {
            if (!bfs()) {
                break; // 먹을 물고기를 찾지 못하면 종료
            }
            }

        System.out.println(output);
    }
	static boolean bfs() {
        boolean flag[][] = new boolean[N][N];
        Queue<Loc> q = new LinkedList<>();
        flag[sharkx][sharky] = true;
        q.add(new Loc(sharkx, sharky, sharksize, 0));

        int targetX = -1, targetY = -1, minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Loc now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int ncnt = now.count + 1;

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !flag[nx][ny]) {
                    if (arr[nx][ny] <= now.size) {
                        flag[nx][ny] = true;
                        q.add(new Loc(nx, ny, now.size, ncnt));
                        if (arr[nx][ny] > 0 && arr[nx][ny] < now.size) {
                            if (ncnt < minDist) {
                                minDist = ncnt;
                                targetX = nx;
                                targetY = ny;
                            } else if (ncnt == minDist) {
                                if (nx < targetX || (nx == targetX && ny < targetY)) {
                                    targetX = nx;
                                    targetY = ny;
                                }
                            }
                        }
                    }
                }
            }

        }
        
        if (targetX != -1 && targetY != -1) {
            // 먹을 물고기를 찾았을 때
            output += minDist;
            arr[sharkx][sharky] = 0;
            sharkx = targetX;
            sharky = targetY;
            fisheat++;
            if (fisheat == sharksize) {
                sharksize++;
                fisheat = 0;
            }
            return true;
        }
        
        return false;
	}
}