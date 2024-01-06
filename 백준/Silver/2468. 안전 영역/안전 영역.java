import java.io.*;
import java.util.*;

public class Main {
	static int output = 0;
	static int arr[][];
	static int N;
	static boolean checked[][];
	static int fx[] = {-1,1,0,0};
	static int fy[] = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int max = 0;
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
            	arr[i][j] = Integer.parseInt(st.nextToken());
            	max = Math.max(max, arr[i][j]);
            }
        }
        for(int i= 0; i<=max; i++) {
        	checked = new boolean[N][N];
        	int cnt = 0;
        	for(int j=0; j<N; j++) {
        		for(int k=0; k<N; k++) {
        			if(!checked[j][k] && arr[j][k] > i) {
        				cnt += dfs(i,j,k);
        			}
        		}
        	}
        	output = Math.max(cnt, output);
        }
        System.out.println(output);
    }
    static int dfs(int height, int x, int y) {
    	checked[x][y] = true;
    	for(int i=0; i<4; i++) {
			int nx = x + fx[i];
			int ny = y + fy[i];
			
			if(nx >= N || nx <0 || ny >= N || ny < 0) {
				continue;
			}
			if(checked[nx][ny]) {
				continue;
			}
			if(arr[nx][ny] > height) {
				dfs(height, nx, ny);
			}
    	}
    	return 1;
    }
}
