import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static class Node {
        int x;
        int y;
        int count;
        int k;
        
        public Node(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }
    static int fx[] = {0, 1, 0 ,-1}; // 원숭이가 이동할 수 있는 4방향
    static int fy[] = {1, 0, -1, 0};
	static int jx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int jy[] = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int K, W, H;
	static int arr[][];
	static int output = Integer.MAX_VALUE;
    static boolean[][][] flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int [H][W];
    	flag = new boolean[H][W][K+1];
        for(int i=0; i<H; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<W; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        output = bfs(0,0);
        if(output == Integer.MAX_VALUE) {
        	System.out.println(-1);
        }
        else {
            System.out.println(output);
        }
    }
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0, K)); 
        flag[x][y][K] = true;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            if(current.x == H - 1 && current.y == W - 1) return current.count; 
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + fx[i];
                int ny = current.y + fy[i];
                if(nx >= 0 && ny >= 0 && nx < H && ny < W && !flag[nx][ny][current.k] && arr[nx][ny] == 0) {
                	flag[nx][ny][current.k] = true;
                    q.offer(new Node(nx, ny, current.count + 1, current.k));
                }
            }
            
            if(current.k > 0) {
                for(int i = 0; i < 8; i++) {
                    int nx = current.x + jx[i];
                    int ny = current.y + jy[i];
                    if(nx >= 0 && ny >= 0 && nx < H && ny < W && !flag[nx][ny][current.k - 1] && arr[nx][ny] == 0) {
                    	flag[nx][ny][current.k - 1] = true;
                        q.offer(new Node(nx, ny, current.count + 1, current.k - 1));
                    }
                }
            }
        }
        return output;
    }
}
