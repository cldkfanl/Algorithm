import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int arrmin[][] = new int[N+1][3];
        int arrmax[][] = new int[N+1][3];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int fir = Integer.parseInt(st.nextToken());
        	int sec = Integer.parseInt(st.nextToken());
        	int thr = Integer.parseInt(st.nextToken());
        	arrmin[i][0] = Math.min(arrmin[i-1][0], arrmin[i-1][1]) + fir;
        	arrmin[i][1] = Math.min(arrmin[i-1][0], Math.min(arrmin[i-1][1], arrmin[i-1][2])) + sec;
        	arrmin[i][2] = Math.min(arrmin[i-1][1], arrmin[i-1][2]) + thr;
        	
        	arrmax[i][0] = Math.max(arrmax[i-1][0], arrmax[i-1][1]) + fir;
        	arrmax[i][1] = Math.max(arrmax[i-1][0], Math.max(arrmax[i-1][1], arrmax[i-1][2])) + sec;
        	arrmax[i][2] = Math.max(arrmax[i-1][1], arrmax[i-1][2]) + thr;
        }
        int outMin = Math.min(arrmin[N][0], Math.min(arrmin[N][1], arrmin[N][2]));
        int outMax = Math.max(arrmax[N][0], Math.max(arrmax[N][1], arrmax[N][2]));
        System.out.println(outMax + " " + outMin);
    }
}
