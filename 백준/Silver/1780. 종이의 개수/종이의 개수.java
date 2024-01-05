import java.io.*;
import java.util.*;

public class Main {
	static int arr[][];
	static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
            	arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paper(0,0,N);
        int fir = 0;
        int sec = 0;
        int thr = 0;
        while(!q.isEmpty()) {
        	int now = q.poll();
        	if(now == -1) {
        		fir ++;
        	}
        	else if(now == 0) {
        		sec ++;
        	}
        	else {
        		thr ++;
        	}
        }
        System.out.println(fir);
        System.out.println(sec);
        System.out.println(thr);
    }
    static void paper(int x, int y, int size) {
    	if(check(x,y,size)) {
    		q.add(arr[x][y]);
    	}
    	else {
    		int nSize = size/3;
    		for(int i=0; i<3; i++) {
    			for(int j=0; j<3; j++) {
    				int nx = x + nSize * i;
    				int ny = y + nSize * j;
    				paper(nx, ny, nSize);
    			}
    		}
    	}
    }
    static boolean check(int x, int y, int size) {
    	int start = arr[x][y];
    	for(int i = x; i< x + size; i++) {
    		for(int j = y; j< y + size; j++) {
    			if(arr[x][y] != arr[i][j]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
