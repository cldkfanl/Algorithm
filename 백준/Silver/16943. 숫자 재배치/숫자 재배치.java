import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean flag[];
	static int arr[];
	static int B;
	static int cmp = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        B = Integer.parseInt(st.nextToken());
        arr = new int[A.length()];
        flag = new boolean[A.length()];
        for(int i=0; i<A.length(); i++) {
        	arr[i] = A.charAt(i) - '0';
        }
        dfs(0,"");
        if(cmp == Integer.MIN_VALUE) {
        	System.out.println(-1);
        }
        else {
            System.out.println(cmp);
        }
	}
	static void dfs(int depth , String check) {
		if(depth == arr.length && !check.startsWith("0")) {
			int check2 = Integer.parseInt(check);
			if(check2 < B) {
				cmp = Math.max(check2, cmp);
			}
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!flag[i]) {
				flag[i] = true;
				dfs(depth + 1 , check  + arr[i]);
				flag[i] = false;
			}
		}
	}
}
