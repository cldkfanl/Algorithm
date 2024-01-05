import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char dna[] = {'A', 'C', 'G', 'T'};
	static String output = "";
	static String arr[];
	static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N];
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	arr[i] = input;
        }
        for(int i=0; i<M; i++) {
        	check(i);
        }
        System.out.println(output);
        int hd = 0;
        for(int i=0; i<M; i++) {
        	char cmp = output.charAt(i);
        	for(int j=0; j<N; j++) {
        		if(arr[j].charAt(i) != cmp) {
        			hd ++;
        		}
        	}
        }
        System.out.println(hd);
    }
    static void check(int i) {
        int checkarr[] = new int[4];

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < 4; k++) {
                if (dna[k] == arr[j].charAt(i)) {
                    checkarr[k]++;
                }
            }
        }
        int maxCount = -1;
        char mostFrequentBase = ' ';

        for (int k = 0; k < 4; k++) {
            if (checkarr[k] > maxCount) {
                maxCount = checkarr[k];
                mostFrequentBase = dna[k];
            }
        }
        output += mostFrequentBase;
    }
}
