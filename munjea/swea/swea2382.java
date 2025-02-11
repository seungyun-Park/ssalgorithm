package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Micro {
    int count, direction;

    Micro(int count, int direction) {
        this.count = count;
        this.direction = direction;
    }
}

public class swea2382 {
    public static void main(String[] args) throws IOException {
        int[] dx = {0, 0, 0, -1, 1}; // 좌우
        int[] dy = {0, -1, 1, 0, 0}; // 상하
        int[] reverseDir = {0, 2, 1, 4, 3}; // 방향 반전
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 
        
        // T만큼 루프
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<int[]> micros = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                
                micros.add(new int[]{x, y, count, dir});
            }

            // M은 시간
            for (int time = 0; time < M; time++) {
                Micro[][] grid = new Micro[N][N];
                int[][] maxCount = new int[N][N];

                for (int[] m : micros) {
                    int x = m[0] + dx[m[3]];
                    int y = m[1] + dy[m[3]];
                    int count = m[2];
                    int dir = m[3];

                    // 가생이 도착하면
                    if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
                        count /= 2;
                        dir = reverseDir[dir]; // 방향 바꿈
                    }

                    if (count > 0) { // 살아남은 경우에
                        if (grid[x][y] == null) { //gird에 미생물이 있으면
                            grid[x][y] = new Micro(count, dir);
                            maxCount[x][y] = count;
                        } else { //없으면
                            grid[x][y].count += count; // 일단 더하고
                            if (count > maxCount[x][y]) { //maxCount 갱신하기
                                maxCount[x][y] = count;
                                grid[x][y].direction = dir; //조건 만족했을 때(더 큰거 들어왔을때) 방향을 그 미생물의 방향으로 설정한다
                            }
                        }
                    }
                }

                //들어가는 순서는 상관없다고 판단
                micros.clear();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (grid[i][j] != null) {
                            micros.add(new int[]{i, j, grid[i][j].count, grid[i][j].direction});
                        }
                    }
                }
            }

            //총 미생물 수
            int result = 0;
            for(int[] m : micros)
            	result += m[2];

            System.out.println("#" + t + " " + result);
        }
    }
}

