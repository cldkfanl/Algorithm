import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
        String str[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(int i = 0; i< str.length; i++){
            if(word.contains(str[i])){
                word = word.replace(str[i], "!");
            }
        }
        System.out.println(word.length());
	}
}