import java.io.*;
import java.util.*;

public class Main {
	static class Loc{
		int x;
		int y;
		int len;
		public Loc(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int fx[] = {-1,1,0,0};
        int fy[] = {0,0,1,-1};
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];
        int len[][] = new int[n][m];
        Queue<Loc> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 2) {
        			q.add(new Loc(i,j,0));
        		}
        	}
        }
        while(!q.isEmpty()) {
        	Loc now = q.poll();
        	for(int i=0; i<4; i++) {
        		int nx = now.x + fx[i];
        		int ny = now.y + fy[i];
        		
        		if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1 && len[nx][ny] == 0) {
        			len[nx][ny] = now.len + 1;
        			q.add(new Loc(nx,ny,now.len + 1));
        		}
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(arr[i][j] == 1 && len[i][j] == 0) {
        			sb.append(-1).append(" ");
        		}
        		else {
            		sb.append(len[i][j]).append(" ");
        		}
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}