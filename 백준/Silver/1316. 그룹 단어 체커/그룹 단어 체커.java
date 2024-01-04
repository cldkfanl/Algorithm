import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        int word_count = sc.nextInt();
        int group = 0;
        for(int i=0; i<word_count; i++){
            boolean check = true;
            String word = sc.next();            //입력값
            int arr[] = new int[26];
            for(int j=0; j<26; j++){            //문자 저장할 배열 생성
                arr[j] = 0;
            }
            for(int k=0; k<word.length()-1; k++){    //입력값 한자리수 씩 검사
                arr[word.charAt(k)-97]++;     
                if(word.charAt(k) != word.charAt(k+1)){  //앞 글자와 뒷 글자가 다를 때
                    if(arr[word.charAt(k+1)-97] != 0){   //뒷 글자가 이전에 나왔던 글자면(연속된 글자가 아니면)
                        check = false;                   //check를 false로 변경
                    }
                }
            }
            if(check){                                   //check가 true인 경우에만
                group ++;                                //횟수 세기
            }
        }
        System.out.print(group);                         //횟수 출력
	}
}