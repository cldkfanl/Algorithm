import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int arr[];
	static int output = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        bfs(N);
        System.out.println(output);
	}
	static void bfs(int num) {
		 Queue<Integer> queue = new LinkedList<Integer>();
		 queue.add(num);
		 int index = num;
		 int n = 0;
		 arr[index] = 1;
		 while(queue.isEmpty() == false) {
			 n = queue.remove();
			 if(n == K) {
				 output = arr[n]-1;
			 }
			 if(n-1>=0 && arr[n-1] == 0) {
				 arr[n-1] = arr[n] + 1;
				 queue.add(n-1);
			 }
			 if(n+1<=100000 && arr[n+1] == 0) {
				 arr[n+1] = arr[n] + 1;
				 queue.add(n+1);
			 }
			 if(n*2<=100000 && arr[n*2] == 0) {
				 arr[n*2] = arr[n]+1;
				 queue.add(n*2);
			 }
		 }
	}
}
