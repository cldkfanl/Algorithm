import java.io.*;
import java.util.*;


public class Main {
	static int N, M;
	static int arr[][];
	static int fx[] = {-1, 1, 0, 0};
	static int fy[] = {0, 0, 1, -1};
	static class Loc {
		int x;
		int y;
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int cCount = 0;
	static int day = 0;
	static Queue<Loc> q = new LinkedList<>();
	static Queue<Loc> q2 = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 1) {
        			cCount++;
        		}
        	}
        }
        if(cCount == 0) {
        	System.out.println(0);
        }
        else {
        	while(cCount != 0) {
        		day++;
            	inoutcheck();
            	removeair();
        	}
            System.out.println(day);
        }
    }
    static void removeair() {
    	while(!q2.isEmpty()) {
    		Loc now = q2.poll();
    		if(openair(now.x,now.y) >= 2) {
        		q.add(new Loc(now.x,now.y));
    		}
    	}
    	while(!q.isEmpty()) {
    		Loc now = q.poll();
    		arr[now.x][now.y] = 2;
    		cCount--;
    	}
    }
    static void inoutcheck() {
    	q.add(new Loc(0,0));
    	boolean check[][] = new boolean[N][M];
    	while(!q.isEmpty()) {
    		Loc now = q.poll();
    		for(int i=0; i<4; i++) {
    			int nx = now.x + fx[i];
    			int ny = now.y + fy[i];
	    		if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
	    			continue;
	    		}
	    		if(!check[nx][ny]) {
		    		if(arr[nx][ny] == 0) {
		    			q.add(new Loc(nx,ny));
		    			arr[nx][ny] = 2;
		    		}
		    		else if(arr[nx][ny] == 2) {
		    			q.add(new Loc(nx,ny));
		    		}
		    		else if(arr[nx][ny] == 1) {
		    			q2.add(new Loc(nx,ny));
		    		}
	    			check[nx][ny] = true;
	    		}
    		}
    	}
    }
    static int openair(int x, int y) {
    	int cnt = 0;
    	for(int i=0; i<4; i++) {
    		int nx = x + fx[i];
    		int ny = y + fy[i];
    		if(nx<0 || nx >= N || ny < 0 || nx >= M) {
    			cnt ++;
    			continue;
    		}
    		if(arr[nx][ny] == 2) {
    			cnt ++;
    		}
    	}
    	return cnt;
    }
}
