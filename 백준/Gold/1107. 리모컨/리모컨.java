import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count_num = Integer.MAX_VALUE;
	static boolean flag[];
	static int number;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        flag = new boolean[10];
        number = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        if(count != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<count; i++) {
            	int input = Integer.parseInt(st.nextToken());
            	for(int j=0; j<10; j++) {
            		if(input == j) {
            			flag[j] = true;
            		}
            	}
            }
        }
        comp_2(number);
        System.out.println(count_num);
	}

	public static void comp_2(int comp) {
		int comp_min = Integer.MAX_VALUE;
		String a = "";
		int stringlen = 0;
		for(int i=0; i<=1000000; i++) {
			a += i;
			int count = 0;
			for(int j=0; j<a.length(); j++) {
				int asdf = Integer.parseInt(a.substring(j,j+1));
				if(flag[asdf] == true) {
					count ++;
				}
			}
			if(count == 0) {
				if(comp_min > Math.abs(i-comp)) {
					stringlen = a.length();
				}
				comp_min = Math.min(comp_min, Math.abs(i-comp));
			}
			count = 0;
			a = "";
		}
		comp_count(comp_min, stringlen);
	}
	public static void comp_count(int comp_min , int stringlen) {
		count_num = Math.min(Math.abs(number - 100), comp_min + stringlen);
	}
}
