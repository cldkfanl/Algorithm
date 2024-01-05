import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long input = Long.parseLong(br.readLine());
        long cnt = 0;
        long sum = 0;
        for(int i=1; ; i++) {
        	if(sum > input) {
        		break;
        	}
        	sum += i;
        	cnt ++;
        }
        System.out.println(cnt-1);
	}
}
