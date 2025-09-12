import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> times = new ArrayDeque<>();
        for (int i = 0; i < 24; i++) {
            while (!times.isEmpty() && times.peek() <= i) {
                times.poll();
            }
            
            int server = players[i] / m;
            int count = server - times.size();
            if (count > 0) {
                for (int j = 0; j < count; j++) {
                    times.offer(i + k);
                }
                answer += count;
            }
        }
        return answer;
    }
}