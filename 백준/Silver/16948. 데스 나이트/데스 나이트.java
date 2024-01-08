import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, 1, -1};
    static int N, r1, c1, r2, c2;
    static int arr[][];
    static boolean flag[][];
    static int count = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        flag = new boolean[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        bfs(r1,c1);
        if(count == 0) {
        	System.out.println(-1);
        }
        else {
            System.out.println(count);
        }
	}
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c, 0});
		flag[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cnt = q.poll();
			int x = cnt[0];
			int y = cnt[1];
			int count2 = cnt[2];
			if(x == r2 && y == c2) {
				count = count2;
				return;
			}
			for(int i=0; i<6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < N && ny >=0 && ny < N && !flag[nx][ny]) {
					flag[nx][ny] = true;
					q.add(new int[] {nx,ny,count2+1});
				}
			}
		}

	}
}
