import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[M];
        int arr6[] = new int[M];
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr6[i] = a;
        	arr[i] = b;
        }
        Arrays.sort(arr);
        Arrays.sort(arr6);
        int output = 0;
        while(N > 0) {
        	if(N >= 6) {
        		if(arr[0] * 6 < arr6[0]) {
        			output += arr[0] * 6;
        		}
        		else {
        			output += arr6[0];
        		}
        	}
        	else {
        		if(arr[0] * N < arr6[0]) {
        			output += arr[0] * N;
        		}
        		else {
        			output += arr6[0];
        		}
        	}
        	N -= 6;
        }
        System.out.println(output);
	}
}
