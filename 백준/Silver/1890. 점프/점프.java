import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        long cnt[][] = new long[N][N];
        cnt[0][0] = 1;
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		int tmp = arr[i][j];
        		if(tmp != 0) {
            		if(i + tmp < N) {
            			cnt[i+tmp][j] += cnt[i][j];
            		}
            		if(j + tmp < N) {
            			cnt[i][tmp + j] += cnt[i][j]; 
            		}
        		}
        	}
        }
        System.out.println(cnt[N-1][N-1]);
    }
}
