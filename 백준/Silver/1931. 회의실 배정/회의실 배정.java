import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
	static class Node{
		int x, start, end, count;
		Node(int x, int start, int end, int count){
			this.x = x;
			this.start = start;
			this.end = end;
			this.count = count;
		}
	}
	static int N;
	static int arr[][];
	static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            arr[i][0] = fir;
            arr[i][1] = sec;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
 
		});
        check();
        System.out.println(max);
    }
    static void check() {
    	int prev_end_time = 0;
    	for(int i=0; i<N; i++) {
    		if(prev_end_time <= arr[i][0]) {
    			prev_end_time = arr[i][1];
    			max++;
    		}
    	}
    }
}
