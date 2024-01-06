import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
	static int output = Integer.MAX_VALUE;
	static int N,M;
	static int arr[][];
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 1) {
        			q.add(new int[] {i,j});
        		}
        	}
        }
        System.out.println(tomato());
	}
	static int tomato(){
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int x = t[0];
			int y = t[1];
			for(int i=0; i<4; i++) {
				int nextx = x + dx[i];
				int nexty = y + dy[i];
				if(nextx <0 || nextx >=N || nexty <0 || nexty >= M)
					continue;
				if(arr[nextx][nexty] == 0) {
					arr[nextx][nexty] = arr[x][y] + 1;
					q.add(new int[]{nextx,nexty});
				}
			}
		}
		int max = Integer.MIN_VALUE;
		if(checkZero()) {
			return -1;
		}
		else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(max < arr[i][j]) {
						max = arr[i][j];
					}
				}
			}
			return max -1;
		}
	}
	static boolean checkZero() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}
}
