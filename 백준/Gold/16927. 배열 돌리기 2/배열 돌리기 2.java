import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr_2[];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long R = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        for(int i=0; i<N; i++) {
        	StringTokenizer st_2 = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st_2.nextToken());
        	}
        }
        int minCycle = Math.min(N, M) / 2;
        for (int i1 = 0; i1 < minCycle; i1++) {
            int numElements = (N - i1 * 2) * 2 + (M - i1 * 2) * 2 - 4;
            int rotation = (int) (R % numElements);
            while(rotation-- >0) {
            		int temp = arr[i1][i1];
                	for(int j = i1; j<M-1-i1; j++) {
                		arr[i1][j] = arr[i1][j+1];
                	}
                	for(int j = i1; j<N-1-i1; j++) {
                		arr[j][M-1-i1] = arr[j+1][M-1-i1];
                	}
                	for(int j = M-i1-1; j>i1; j--) {
                		arr[N-1-i1][j] = arr[N-1-i1][j-1];
                	}

                	for(int j = N-i1-1; j>i1; j--) {
                		arr[j][i1] = arr[j-1][i1];
                	}

                	arr[i1+1][i1] = temp;
            	}
            }

        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		System.out.print(arr[i][j] + " ");
        	}
        	System.out.println("");
        }
	}
}
