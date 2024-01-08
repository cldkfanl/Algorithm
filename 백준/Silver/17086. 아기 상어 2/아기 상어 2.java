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
		public Loc(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int output = 0;
	static int N, M;
	static int arr[][];
	static int fx[] = {-1, 0 , 1, -1, 1, -1, 0, 1};
	static int fy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static Queue<Loc> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<M; j++) {
        		int check = Integer.parseInt(st.nextToken());
        		if(check == 1) {
        			q.add(new Loc(i,j,0));
        		}
        		arr[i][j] = check;
        	}
        }
        bfs();
        System.out.println(output);
	}
	static void bfs() {
    	boolean flag[][] = new boolean[N][M];
    	while(!q.isEmpty()) {
    		Loc now = q.poll();
    		flag[now.x][now.y] = true;
    		for(int i=0; i<8; i++) {
    			int nx = now.x + fx[i];
    			int ny = now.y + fy[i];
    			if(nx < 0 || nx >= N || ny >= M || ny < 0) {
    				continue;
    			}
    			if(!flag[nx][ny]) {
        			flag[nx][ny] = true;
        			output = Math.max(output, now.cnt + 1);
        			q.add(new Loc(nx,ny, now.cnt + 1));
    			}
    		}
    	}
	}
}
