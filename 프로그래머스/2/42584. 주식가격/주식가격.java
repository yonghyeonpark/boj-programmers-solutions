import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        Deque<Integer> d = new ArrayDeque<>();
        
        for (int i = 0; i < length; i++) {
            int price = prices[i];
            
            while (!d.isEmpty() && price < prices[d.peek()]) {
                int index = d.pop();
                answer[index] = i - index;
            }
            d.push(i);
        }
        
        while(!d.isEmpty()) {
            int index = d.poll();
            answer[index] = length - index - 1;
        }
        
        return answer;
    }
}