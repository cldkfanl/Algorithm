import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,B;
	static int arr[][];
	static int time = Integer.MAX_VALUE;
	static int height = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		min = Math.min(min, arr[i][j]);
        		max = Math.max(max, arr[i][j]);
        	}
        }
        for(int i=min; i<=max; i++) {
        	dfs(i);
        }
        System.out.println(time + " " + height);
    }
    static void dfs(int num) {
    	int tmptime = 0;
    	int block = 0;
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(arr[i][j] > num) {
    				tmptime += (arr[i][j] - num) * 2;
    				block += arr[i][j] - num;
    			}
    			else if(arr[i][j] < num) {
    				tmptime += (num - arr[i][j]);
    				block -= num - arr[i][j];
    			}
    		}
    	}
    	if(B + block >=0) {
    		time = Math.min(time, tmptime);
    		if(time == tmptime) {
    			height = Math.max(num, height);
    		}
    	}
    }
}
