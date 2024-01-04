import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean flag[][];
	static int N, count, outcount;
	static String out = "";
	static int now_x, now_y;
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flag = new boolean[N+2][N+2];
         arr= new int [N+2][N+2];
         for(int i = 0; i<N; i++) {
        	 String a = br.readLine();
        	 for(int j=0; j<N; j++) {
        		 arr[i+1][j+1] = Integer.parseInt(a.substring(j,j+1));
        	 }
         }
         outcount = 0;
         count = 1;
         for(int i=1; i<N+1; i++) {
        	 for(int j=1; j<N+1; j++) {
        		 if(arr[i][j] == 1 && !flag[i][j]) {
        			 check(i,j);
        			 out += count + " ";
        			 count = 1;
        			 outcount++;
        		 }
        	 }
         }
         StringTokenizer st = new StringTokenizer(out, " ");
         int arrout[] = new int[outcount];
         for(int i=0; i<outcount; i++) {
        	 arrout[i] = Integer.parseInt(st.nextToken());
         }
         Arrays.sort(arrout);
         System.out.println(outcount);
         for(int i=0; i<outcount; i++) {
        	 System.out.println(arrout[i]);
         }
	}
	public static void check(int x, int y) {
		flag[x][y] = true;
		for(int i=0; i<4; i++) {
			now_x = x + dirX[i];
			now_y = y + dirY[i];
			if(!flag[now_x][now_y] && arr[now_x][now_y] ==1) {
				check(now_x, now_y);
				count++;
			}
		}
	}
}
