package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

enum State { INACTIVE, ACTIVE, DEAD }

class Cell implements Comparable<Cell> {
    
    int x, y;
    int life;
    int inactiveTime;
    int activeTime;
    State state;
    
    public Cell(int x, int y, int life) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.inactiveTime = life;
        this.activeTime = life;
        this.state = State.INACTIVE;
    }
    
    public void go() {
        if (state == State.INACTIVE) {
            inactiveTime--;
            if (inactiveTime == 0) {
                state = State.ACTIVE;
            }
        } else if (state == State.ACTIVE) {
            activeTime--;
        }
    }
    
    public boolean isAlive() {
        return state != State.DEAD;
    }
    
    public boolean canSpread() {
        return state == State.ACTIVE && activeTime == life - 1;
    }
    
    public int compareTo(Cell other) {
        return Integer.compare(other.life, this.life);
    }
    
}

public class swea5653 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int xSize = N + K * 2;
            int ySize = M + K * 2;
            Cell[][] grid = new Cell[xSize][ySize];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int life = Integer.parseInt(st.nextToken());
                    if (life > 0) {
                        grid[i + K][j + K] = new Cell(i + K, j + K, life);
                    }
                }
            }
            
            // K시간 시뮬레이션
            for (int time = 0; time < K; time++) {
                List<Cell> activeCells = new ArrayList<>();
                
                for (int i = 0; i < xSize; i++) {
                    for (int j = 0; j < ySize; j++) {
                        if (grid[i][j] != null && grid[i][j].isAlive()) {
                            activeCells.add(grid[i][j]);
                        }
                    }
                }
                
                
                
                
                activeCells.sort(null);
                
                for (Cell cell : activeCells) {
                    cell.go();
                    if (cell.canSpread()) {
                    	//spread 가능할때 
                    	if(grid[cell.x][cell.y - 1] == null) {
	                    	grid[cell.x][cell.y - 1] = new Cell(cell.x, cell.y-1, cell.life);
                    	}
                    	if(grid[cell.x][cell.y + 1] == null) {
	                    	grid[cell.x][cell.y + 1] = new Cell(cell.x, cell.y+1, cell.life);
                    	}
                    	if(grid[cell.x-1][cell.y] == null) {
	                    	grid[cell.x - 1][cell.y] = new Cell(cell.x-1, cell.y, cell.life);
                    	}
                    	if(grid[cell.x+1][cell.y] == null) {
	                    	grid[cell.x + 1][cell.y] = new Cell(cell.x+1, cell.y, cell.life);
                    	}
                    }
                    
                    if(cell.activeTime == 0 && cell.isAlive()) {
                		cell.state = State.DEAD;
                	}
                }
            }
            
            // 출력 부분
            int count = 0;
            for (int i = 0; i < xSize; i++) {
                for (int j = 0; j < ySize; j++) {
                    if (grid[i][j] != null && grid[i][j].isAlive()) {
                    	count++;
                    }
                }
            }
            
            System.out.println("#" + t + " " + count);
        }
    }
}