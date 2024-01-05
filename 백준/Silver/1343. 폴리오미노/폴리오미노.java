import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String replaceinput = input.replace("XXXX", "AAAA").replaceAll("XX", "BB");
        
        boolean check = true;
        for(int i=0; i<replaceinput.length(); i++) {
        	if(replaceinput.charAt(i) == 'X') {
        		System.out.println(-1);
        		check = false;
        		break;
        	}
        }
        if(check) {
            System.out.println(replaceinput);
        }
    }
}
