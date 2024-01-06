import java.io.*;
import java.util.*;

public class Main {
    static int fx[] = {-1,0,1,-1,1,-1,0,1};
    static int fy[] = {-1,-1,-1,0,0,1,1,1};
    static int w, h;
    static int arr[][];
    static boolean flag[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 || h == 0) {
            	break;
            }
            arr = new int[h][w];
            for(int i=0; i<h; i++) {
            	st = new StringTokenizer(br.readLine(), " ");
            	for(int j=0; j<w; j++) {
            		arr[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            flag= new boolean[h][w];
            int cnt = 0;
            for(int i=0; i<h; i++) {
            	for(int j=0; j<w; j++) {
            		if(!flag[i][j] && arr[i][j] == 1) {
            			check(i,j);
            			cnt++;
            		}
            	}
            }
            System.out.println(cnt);
        }
    }
    static void check(int x, int y) {
    	flag[x][y] = true;
    	for(int i=0; i<8; i++) {
    		int nx = x + fx[i];
    		int ny = y + fy[i];
    		if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
    			continue;
    		}
    		if(!flag[nx][ny] && arr[nx][ny] == 1) {
        		check(nx,ny);
    		}
    	}
    }
}
