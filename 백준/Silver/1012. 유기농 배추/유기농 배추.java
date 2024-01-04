import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean flag[][];
	static int M;
	static int N;
	static int K;
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	static int now_x, now_y;
	static int count;

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	M = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	arr = new int[N][M];
        	flag = new boolean[N][M];
        	K = Integer.parseInt(st.nextToken());
        	for(int j=0; j<K; j++) {
            	StringTokenizer st2 = new StringTokenizer(br.readLine());
            	int X = Integer.parseInt(st2.nextToken());
            	int Y = Integer.parseInt(st2.nextToken());
            	arr[Y][X]++;
        	}
        	count = 0;
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(arr[j][k] == 1 && flag[j][k] == false) {
						count++;
						DFS(k, j);
					}
				}
			}
			sb.append(count).append('\n');
        }
        System.out.println(sb);
	}
	public static void DFS(int x, int y) {
		flag[y][x] = true;

		for(int i=0; i<4; i++) {
			now_x = x + dirX[i];
			now_y = y + dirY[i];

			if(Range_check() && flag[now_y][now_x] == false && arr[now_y][now_x] == 1) {
				DFS(now_x, now_y);
			}

		}
	}

	static boolean Range_check() {
		return (now_y < N && now_y >= 0 && now_x < M && now_x >= 0);
	}
}
