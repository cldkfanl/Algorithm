import java.io.*;
import java.util.*;

public class Main {
	static int arr[][];
	static boolean check[][];
	static int fx[] = {0,0,-1,1};
	static int fy[] = {-1,1,0,0};
	static int outmax = 0;
	static int n,m;
	static class Loc{
		int x;
		int y;
		
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        check = new boolean[n][m];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int cnt = 0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(arr[i][j] == 1 && !check[i][j]) {
        			dfs(i,j);
        			cnt ++;
        		}
        	}
        }
        System.out.println(cnt);
        System.out.println(outmax);
    }
    static void dfs(int x, int y) {
    	check[x][y] = true;
    	int max = 1;
    	Queue<Loc> q = new LinkedList<>();
    	q.add(new Loc(x,y));
    	while(!q.isEmpty()) {
    		Loc now = q.poll();
    		for(int i=0; i<4; i++) {
    			int nx = fx[i] + now.x;
    			int ny = fy[i] + now.y;
    			
    			if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
    				continue;
    			}
    			if(arr[nx][ny] == 1 && !check[nx][ny]) {
    				q.add(new Loc(nx,ny));
    				check[nx][ny] = true;
    				max ++;
    			}
    		}
    	}
    	outmax = Math.max(outmax, max);
    }
}
