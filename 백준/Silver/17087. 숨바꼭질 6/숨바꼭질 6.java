import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        long arr[] = new long[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
        	long ai = Integer.parseInt(st1.nextToken());
        	arr[i] = Math.abs(s-ai);
        }
        Arrays.sort(arr);
        long output = arr[0];
        for(int i=1; i<n; i++) {
        	output = gcd(output, arr[i]);
        }
        System.out.println(output);
    }
}