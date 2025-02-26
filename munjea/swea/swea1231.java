package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node3 {
	int p = 0;
	int n;
	char ch;
	int left;
	int right;
	boolean visited = false;
	
	Node3(int n, char ch, int left, int right, int p){
		this.n = n;
		this.ch = ch;
		this.left = left;
		this.right = right;
		this.p = p;
	}
	
	public boolean hasParent() {
		if(p == -1)
			return false;
		return true;
	}
	
	public boolean hasRight() {
		if(right == -1)
			return false;
		return true;
	}
	
	public boolean hasLeft() {
		if(left == -1)
			return false;
		return true;
	}
}

public class swea1231 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Node3> tree = new ArrayList<>();
		
		for (int cs = 1; cs <= 1; cs++) {
			int N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				char ch = st.nextToken().charAt(0);
				int p = -1;
				
				for (int j = 0; j < tree.size(); j++) {
					if(tree.get(j).left == n || tree.get(j).right == n) {
						p = j + 1;
					}
				}
				
				if(!st.hasMoreTokens()) {
					tree.add(new Node3(n, ch, -1, -1, p));
					continue;
				}
				
				int left = Integer.parseInt(st.nextToken());
				
				if(!st.hasMoreTokens()) {
					tree.add(new Node3(n, ch, left, -1, p));
					continue;
				}
				
				int right = Integer.parseInt(st.nextToken());
				tree.add(new Node3(n, ch, left, right, p));
			}
			
			
			String result = "";
			int index = (int)Math.pow(2, Math.floor(baseLog(N, 2))) - 1;
			
			while(result.length() != N) {
				
				if(tree.get(index).visited == true) {
					//부모가 visited이면
					if(tree.get(tree.get(index).p).visited == true) {
						index = tree.get(index).right;
					}
					//아니면 부모로
					else {
						index = tree.get(index).p;
						continue;
					}
				}
				
				//문자열저장
				result += tree.get(index).ch;
				//방문처리
				tree.get(index).visited = true;
				

				System.out.println("index : " + index);
				System.out.println("result : " + result);
				System.out.println(tree.get(index).hasLeft());
				System.out.println(tree.get(index).left);
				if(tree.get(index).hasLeft() && tree.get(tree.get(index).left - 1).visited == false) {
					index = tree.get(index).left - 1;
					System.out.println("left");
					System.out.println();
					continue;
				}

				if(tree.get(index).hasRight() && tree.get(tree.get(index).right - 1).visited == false) {
					index = tree.get(index).right - 1;
					System.out.println("right");
					System.out.println();
					continue;
				}

				if(tree.get(index).hasParent()) {
					index = tree.get(index).p - 1;
					System.out.println("parent");
					System.out.println();
					continue;
				}
				
			}
			
			
			System.out.println("#" + cs + " " + result);
		}
	}
	
	
	
	
	static double baseLog(double x, double base) {return Math.log(x) / Math.log(base);}
}
