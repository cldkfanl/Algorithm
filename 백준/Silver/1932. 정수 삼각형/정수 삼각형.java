import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int arr[][] = new int[a+1][a+1];
        int max[][] = new int[a+1][a+1];
        for(int i=1; i<=a; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int j=1; j<=i; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        max[1][1] = arr[1][1];
        for(int i=2; i<=a; i++) {
        	for(int j=1; j<=i; j++) {
        		max[i][j] = Math.max(max[i-1][j-1]+arr[i][j] ,arr[i][j] + max[i-1][j]);
        	}
        }
        Arrays.sort(max[a]);
        System.out.println(max[a][a]);
    }
}
