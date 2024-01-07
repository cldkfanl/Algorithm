import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> min = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<N; i++) {
        	int num = Integer.parseInt(br.readLine());
        	if(num == 0) {
        		if(!min.isEmpty()) {
        			System.out.println(min.poll());
        		}
        		else {
        			System.out.println(0);
        		}
        	}
        	else {
        		min.add(num);
        	}
        }
    }
}
