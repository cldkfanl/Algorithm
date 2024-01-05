import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char arr[][];
	static boolean flag[];
	static boolean flag2[][];
    static int[] dx = {-1,0, 1,0};
    static int[] dy = {0,-1, 0,1};
    static int count = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        flag = new boolean[26];
        for(int i=0; i<R; i++) {
        	String input = br.readLine();
        	for(int j=0; j<C; j++) {
        		arr[i][j] = input.charAt(j);
        	}
        }
        flag[arr[0][0] - 'A'] = true;
        dfs(0,0,1);
        System.out.println(count);
	}
	
	static void dfs(int x, int y, int depth) {
		count = Math.max(count, depth);
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny <0 || nx >= R || ny >= C) {
				continue;
			}
			if(!flag[arr[nx][ny] - 'A']) {
				flag[arr[nx][ny] - 'A'] = true;
				dfs(nx,ny,depth+1);
				flag[arr[nx][ny] - 'A'] = false;
			}
		}
	}
}
