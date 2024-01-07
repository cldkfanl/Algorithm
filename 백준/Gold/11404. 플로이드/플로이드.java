import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int INF = 987654321;
        int arr[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		arr[i][j] = INF;
        		
        		if(i == j) {
        			arr[i][j] = 0;
        		}
        	}
        }
        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(arr[a][b], c);
        }
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		for(int k=1; k<=n; k++) {
        			arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		if(arr[i][j] == INF) {
        			arr[i][j] = 0;
        		}
        		sb.append(arr[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}
