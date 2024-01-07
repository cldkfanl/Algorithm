import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int arr[][];
	static int arr2[][];
	static int output = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<M; j++) {
        		int nxt = Integer.parseInt(st.nextToken());
        		arr[i][j] = nxt;
        	}
        }
        wall(0);
        System.out.println(output);
	}
	static void wall(int count) {
		if(count == 3) {
			bfs();
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(count+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 2) {
					q.add(new Node(i,j));
				}
			}
		}
		int copyarr[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			copyarr[i] = arr[i].clone();
		}
		while(!q.isEmpty()) {
			Node now = q.poll();
			int x = now.x;
			int y = now.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx >= 0 && ny >= 0 && nx < N && ny <M) {
					if(copyarr[nx][ny] == 0) {
						q.add(new Node(nx,ny));
						copyarr[nx][ny] = 2;
					}
				}
			}
		}
		checksafezone(copyarr);
	}
	static void checksafezone(int check[][]) {
		int zone = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(check[i][j] == 0) {
					zone++;
				}
			}
		}
		output = Math.max(zone, output);
	}
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
