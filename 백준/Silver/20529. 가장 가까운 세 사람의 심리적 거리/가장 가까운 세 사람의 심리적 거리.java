import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0 ) {
        	int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if(N >= 33) {
            	System.out.println(0);
            }
            else {
            	String MBTI[] = new String[N];
                for(int i=0; i<N; i++) {
                	MBTI[i] = st.nextToken();
                }
            	int output = Integer.MAX_VALUE;
            	for(int j=0; j<N; j++) {
            		for(int k=j+1; k<N; k++) {
            			for(int l= k+1; l<N; l++) {
                            int len = 0;
            				for(int m=0; m<4; m++) {
            					if(MBTI[j].charAt(m) != MBTI[k].charAt(m)) {
            						len ++;
            					}
            					if(MBTI[j].charAt(m) != MBTI[l].charAt(m)) {
            						len ++;
            					}
            					if(MBTI[l].charAt(m) != MBTI[k].charAt(m)) {
            						len ++;
            					}
            				}
                            output = Math.min(output, len);
            			}
            		}

            	}
                System.out.println(output);
            }
        }
    }
}