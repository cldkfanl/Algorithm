import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, K;
	static int arr[];
	static int arr2[];
	static int output = 0;
	static boolean found = false;
	static ArrayList<Integer> path = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        bfs(N);
        System.out.println(output);
        for(int i=path.size()-1 ; i>=0; i--) {
        	System.out.print(path.get(i) + " ");
        }
	}
	static void count(int start, int fin, int count) {
		if(start == fin) {
			if(!found) {
				for(int i=0; i<output; i++) {
					sb.append(arr2[i]).append(' ');
				}
				sb.append(K);
			}
			found= true;
			return;
		}
		for(int i=0; i<=K+1; i++) {
			if(i<=100000 && arr[i] == count) {
				if(i == fin-1 || i == fin+1 || i*2 == fin) {
					arr2[count-1] = i; 
					count(start, i, count-1);
				}
			}
		}
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
	        int current = K;
	        while (current != N) {
	            path.add(current);
	            if (current % 2 == 0 && arr[current / 2] == arr[current] - 1) {
	                current /= 2;
	            } else if (current - 1 >= 0 && arr[current - 1] == arr[current] - 1) {
	                current -= 1;
	            } else {
	                current += 1;
	            }
	        }
	        path.add(N);
	}
}
