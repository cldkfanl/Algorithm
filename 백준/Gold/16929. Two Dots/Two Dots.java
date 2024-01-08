import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
    static int[] dx = {-1,0, 1,0};
    static int[] dy = {0,-1, 0,1};
	static int N, M;
	static char arr[][];
	static String output = "No";
	static int x = 0;
	static int y = 0;
	static boolean flag[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        flag= new boolean[N][M];
        arr = new char[N][M];
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	for(int j=0; j<M; j++) {
        		arr[i][j] = input.charAt(j);
        	}
        }
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {

        		x = i;
        		y = j;
        		if(output.equals("No")) {
            		dfs(i,j,1);
        		}
        		else {
        			break;
        		}
        	}
        }
        System.out.println(output);
	}
	static void dfs(int fi, int fj, int depth) {

		if(depth >= 4 && fi == x && fj == y) {
			output = "Yes";
			return;
		}
    	for(int i=0; i<4; i++) {
    		int nx = fi + dx[i];
    		int ny = fj + dy[i];
    		if(nx < 0 || ny < 0 || nx >=N || ny >=M) {
    			continue;
    		}
    		if(arr[nx][ny] == arr[x][y] && !flag[nx][ny]) {
    			flag[nx][ny] = true;
    			dfs(nx,ny,depth+1);
    			flag[nx][ny] = false;

    		}
    	}

	}
}
