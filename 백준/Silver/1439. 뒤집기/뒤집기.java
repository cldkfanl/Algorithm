import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int fcnt = 1;
        int scnt = 0;
        int state = 1;
        for(int i=1; i<input.length(); i++) {
        	int f = Integer.parseInt(input.substring(i-1,i));
        	int s = Integer.parseInt(input.substring(i , i+1));
        	if(f != s) {
        		if(state == 1) {
        			scnt++;
        			state = 0;
        		}
        		else {
        			fcnt++;
        			state = 1;
        		}
        	}
        }
        System.out.println(Math.min(fcnt, scnt));
	}
}
