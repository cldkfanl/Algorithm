import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashSet<String> hash = new HashSet<>();
        int cnt = 0;
        for(int i=0; i<=input.length(); i++) {
        	for(int j=i; j<=input.length(); j++) {
        		String tmp = input.substring(i,j);
        		if(!hash.contains(tmp)) {
        			hash.add(tmp);
        			cnt ++;
        		}
        	}
        }
        System.out.println(hash.size()-1);
    }
}
