package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node1{
	int left = 0;
	int right = 0;
	
	Node1(int left, int right){
		this.left = left;
		this.right = right;
	}
	
	Node1(int child){
		if(this.left == 0) {
			this.left = child;
		}
		else
			this.right = child;
	}
}

public class swea1248 {
    static Map<Integer, Node1> tree;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		for (int cs = 1; cs <= 1; cs++) {
            tree = new HashMap<>();
            
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int idx = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				if(tree.containsKey(idx)) {
					tree.put(idx, new Node1(tree.get(idx).left, child));
				}
				else {
					tree.put(idx, new Node1(child));
				}
			}
			
			System.out.println("#" + cs + " " + " ");
		}
		
	}
}
