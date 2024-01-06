import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine()) != null) {
            long comp = 1;
            int count = 1;
        	int input = Integer.parseInt(s);
        	while((comp = comp % input )!= 0) {
        		comp = comp *10 + 1;
        		count++;
        	}
        	System.out.println(count);
        }
	}
}
