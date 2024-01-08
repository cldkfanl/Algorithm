import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char arr[][];
	static int fx[] = {0,0,-1,1};
	static int fy[] = {1,-1,0,0};
	static class Loc {
		int x;
		int y;
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Queue<Loc> q = new LinkedList<>();
	static int cnt = 0;
	static boolean flag[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        flag = new boolean[N][M];
        for(int i=0; i<N; i++) {
    		String input = br.readLine();
        	for(int j=0; j<M; j++) {
        		arr[i][j] = input.charAt(j);
        		if(arr[i][j] == 'I') {
        			q.add(new Loc(i,j));
        			flag[i][j] = true;
        		}
        	}
        }
        dfs();
        if(cnt == 0) {
        	System.out.println("TT");
        }
        else {
            System.out.println(cnt);
        }
    }
    static void dfs() {
    	while(!q.isEmpty()) {
    		Loc now = q.poll();
    		for(int i=0; i<4; i++) {
    			int nx = now.x + fx[i];
    			int ny = now.y + fy[i];
    			
    			if(nx >=0 && ny >=0 && nx < N && ny < M && !flag[nx][ny]) {
    				if(arr[nx][ny] == 'O') {
    					q.add(new Loc(nx,ny));
    					flag[nx][ny] = true;
    				}
    				else if(arr[nx][ny] == 'P') {
    					q.add(new Loc(nx,ny));
    					flag[nx][ny] = true;
    					cnt++;
    				}
    			}
    		}
    	}
    }
}