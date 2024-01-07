import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { 0, 0,-1,-1, 1, 1};
    static int[] dy = {-1, 1, 0, 1,-1, 0};
    static int N;
    static int arr[][];
    static int flag[][];
    static int output = 0;
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        flag = new int[N][N];
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	for(int j=0; j<N; j++) {
        		if(input.charAt(j) == '-') {
        			arr[i][j] = 0;
        		}
        		else {
        			arr[i][j] = 1;
        		}
        		flag[i][j] = -1;
        	}
        }
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(arr[i][j] == 1 && flag[i][j] == -1) {
        			dfs(i,j,0);
        		}
        	}
        }
        System.out.println(output);
	}
	static void dfs(int x, int y, int cnt) {
		flag[x][y] = cnt;
		output = Math.max(output, 1);
		
		for(int i=0; i<6; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx>= N || ny >= N) {
				continue;
			}
			if(arr[nx][ny] == 1 && flag[nx][ny] == -1) {
				dfs(nx,ny,1-cnt);
				output = Math.max(output, 2);
			}
			
			if(flag[nx][ny] == cnt) {
				output = 3;
			}
		}
	}
}
