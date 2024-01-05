import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	int arr[][] = new int[4][2];
        	for(int j=0; j<4; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                arr[j][0] = f;
                arr[j][1] = s;
        	}
        	double len[] = new double[6];
        	boolean state = true;
        	int cnt = 0;
        	for(int j=0; j<4; j++) {
            	for(int k=j+1; k<4; k++) {
            		double checkLen = Math.pow(Math.abs(arr[j][0] - arr[k][0]) + Math.abs(arr[j][1] - arr[k][1]), 2);
            		len[cnt] = checkLen;
            		cnt++;
            	}
        	}
        	Arrays.sort(len);
        	if(len[0] != len[1] || len[1] != len[2] || len[2] != len[3] || len[0] != len [3]) {
        		state = false;
        	}
        	if(len[5] != len[4]) {
        		state = false;
        	}
        	
        	if(!state) {
        		sb.append(0).append("\n");
        	}
        	else {
        		sb.append(1).append("\n");
        	}
        }
        System.out.println(sb);
	}
}
