import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int twoCount = 0;
        int fiveCount = 0;
        int output = 0;
        for(int i=1; i<=a; i++) {
        	int input = i;
        	while(input%2 == 0) {
        		input /= 2;
        		twoCount++;
        	}
        	while(input %5 == 0) {
        		input /=5;
        		fiveCount++;
        	}
        }
        if(twoCount > fiveCount) {
        	output = fiveCount;
        }
        else {
        	output = twoCount;
        }
        System.out.println(output);
	}
}