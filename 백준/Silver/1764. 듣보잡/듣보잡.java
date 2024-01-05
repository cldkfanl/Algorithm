import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String arr[] = new String[N];
        String arr2[] = new String[M];
        HashSet<String> names = new HashSet<>();
        for (int i = 0; i < N; i++) {
            names.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            arr2[i] = br.readLine();
        }
        Arrays.sort(arr2);
        int count = 0;
        for (int j = 0; j < M; j++) {
            if (names.contains(arr2[j])){
                count++;
                sb.append(arr2[j]).append('\n');
                continue;
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
