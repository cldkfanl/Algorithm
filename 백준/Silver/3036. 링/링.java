import java.io.*;
import java.util.*;
public class Main {
	static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<N; i++) {
        	gcd(i,arr[0], arr[i]);
        }
    }
    static void gcd(int cnt, int fir, int sec) {
    	int tmp, n;
    	if(fir < sec) {
    		tmp = fir;
    		fir = sec;
    		sec = tmp;
    	}
    	
    	while(sec != 0) {
    		n = fir % sec;
    		fir = sec;
    		sec = n;
    	}
    	System.out.println(arr[0] / fir + "/" + arr[cnt] / fir);
    }
}
