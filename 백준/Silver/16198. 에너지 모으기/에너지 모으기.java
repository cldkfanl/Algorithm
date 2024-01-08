import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static boolean flag[];
	static int max = Integer.MIN_VALUE;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        flag = new boolean[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        energe(0,0);
        System.out.println(max);
	}
	static void energe(int depth, int num) {
		if(depth == N-2) {
			max = Math.max(num, max);
			return;
		}
		
		for(int i=1; i<N-1; i++) {
			if(!flag[i]) {
				flag[i] = true;
				int pre = 0;
				int next = 0;
				for(int j=i-1; j>=0; j--) {
					if(!flag[j]) {
						pre = arr[j];
						break;
					}
				}
				for(int j=i+1; j<N; j++) {
					if(!flag[j]) {
						next = arr[j];
						break;
					}
				}
				energe(depth+1, num + pre*next);
				flag[i] = false;
			}
		}
	}
}
