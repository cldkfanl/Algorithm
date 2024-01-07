import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int arr[];
	static int N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int S = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	sb.append(pel(S,E)).append('\n');
        }
        System.out.println(sb);
	}
	static int pel(int s, int e) {
		int count = (e - s +1)/2;
		while(count -- > 0) {
			if(arr[s-1] != arr[e-1]) {
				return 0;
			}
			s++;
			e--;
		}
		return 1;
	}
}
