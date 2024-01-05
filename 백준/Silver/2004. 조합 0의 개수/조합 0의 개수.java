import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        if((a-b) < b) {
        	b = a-b;
        }
        if(b == 0) {
        	System.out.println(0);
        }
        else {
        	int twoCount = countNum(a,2)- countNum(a-b, 2) - countNum(b,2);
        	int fiveCount = countNum(a,5)- countNum(a-b, 5) - countNum(b,5);
        	System.out.println(Math.min(twoCount, fiveCount));
        }
    }
    public static int countNum(long x, int number) {
    	int count = 0;
    	while(x >= number) {
    		count += x/number;
    		x /= number;
    	}
    	return count;
    }
}