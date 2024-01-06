import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	int sum = 0;
        	for(int j = x1-1 ; j<x2; j ++) {
        		for(int k=y1-1; k<y2; k++) {
        			sum += arr[j][k];
        		}
        	}
        	System.out.println(sum);
        }
    }
}
