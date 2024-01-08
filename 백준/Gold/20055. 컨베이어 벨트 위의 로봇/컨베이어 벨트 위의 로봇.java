import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean flag[];
	static int arr[];
	static int N;
	static int K;
	static int zero = 0;
	static int robotnum = 0;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        flag = new boolean[N*2];
        arr = new int[N*2];
        for(int i=0; i<2*N; i++) {
        	arr[i] = Integer.parseInt(st2.nextToken());
        }
        int count = 0;
        while(zero < K) {
        	spin();
        	robotmove();
        	robotup();
        	robotplus();
        	zerocheck();
        	count++;
        }
        System.out.println(count);
	}
	public static void robotplus() {
		if(arr[0] != 0 && !flag[0]) {
			arr[0] --;
			flag[0] = true;
		}
	}
	public static void zerocheck() {
		int count = 0;
		for(int i=0; i<2*N; i++) {
			if(arr[i] == 0) {
				count ++;
			}
		}
		zero = count;
	}
	public static void robotup() {
		if(arr[0] != 0 && !flag[0]) {
			flag[0] = true;
			arr[0] --;
		}
	}
	public static void spin() {
		int temp = arr[2*N-1];
		boolean temp2 = flag[2*N-1];
		for(int i=N*2-1; i>0; i--) {
			arr[i] = arr[i-1];
			flag[i] = flag[i-1];
		}
		if(flag[N-1]) {
			flag[N-1] = false;
		}
		arr[0] = temp;
		flag[0] = temp2;
	}
	public static void robotmove() {
		for(int i=robotnum; i>=0; i--) {
			if(flag[i]) {
				if(!flag[i+1] && arr[i+1] != 0) {
					flag[i+1] = true;
					flag[i] = false;
					arr[i+1] --;
				}
			}
		}
		if(flag[2*N-1]) {
			if(!flag[0] && arr[0] != 0) {
				flag[0] = true;
				flag[2*N-1] = false;
				arr[0] --;
			}
		}
		for(int i=2*N-2; i>robotnum; i--) {
			if(flag[i]) {
				if(!flag[i+1] && arr[i+1] != 0) {
					flag[i+1] = true;
					flag[i] = false;
					arr[i+1] --;
				}
			}
		}
		if(flag[N-1]) {
			flag[N-1] = false;
		}
	}
}
