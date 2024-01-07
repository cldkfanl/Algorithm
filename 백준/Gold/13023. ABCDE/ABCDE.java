import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int output = 0;
	static boolean flag[];
	static List<Integer>[] list;
	static int N,M;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];

        for(int i=0; i<N; i++) {
        	list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
        	StringTokenizer st_2 = new StringTokenizer(br.readLine());
        	int first = Integer.parseInt(st_2.nextToken());
        	int second = Integer.parseInt(st_2.nextToken());
        	list[first].add(second);
        	list[second].add(first);
        }
        for(int i=0; i<N; i++) {
        	flag = new boolean[N];
    		flag[i] = true;
            find(i,1);
            if(output == 1) {
            	break;
            }
        }
        System.out.println(output);
	}
	public static void find(int input, int count) {
		if(count == 5) {
			output = 1;
			return;
		}
		for(int next : list[input]) {
			if(!flag[next]) {
				flag[next] = true;
				find(next, count+1);
				flag[next] = false;
				if(output ==1) {
					return;
				}
			}
		}
	}
}

