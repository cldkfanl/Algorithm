import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt[] = new int[N];
        Arrays.fill(cnt, 1);
        int max = 0;
        for(int i=1; i<N; i++) {
        	for(int j=0; j<i; j++) {
        		if(arr[i] > arr[j]) {
        			cnt[i] = Math.max(cnt[i], cnt[j] + 1);
        		}
        	}
        	max = Math.max(max, cnt[i]);
        }
        System.out.println(max);
	}
}
