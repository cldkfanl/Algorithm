import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int cmp = Integer.parseInt(br.readLine());
        int cnt = 0;
        int left = 0;
        int right = arr.length-1;
        int answer = 0;
        Arrays.sort(arr);
        while(left <  right) {
        	answer = arr[left] + arr[right];
        	if(answer == cmp) {
        		cnt ++;
        	}
        	if(answer <= cmp) {
        		left ++;
        	}
        	else {
        		right --;
        	}
        }
        System.out.println(cnt);
    }
}
