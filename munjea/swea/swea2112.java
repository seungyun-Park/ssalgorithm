package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2112 {
	
	static int D;
	static int W;
	static int K;
    static int min;
    static int[][] film;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		//T만큼 루프
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			min = D;
			
			for (int j = 0; j < D; j++) {
				st = new StringTokenizer(br.readLine());
				int k = 0;
				while(st.hasMoreTokens()) {
					film[j][k] = Integer.parseInt(st.nextToken());
					k++;
				}
			}
			
			if (check(film)) {
                min = 0;
            } else {
                dfs(0, 0);
            }

            System.out.println("#" + i + " " + min);
			
		}
	}
	
	public static void dfs(int depth, int count) {
        // 현재 최소값보다 많은 약품을 사용했다면 중단
        if (count >= min) return;
        
        // 모든 행을 다 처리했다면 검사
        if (depth == D) {
            if (check(film)) {
                min = Math.min(min, count);
            }
            return;
        }
        
        // 현재 행에 약품을 넣지 않는 경우
        dfs(depth + 1, count);
        
        // 현재 행의 상태 저장
        int[] temp = film[depth].clone();
        
        // A약품 투입
        for (int j = 0; j < W; j++) {
            film[depth][j] = 0;
        }
        dfs(depth + 1, count + 1);
        
        // B약품 투입
        for (int j = 0; j < W; j++) {
            film[depth][j] = 1;
        }
        dfs(depth + 1, count + 1);
        
        // 원래 상태로 복구
        film[depth] = temp;
    }
	
	
	public static boolean check(int[][] arr) {
        for (int j = 0; j < W; j++) {
            boolean pass = false;
            for (int i = 0; i <= D - K; i++) {
                int count = 1;
                for (int k = i + 1; k < i + K; k++) {
                    if (arr[k][j] == arr[k-1][j]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count >= K) {
                    pass = true;
                    break;
                }
            }
            if (!pass) return false;
        }
        return true;
    }
}
