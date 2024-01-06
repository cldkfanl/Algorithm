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
	static int N, M;
	static int arr[][], flag[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int output = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        flag = new int[N][M];
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
        		flag[i][j] = Integer.MAX_VALUE;
        	}
        }
        bfs(0,0,1);
        if(output == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(output);
        }
	}
	static void bfs(int x, int y, int count) {

    	Queue<Loc> q = new LinkedList<>();
    	q.add(new Loc(x,y,count,0));
    	while(!q.isEmpty()) {
			Loc now = q.poll();
			if(now.x == N-1 && now.y == M-1) {
				output = now.cnt;
				break;
			}
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int ncnt = now.cnt;
				if(nx >= 0 && ny >=0 && nx < N && ny < M && flag[nx][ny] > now.wall) {
					if(arr[nx][ny] == 0) {
						flag[nx][ny] = now.wall;
						q.add(new Loc(nx,ny,ncnt+1,now.wall));

					}
					else if(arr[nx][ny] == 1 && now.wall == 0) {
						flag[nx][ny] = now.wall +1;
						q.add(new Loc(nx,ny,ncnt+1,now.wall + 1));
						
					}
				}
			}
    	}
	}
}
