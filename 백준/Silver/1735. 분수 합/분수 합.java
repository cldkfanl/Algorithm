import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        int cmp1 = a * d + b * c;
        int cmp2 = b * d;
        int tmp = gcd(cmp1, cmp2);
        
        System.out.println(cmp1/tmp +" "+ cmp2/tmp );
    }
    static int gcd(int fir, int sec) {
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
    	return fir;
    }
}
