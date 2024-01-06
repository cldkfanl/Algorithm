import java.io.*;
import java.util.*;

public class Main {
	static int dirX[] = {0, 0, -1, 1, 0, 0};
	static int dirY[] = {-1, 1, 0, 0, 0, 0};
	static int dirZ[] = {0, 0, 0, 0, 1, -1};
    static int N,M,H;
    static int arr[][][];
    static int count = Integer.MIN_VALUE;
    static Queue<Loc> q = new LinkedList<>();
    static class Loc{
    	int z;
    	int y;
    	int x;
    	public Loc(int z, int y, int x) {
    		this.z = z;
    		this.y = y;
    		this.x = x;
    	}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr= new int[H][N][M];
        boolean zero = true;
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
            	st = new StringTokenizer(br.readLine(), " ");
            	for(int k=0; k<M; k++) {
            		int num = Integer.parseInt(st.nextToken());
            		arr[i][j][k] = num;
            		if(num == 1) {
            			q.offer(new Loc(i,j,k));
            		}
            		else if(num == 0) {
            			zero = false;
            		}
            	}
            }
        }
        if(zero) {
        	System.out.println(0);
        }
        else {
            bfs();
            for(int i=0; i<H; i++) {
            	for(int j=0; j<N; j++) {
            		for(int k=0; k<M; k++) {
            			if(arr[i][j][k] == 0) {
            				System.out.println(-1);
            				return;
            			}
            			if(count < arr[i][j][k]) {
            				count = arr[i][j][k];
            			}
            		}
            	}
            }
            System.out.println(count-1);
        }
    }
    static void bfs() {
    	while(!q.isEmpty()) {
    		Loc now = q.poll();
    		for(int i=0; i<6; i++) {
    			int nx = now.x + dirX[i];
    			int ny = now.y + dirY[i];
    			int nz = now.z + dirZ[i];
    			if(nx < M && nx >= 0 && ny < N && ny >= 0 && nz < H && nz >= 0 && arr[nz][ny][nx] == 0) {
    				arr[nz][ny][nx] = arr[now.z][now.y][now.x] + 1;
    				q.offer(new Loc(nz,ny,nx));
    			}
    		}
    	}
    }
}
