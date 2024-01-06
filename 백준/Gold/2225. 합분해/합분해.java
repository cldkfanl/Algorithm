import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long arr[][] = new long[a+1][b];
        for(int i=0; i<=a; i++) {
        	arr[i][0] = 1;
        }
        for(int i=0; i<b; i++) {
        	arr[0][i] = 1;
        }
        for(int i=1; i<=a; i++) {
        	for(int j=1 ;j<b; j++) {
        		arr[i][j] = (arr[i][j] + arr[i][j-1] + arr[i-1][j])%1000000000;
        	}
        }
        System.out.println(arr[a][b-1]);
    }
}

