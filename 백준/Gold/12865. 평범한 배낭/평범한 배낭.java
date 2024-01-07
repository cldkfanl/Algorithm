import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int arr[][];
	static int W[], V[];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][K+1];
        W = new int[N+1];
        V = new int[N+1];
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	W[i] = Integer.parseInt(st.nextToken());
        	V[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=K; j++) {
        		if(W[i] > j) {
        			arr[i][j] = arr[i-1][j];
        		}
        		else {
        			arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-W[i]] + V[i]);
        		}
        	}
        }
        System.out.println(arr[N][K]);
	}
	
}
