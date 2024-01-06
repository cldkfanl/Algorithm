import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Loc{
		int x;
		int y;
		char point;
		public Loc(int x, int y, char point) {
			this.x = x;
			this.y = y;
			this.point = point;
		}
	}
	static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean flag[][][];
	static char arr[][];
	static int count = 0;
	static int count2 = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        flag = new boolean[N][N][2];
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	for(int j=0; j<N; j++) {
        		arr[i][j] = input.charAt(j);
        	}
        }
        bfs();
        System.out.println(count);
        System.out.println(count2);
	}
	static void bfs() {
		Queue<Loc> q = new LinkedList<>();
		Queue<Loc> q1 = new LinkedList<>();
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
   				char point = arr[i][j];
    			if(!flag[i][j][0]) {
    				q.add(new Loc(i,j,point));
    				flag[i][j][0] = true;
    		    	while(!q.isEmpty()) {
    		    		Loc now = q.poll();
    		    		for(int k=0; k<4; k++) {
    						int nx = now.x + dx[k];
    						int ny = now.y + dy[k];
    		                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
    		                    continue;
    		                }
    		                if(!flag[nx][ny][0] && arr[nx][ny] == point) {
    		                	flag[nx][ny][0] = true;
    		                	q.add(new Loc(nx, ny, point));
    		                }
    		    		}
    		    	}
    		    	count++;
    			}
    			if(!flag[i][j][1]) {
    				q1.add(new Loc(i,j,point));
    				flag[i][j][1] = true;
    		    	while(!q1.isEmpty()) {
    		    		Loc now1 = q1.poll();
    		    		for(int k=0; k<4; k++) {
    						int nx = now1.x + dx[k];
    						int ny = now1.y + dy[k];
    		                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
    		                    continue;
    		                }
    		                if(!flag[nx][ny][1]) {
        		                if(point == 'R' || point == 'G') {
        		                	if(arr[nx][ny] == 'R' || arr[nx][ny] == 'G') {
            		                	flag[nx][ny][1] = true;
            		                	q1.add(new Loc(nx, ny, point));
        		                	}
        		                }
        		                else {
        		                	if(arr[nx][ny] == point) {
            		                	flag[nx][ny][1] = true;
            		                	q1.add(new Loc(nx, ny, point));
            		                }
        		                }
    		                }
    		    		}
    		    	}
    		    	count2++;
    			}
    		}
    	}
	}
}
