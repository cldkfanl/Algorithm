import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long arr[];
	static int N;
	static long check[];
	static boolean flag[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[N];
        check = new long[N];
        flag = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++) {
        	flag[i] = true;
        	check[0] = arr[i];
        	mkarr(arr[i],1);
        	flag[i] = false;
        }
        

	}
	static void mkarr(long pre , int depth) {
		if(depth == N) {
			for(int i=0; i<N; i++) {
				sb.append(check[i]).append(" ");
			}
	        System.out.println(sb);
			System.exit(0);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!flag[i] && pre * 2 == arr[i] || (pre % 3 == 0 && pre /3 == arr[i])) {
				flag[i] = true;
				check[depth] = arr[i];
				mkarr(arr[i], depth+1);
				flag[i] = false;
			}
		}
	}
}
