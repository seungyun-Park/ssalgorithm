package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class bj1181 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        List<String> words = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            if(!words.contains(str)) {  // 중복 단어 제거
                words.add(str);
            }
        }
        
        br.close();
        
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
            	
                if(s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                
                return s1.compareTo(s2);
            }
        });
        
        for(String word : words) {
            System.out.println(word);
        }
    }
	
}