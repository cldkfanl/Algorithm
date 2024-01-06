import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MAX = 1000000;
        boolean[] trueFalse = new boolean[MAX + 1];
        
        Arrays.fill(trueFalse, true);
        trueFalse[0] = trueFalse[1] = false;
        for(int i=2; i*i<=MAX; i++) {
        	if(trueFalse[i]) {
        		for(int j=i*i; j<=MAX; j+=i) {
        			trueFalse[j] = false;
        		}
        	}
        }
        while(true) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0) {
            	break;
            }
            else {
            	testGold(a, trueFalse);
            }
        }
	}
	public static void testGold(int x, boolean[] trueFalse) {
		for(int i=2; i<=x/2; i++) {
			if(trueFalse[i] && trueFalse[x-i]) {
				System.out.println(x + " = " + i + " + " + (x-i));
				return;
			}
		}
		System.out.println("Goldbach's conjecture is wrong.");
	}
}
