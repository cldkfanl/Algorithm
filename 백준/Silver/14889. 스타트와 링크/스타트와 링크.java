import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int count;
	public static StringBuilder sb = new StringBuilder();
	public static int score_min = Integer.MAX_VALUE;
	public static int score[][];
	public static boolean flag[];
	public static boolean flag_2[];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());
        score = new int[count][count];
        flag = new boolean[count];
        flag_2 = new boolean[count];
        for(int i=0; i<count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<count; j++) {
            	score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        asdf(0, 0);
        System.out.println(score_min);
        System.out.println(sb);


	}
	public static void asdf(int depth, int start) {
		if(depth == count/2) {

			int score_true = 0;
			int score_false = 0;
			for(int i=0; i<count; i++) {
				for(int j=i+1; j<count; j++) {
					if(!flag_2[i] && !flag_2[j] && i != j) {
						score_false += score[i][j] + score[j][i];
					}
					if(flag_2[i] && flag_2[j] && i != j) {
						score_true += score[i][j] + score[j][i];
					}
				}
			}
			score_min = Math.min(Math.abs(score_false -score_true),score_min);
			return;
		}
		
		for(int i=start; i<count; i++) {
			if(!flag_2[i]) {
				flag_2[i] = true;
				asdf(depth+1, start);
				start ++;
				flag_2[i] = false;
			}
		}
	}
}
