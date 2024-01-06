import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for(int i = 0; i<input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
   			int m = Integer.parseInt(st.nextToken());
   			int n = Integer.parseInt(st.nextToken());
   			int x = Integer.parseInt(st.nextToken());
   			int y = Integer.parseInt(st.nextToken());
   			int gcd2 = m*n/gcd(m,n);
   			int n2 = 0;
   			int ans = -1;
   			while(n2*m < gcd2) {
                if ((n2 * m + x - y) % n == 0) {
                    ans = n2 * m + x;
                    break;
                }
                n2++;
   			}
   			System.out.println(ans);
        }
	}
    static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }
}