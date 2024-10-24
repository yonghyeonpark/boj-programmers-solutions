import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        
        if (pq.peek() >= k) {
            return 0;
        }
        
        int answer = 0;
        while (true) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + (b * 2));
            
            answer++;
            if (pq.size() == 1) {
                if (pq.peek() >= k) {
                    break;
                }
                return -1;
            }
            if (pq.peek() >= k) {
                break;
            }
        }
        return answer;
    }
}