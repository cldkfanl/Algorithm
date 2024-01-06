import java.io.*;
import java.util.*;

public class Main {
	static class Loc{
		int x;
		int cnt;
		public Loc(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int fir = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int arr[][] = new int[N+1][N+1];
        boolean check[][] = new boolean[N+1][N+1];
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	arr[x][y] = 1;
        	arr[y][x] = 1;
        }
        int out = -1;
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(fir,0));
        while(!q.isEmpty()) {
        	Loc now = q.poll();
        	if(now.x == sec) {
        		out = Math.max(out, now.cnt);
        	}
        	for(int i=1; i<=N; i++) {
        		if(arr[now.x][i] == 1) {
        			if(!check[now.x][i]) {
            			q.add(new Loc(i,now.cnt + 1));
            			check[now.x][i] = true;
            			check[i][now.x] = true;
        			}
        		}
        	}
        }
        System.out.println(out);
    }
}
