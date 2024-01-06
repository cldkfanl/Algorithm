import java.io.*;
import java.util.*;

public class Main {
	static class Loc{
		int x;
		int y;
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M;
	static int fx[] = {0,0,1,-1};
	static int fy[] = {1,-1,0,0};
	static int arr[][];
	static boolean flag[][];
	static Queue<Integer> sizeq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        for(int i=0; i<K; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	for(int j=y; j<y2; j++) {
        		for(int k=x; k<x2; k++) {
        			arr[j][k]++;
        		}
        	}
        }
        flag = new boolean[M][N];
        for(int i=0; i<M; i++) {
        	for(int j=0; j<N; j++) {
        		if(arr[i][j] == 0 && !flag[i][j]) {
        			check(i,j);
        		}
        	}
        }
        int cmp[] = new int[sizeq.size()];
        int tmp = 0;
        while(!sizeq.isEmpty()) {
        	cmp[tmp] = sizeq.poll();
        	tmp++;
        }
        Arrays.sort(cmp);
        System.out.println(cmp.length);
        for(int i=0; i<cmp.length; i++) {
        	System.out.print(cmp[i] + " ");
        }
    }
    static void check(int x, int y) {
    	Queue<Loc> q = new LinkedList<>();
    	q.add(new Loc(x,y));
    	int size = 1;
    	flag[x][y] = true;
    	while(!q.isEmpty()) {
    		Loc now = q.poll();
        	for(int i=0; i<4; i++) {
        		int nx = now.x + fx[i];
        		int ny = now.y + fy[i];
        		if(nx < 0 || nx >= M || ny < 0 || ny >= N || flag[nx][ny]) {
        			continue;
        		}
        		if(arr[nx][ny] == 0) {
            		flag[nx][ny] = true;
            		size++;
            		q.add(new Loc(nx, ny));
        		}
        	}
    	}
    	sizeq.add(size);
    }
}
