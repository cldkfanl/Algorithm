import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[6][2];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            arr[i][0] = dir;
            arr[i][1] = len;
        }
        int maxLen1 = 0;
        int maxLen2 = 0;
        for(int i=0; i<6; i++) {
        	if(arr[i][0] == 1 || arr[i][0] == 2) {
        		maxLen1 = Math.max(maxLen1, arr[i][1]);
        	}
        	if(arr[i][0] == 3 || arr[i][0] == 4) {
        		maxLen2 = Math.max(maxLen2, arr[i][1]);
        	}
        }
        int minLen1 = 0;
        int minLen2 = 0;
        for(int i=0; i<6; i++) {
        	if(arr[i][1] == maxLen1 && (arr[i][0] == 1 || arr[i][0] == 2)) {
        		if(i == 0) {
        			minLen1 = Math.abs(arr[i+1][1] - arr[5][1]);
        		}
        		else if(i == 5) {
            		minLen1 = Math.abs(arr[i-1][1] - arr[0][1]);
        		}
        		else {
            		minLen1 = Math.abs(arr[i-1][1] - arr[i+1][1]);
        		}
        	}
        	if(arr[i][1] == maxLen2 && (arr[i][0] == 3 || arr[i][0] == 4)) {
        		if(i == 0) {
        			minLen2 = Math.abs(arr[i+1][1] - arr[5][1]);
        		}
        		else if(i == 5) {
            		minLen2 = Math.abs(arr[i-1][1] - arr[0][1]);
        		}
        		else {
            		minLen2 = Math.abs(arr[i-1][1] - arr[i+1][1]);
        		}
        	}
        }
        int size = maxLen1 * maxLen2 - minLen1 * minLen2;
        System.out.println(size * N);
    }
}
