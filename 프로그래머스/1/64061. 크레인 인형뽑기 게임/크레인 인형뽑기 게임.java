import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int l = board.length;
        List<Stack<Integer>> b = new ArrayList<>();
        for (int i = 0; i <= l; i++) {
            b.add(new Stack<>());
        }
        for (int i = l - 1; i >= 0; i--) {
            for (int j = 0; j < l; j++) {
                int d = board[i][j];
                if (d == 0) continue;
                b.get(j + 1).push(d);
            }
        }
        
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            Stack<Integer> s = b.get(move);
            if (s.isEmpty()) continue;
            
            int cur = s.pop();
            if (basket.isEmpty()) {
                basket.push(cur);
            } else if (basket.peek() == cur) {
                basket.pop();
                answer += 2;
            } else {
                basket.push(cur);
            }
        }
        return answer;
    }
}