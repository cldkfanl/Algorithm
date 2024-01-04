import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int now_x, now_y;
	static int arr[][];
	static int max;
	static StringBuilder sb = new StringBuilder();
	static int dirX[] = {1, 0, -1, 0};
	static int dirY[] = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
        	String a = br.readLine();
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(a.substring(j,j+1));
        	}
        }
        max = check(0,0);
        System.out.println(max);
	}
	static int check(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int x1 = current[0];
			int y1 = current[1];
			for(int i=0; i<4; i++) {
				now_x = x1 + dirX[i];
				now_y = y1 + dirY[i];
				if(now_x >=0 && now_y >=0 && now_x<N && now_y<M && arr[now_x][now_y] == 1) {
					queue.offer(new int[] {now_x, now_y});
					arr[now_x][now_y] = arr[x1][y1] + 1;
				}
			}
		}
		return arr[N-1][M-1];
	}
}
