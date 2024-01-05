import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count[] = new int[26];
        for(int i=0; i<input.length(); i++) {
        	int tmp = input.charAt(i)-'A';
        	count[tmp]++;
        }
        int isOne = 0;
        for(int i=0; i<count.length; i++) {
        	if(count[i]%2 != 0) {
        		isOne++;
        	}
        }
        String output = "";
        StringBuilder sb = new StringBuilder();
        if(isOne > 1) {
        	output += "I'm Sorry Hansoo";
        }
        else {
        	for(int i=0; i<count.length; i++) {
        		for(int j=0; j<count[i]/2; j++) {
        			sb.append((char)(i+65));
        		}
        	}
        	output += sb.toString();
        	String end = sb.reverse().toString();
        	sb = new StringBuilder();
        	for(int i=0; i<count.length; i++) {
        		if(count[i]%2 == 1) {
        			sb.append((char)(i+65));
        		}
        	}
        	output += sb.toString() + end;
        }
        System.out.println(output);
    }
}
