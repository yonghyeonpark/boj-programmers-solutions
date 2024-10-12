import java.util.*;

class Solution {
    
    public int solution(int[] numbers, int target) {
        return bfs(numbers, target);
    }
    
    private int bfs(int[] numbers, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(numbers[0]);
        q.offer(-numbers[0]);
        
        int length = numbers.length;
        for (int i = 1; i <= length - 1; i++) {
            
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int cur = q.poll();
                q.offer(cur + numbers[i]);
                q.offer(cur - numbers[i]);
            }
        }
        
        int count = 0;
        while(!q.isEmpty()) {
            if (q.poll() == target) count++;
        }
        return count;
    }
}