import java.io.*;
import java.util.*;
public class Main {
	static int arr[][];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        star(N,N/2 + 1,N/2 + 1, 1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(arr[i][j] == 1) {
        			sb.append("*");
        		}
        		else {
        			sb.append(" ");
        		}
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
	}
	static void star(int cnt, int x, int y, int state) {
		if(cnt == 1) {
			arr[x-1][y-1] = state;
			return;
		}
		if(state == 0) {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					star(cnt/3 , x + (i -1)*cnt/3 , y + (j-1) * cnt/ 3 , 0);
				}
			}
		}
		else {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i == 1 && j == 1) {
						star(cnt/3 , x, y, 0);
					}
					else {
						star(cnt/3 , x + (i -1)*cnt/3 , y + (j-1) * cnt/ 3 , 1);
					}
				}
			}
		}
	}
}
