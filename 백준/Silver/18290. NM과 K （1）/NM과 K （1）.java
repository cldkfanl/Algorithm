import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, k, max;
	public static boolean flag[][];
	public static int arr[][];
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            StringTokenizer st_2 = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
            	arr[i][j] = Integer.parseInt(st_2.nextToken());
            }
        }
        flag = new boolean[N][M];
        chooseNumber(0,0,0,0);
    	System.out.println(max);
	}
	public static void chooseNumber(int x, int y, int count, int sum) {

		if(count == k) {
			max = Math.max(max, sum);
			return;
		}
		else {
			for(int i=x; i<N; i++) {
				for(int j=y; j<M; j++) {
					if(!flag[i][j]) {
						if(check(i,j)) {
							flag[i][j] = true;
							chooseNumber(x,y,count+1, sum + arr[i][j]);
							flag[i][j] = false;
						}
					}
				}
			}
		}
	}
	public static boolean check(int x, int y) {
        boolean flag_2 = true;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
                if (flag[next_x][next_y]) {
                    flag_2 = false;
                }
            }
        }
        return flag_2;
    }
}
