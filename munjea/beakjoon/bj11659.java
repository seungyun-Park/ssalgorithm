package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11659 {
    
    public static int[] calculateSum(int[] numbers, int[][] queries) {
        int N = numbers.length;
        int[] prefix = new int[N];
        
        prefix[0] = numbers[0];
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }
        
        int M = queries.length;
        int[] results = new int[M];
        
        for (int k = 0; k < M; k++) {
            int i = queries[k][0];
            int j = queries[k][1];
            results[k] = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
        }
        
        return results;
    }
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] queries = new int[M][2];
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            
            queries[k][0] = Integer.parseInt(st.nextToken()) - 1;
            queries[k][1] = Integer.parseInt(st.nextToken()) - 1;
        }
        
        int[] results = calculateSum(numbers, queries);
        for (int result : results) {
            System.out.println(result);
        }
    }
}