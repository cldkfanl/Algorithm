import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String first[] = input.split("-");
        int output = Integer.MAX_VALUE;
        for(int i=0; i<first.length; i++) {
        	int tmp = 0;
        	String sec[] = first[i].split("\\+");
        	for(int j=0; j<sec.length; j++) {
        		tmp += Integer.parseInt(sec[j]);
        	}
        	
        	if(output == Integer.MAX_VALUE) {
        		output = tmp;
        	}
        	else {
        		output -= tmp;
        	}
        }
        System.out.println(output);
        
    }
}
