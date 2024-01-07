import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int div = 10007;
        
        int arr[][] = new int[N+1][N+1];
        
        for(int i=0; i<N+1; i++) {
        	for(int j=0; j<= i; j++) {
        		if(i == j || j == 0) {
        			arr[i][j] = 1;
        		}
        		else {
        			arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]) % div;
        		}
        	}
        }
        System.out.println(arr[N][K]);
    }
}
