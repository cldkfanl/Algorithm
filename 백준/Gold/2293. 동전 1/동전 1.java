import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        long coin[] = new long[k+1];
        coin[0] = 1;
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	for(int j=arr[i]; j<= k; j++) {
        		coin[j] += coin[j-arr[i]];
        	}
        }
        System.out.println(coin[k]);

	}
}
