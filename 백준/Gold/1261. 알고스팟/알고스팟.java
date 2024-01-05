import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x;
	int y;
	int cnt;
	
	Point(int x, int y, int cnt){
		this.x = x;
        this.y = y;
        this.cnt = cnt;
	}
	@Override
	public int compareTo(Point o) {
        return cnt - o.cnt;
    }
}
public class Main {
	static int N, M;
	static int arr[][];
	static boolean flag[][];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        flag = new boolean[N][M];
        for(int i=0; i<N; i++) {
        	String next = br.readLine();
        	for(int j=0; j<M; j++) {
        		int input = next.charAt(j)-'0';
        		arr[i][j] = input;
        	}
        }
        int output = bfs(0,0);
        System.out.println(output);
	}
	static int bfs(int numx, int numy) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.offer(new Point(numx,numy,0));
		flag[numx][numy] = true;
		
		 while(!q.isEmpty()) {
			 Point p = q.poll();
			 if(p.x == N-1 && p.y == M-1) {
				 return p.cnt;
			 }
			 for(int i=0; i<4; i++) {
				 int nx = p.x + dx[i];
				 int ny = p.y + dy[i];
				 if(nx < 0 || nx >=N || ny <0 || ny >=M) {
					 continue;
				 }
				 if(!flag[nx][ny] && arr[nx][ny] == 0) {
					 flag[nx][ny] = true;
					 q.offer(new Point(nx,ny,p.cnt));
				 }
				 if(!flag[nx][ny] && arr[nx][ny] == 1) {
					flag[nx][ny] = true;
					q.offer(new Point(nx,ny,p.cnt+1));
				 }
			 } 
		 }
		 return 0;
	}
}
