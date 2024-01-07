import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static int x;
    static int y;
    static int max = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    static boolean flag[][];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        arr = new int[x][y];
        flag = new boolean[x][y];
        for(int i=0; i<x; i++) {
            StringTokenizer st_2 = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<y; j++) {
        		arr[i][j] = Integer.parseInt(st_2.nextToken());
        	}
        }
        for(int i = 0; i< x; i++) {
        	for(int j = 0; j<y; j++) {
        		flag[i][j] = true;
        		comp(i,j,1,arr[i][j]);
        		flag[i][j] = false;
        	}
        }
        comp_2();
        System.out.println(max);
	}
	public static void comp_2() {
	    int dx[] = null;
	    int dy[] = null;
	    for(int i=1; i<=4; i++) {
		    switch (i) {
	        case 1:
	            dx = new int[]{0, 1, -1, 0};
	            dy = new int[]{0, 0, 0, 1};
	            compT(dx, dy);
	            break;
	        case 2:
	            dx = new int[]{0, 1, -1, 0};
	            dy = new int[]{0, 0, 0, -1};
	            compT(dx, dy);
	            break;
	        case 3:
	            dx = new int[]{0, 0, 0, 1};
	            dy = new int[]{0, 1, -1, 0};
	            compT(dx, dy);
	            break;
	        case 4:
	            dx = new int[]{0, 0, 0, -1};
	            dy = new int[]{0, 1, -1, 0};
	            compT(dx, dy);
	            break;
		    }
	    }
	}

	public static void compT(int[] dx, int[] dy) {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				int number = 0;
				int count = 0;
				for(int i1=0; i1<4; i1++) {
					int nx = i + dx[i1];
					int ny = j + dy[i1];
					if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
		                count ++;
		                number += arr[nx][ny];
					}
				}
				if(count == 4) {
					max = Math.max(max, number);
				}
			}
		}
	}

	public static void comp(int x1, int y1, int depth, int sum) {
		if(depth == 4) {
			max = Math.max(sum, max);
			return;
		}
			int dx[] = {-1,1,0,0};
			int dy[] = {0,0,-1,1};
			for(int i=0; i<4; i++) {
				int nx = x1 + dx[i];
				int ny = y1 + dy[i];
				
				if (nx < 0 || nx >= x || ny < 0 || ny >= y || flag[nx][ny]) {
	                continue;
	            }
				flag[nx][ny] = true;
				comp(nx,ny,depth+1, sum + arr[nx][ny]);
				flag[nx][ny] = false;
			}
		}
	}
