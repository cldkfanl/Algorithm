import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int arr[];
	static long cnt;
	static ArrayList<Integer> leftList = new ArrayList<>();
	static ArrayList<Integer> rightList = new ArrayList<>();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        mkSum(0,0,N/2,leftList);
        mkSum(0,N/2,N,rightList);
        
        Collections.sort(leftList);
        Collections.sort(rightList);
        
        cnt = 0;
        cal();
        
        if(S == 0) {
        	System.out.println(cnt-1);
        }
        else {
        	System.out.println(cnt);
        }
	}
	
	static void cal() {
		int pointl = 0;
		int pointr = rightList.size() -1 ;
		
		while(true) {
			if(pointl == leftList.size() || pointr < 0) {
				break;
			}
			int lv = leftList.get(pointl);
			int rv = rightList.get(pointr);
			
			if(lv + rv == S) {
				long lc = 0;
				while(pointl < leftList.size() && leftList.get(pointl) == lv) {
					lc ++;
					pointl ++;
				}
				long rc = 0;
				while(pointr >= 0 && rightList.get(pointr) == rv) {
					rc++;
					pointr--;
				}
				cnt += lc * rc;
			}
			if(lv+rv > S) {
				pointr--;
			}
			if(lv+rv < S) {
				pointl++;
			}
		}
	}
	static void mkSum(int sum, int start, int end, ArrayList<Integer> list) {
		if(start == end) {
			list.add(sum);
			return;
		}
		mkSum(sum, start+1, end, list);
		mkSum(sum+arr[start] , start+1, end, list);
	}
}
