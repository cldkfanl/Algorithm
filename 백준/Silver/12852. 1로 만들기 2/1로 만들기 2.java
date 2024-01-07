import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[1000001];
        for(int i=0; i<=1000000; i++) {
        	arr[i] = Integer.MAX_VALUE;
        }
        arr[1] = 0;
        int trace[] = new int[1000001];
        trace[1] = -1;
        for(int i=2; i<=1000000; i++) {
        	arr[i] = arr[i - 1] + 1;
        	trace[i] = i - 1;

			if(i % 2 == 0 && arr[i] > arr[i / 2] + 1) {
				arr[i] = arr[i / 2] + 1;
				trace[i] = i / 2;
			}
			if(i % 3 == 0 && arr[i] > arr[i / 3] + 1) {
				arr[i] = arr[i / 3] + 1;
				trace[i] = i / 3;
			}
        }
        System.out.println(arr[N]);
        for (int i = N; i > 0; i = trace[i]) {
            System.out.print(i + " ");
        }
	} 
}
