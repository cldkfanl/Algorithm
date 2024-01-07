import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static int arr2[];
	static int arr3[];
	static int N;
	static int sum;
	static long max = Integer.MIN_VALUE;
	static long min = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        arr2 = new int[4];
        arr3 = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        sum = arr[0];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++) {
        	arr2[i] = Integer.parseInt(st.nextToken());
        }
        arr2case(0);
        System.out.println(max);
        System.out.println(min);
	}
	static void arr2case(int depth) {
		if(depth == N-1) {
			for(int i=0; i<N-1; i++) {
				calcul(i, arr3[i]);
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			sum = arr[0];
			return;
		}
		for(int i=0; i<4; i++) {
			if(arr2[i] > 0) {
				arr2[i] --;
				arr3[depth] = i;
				arr2case(depth+1);
				arr2[i] ++;
			}
		}
	}
	static void calcul(int count, int i) {
		switch(i) {
		case 0 : sum += arr[count+1]; break;
		case 1 : sum -= arr[count+1]; break;
		case 2 : sum *= arr[count+1]; break;
		case 3 : sum /= arr[count+1]; break;
		}
	}
}
