package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node {
    String value;
    int left, right;

    Node(String value, int left, int right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class swea1232 {
    static Map<Integer, Node> tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int cs = 1; cs <= 10; cs++) {
        	int N = Integer.parseInt(br.readLine());
        	
            tree = new HashMap<>();
        	
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String value = st.nextToken();

                if (st.hasMoreTokens()) {
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());
                    tree.put(idx, new Node(value, left, right));
                } else {
                    tree.put(idx, new Node(value, -1, -1));
                }
            }
            
            int result = (int) evaluate(1);
            System.out.println("#" + cs + " " + result);
		}
        
    }

    static double evaluate(int nodeIdx) {
        Node node = tree.get(nodeIdx);

        if (node.left == -1 && node.right == -1) {
            return Double.parseDouble(node.value);
        }

        double leftValue = evaluate(node.left);
        double rightValue = evaluate(node.right);

        switch (node.value) {
            case "+": return leftValue + rightValue;
            case "-": return leftValue - rightValue;
            case "*": return leftValue * rightValue;
            case "/": return leftValue / rightValue;
        }

        return 0;
    }
}
