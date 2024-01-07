import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int arr[] = new int[a];
        int plus[] = new int[a];
        int minus[] = new int[a];
        int output[] = new int[a];
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<a; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	plus[i] = minus[i] = 1;
        }
        for(int i=1; i<a; i++) {
        	for(int j=0; j<=i-1; j++) {
        		if(arr[i] > arr[j]) {
        			plus[i] = Math.max(plus[i], plus[j]+1);
        		}
        	}
        }
        for(int i=a-2; i>=0; i--) {
        	for(int j=a-1; j>=i+1; j--) {
        		if(arr[i] > arr[j]) {
        			minus[i] = Math.max(minus[j]+1, minus[i]);
        		}
        	}
        }
        for(int i=0; i<a; i++) {
        	output[i] = plus[i] + minus[i];
        }
        Arrays.sort(output);
        System.out.println(output[a-1]-1);
    }
}

