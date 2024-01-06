import java.io.*;
import java.util.*;
public class Main {
	static int arr[][];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N][2 * N - 1];
        star(N, 0, N-1);
        for(int i=0; i<N; i++) {
        	for(int j=0; j<2 * N - 1; j++) {
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
	static void star(int cnt, int x, int y) {
		if(cnt == 3) {
			arr[x][y] = 1;
			arr[x + 1][y -1] = arr[x + 1][y + 1] = 1;
			for(int i=0; i<5; i++) {
				arr[x+2][y+i-2] = 1;
			}
			return;
		}
		star(cnt/2 , x, y);
		star(cnt/2, x + cnt/2 , y - cnt/2);
		star(cnt/2, x + cnt/2 , y + cnt/2);
	}
}
