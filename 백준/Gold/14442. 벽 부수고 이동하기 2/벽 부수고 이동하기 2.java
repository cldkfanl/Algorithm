import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Loc{
		int x;
		int y;
		int cnt;
		int wall;
		public Loc(int x, int y, int cnt, int wall) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall;
		}
	}
	static int N,M,K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int arr[][];
    static boolean flag[][][];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        flag = new boolean[N][M][K+1];
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	for(int j=0; j<M; j++) {
        		arr[i][j] = input.charAt(j) - '0';
        	}
        }
        System.out.println(bfs());
	}
	static int bfs() {
    	Queue<Loc> q = new LinkedList<>();
    	q.offer(new Loc(0,0,1,0));
    	flag[0][0][0] = true;
    	while(!q.isEmpty()) {
			Loc now = q.poll();
			if(now.x == N-1 && now.y == M-1) {
				return now.cnt;
			}
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int ncnt = now.cnt;
				
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
				if(arr[nx][ny] == 0 && !flag[nx][ny][now.wall]) {
					flag[nx][ny][now.wall] = true;;
					q.offer(new Loc(nx,ny,ncnt+1,now.wall));

				}
				else if(arr[nx][ny] == 1 && now.wall < K && !flag[nx][ny][now.wall+1]) {
					flag[nx][ny][now.wall+1] = true;
					q.offer(new Loc(nx,ny,ncnt+1,now.wall + 1));
					
				}
			}
    	}
    	return -1;
	}
}
