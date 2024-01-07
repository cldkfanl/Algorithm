import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static boolean check[] = new boolean[2000001];
	static int S;
	static int count = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[S];
        for(int i=0; i<S; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        check(0,0);
        for(int i=0; i<2000000; i++) {
        	if(!check[i]) {
        		System.out.println(i);
        		break;
        	}
        }
	}
	public static void check(int depth, int num) {
		if(depth == S) {
			check[num] = true;;
			return;
		}
		
		check(depth+1, num+arr[depth]);
		check(depth+1, num);
	}
}
