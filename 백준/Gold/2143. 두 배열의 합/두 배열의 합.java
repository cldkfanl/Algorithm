import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int T,n,m;
	static int arr[];
	static int arr2[];
	static long count = 0;
	static long sum = 0;
	static ArrayList<Long> bsum, asum;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
        	arr2[i] = Integer.parseInt(st.nextToken());
        }
	    asum = new ArrayList<>();
	    bsum = new ArrayList<>();
        for(int i=0; i<n; i++) {
        	long sum2 = 0;
        	for(int j=i; j<n; j++) {
        		sum2 += arr[j];
        		asum.add(sum2);
        	}
        }
        for(int i=0; i<m; i++) {
        	long sum2 = 0;
        	for(int j=i; j<m; j++) {
        		sum2 += arr2[j];
        		bsum.add(sum2);
        	}
        }
        Collections.sort(asum);
        Collections.sort(bsum);
        check();
        System.out.println(count);

	}

	static void check() {
		int pa = 0;
		int pb = bsum.size()-1;
		long eqcnt = 0;
		while(pa < asum.size() && pb >= 0) {
			long sum = asum.get(pa) + bsum.get(pb);
			if(sum == T) {
				long a = asum.get(pa);
				long b = bsum.get(pb);
				long cnta = 0;
				long cntb = 0;
				while(pa <asum.size() && asum.get(pa) == a) {
					cnta ++;
					pa ++;
				}
				while(pb >= 0 && bsum.get(pb) == b) {
					cntb++;
					pb--;
				}
				eqcnt += cnta * cntb;
			}
			else if(sum > T) pb --;
			else if(sum < T) pa ++;
		}
		count = eqcnt;
	}
}
 