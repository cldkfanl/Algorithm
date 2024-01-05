import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int sum = 0;
        for(int i=0; i<N; i++) {
        	sum = arr[i];
        	if(sum == M) {
        		count++;
        		continue;
        	}
        	else {
        		for(int j=i+1; j<N; j++) {
        			sum += arr[j];
        			if(sum == M) {
        				count++;
        				continue;
        			}
        			else if(sum > M) {
        				continue;
        			}
        		}
        	}
        }
        System.out.println(count);
	}
}
