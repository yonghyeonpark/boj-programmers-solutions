import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int progress : progresses) {
            q.offer(progress);
        }
        
        List<Integer> result = new ArrayList<>();
        int index = 0;
        int length = speeds.length;
        while (index < length) {
            for (int i = index; i < length; i++) {
                int progress = q.poll();
                q.offer(progress + speeds[i]);
            }
            
            if (q.peek() >= 100) {
                int count = 0;
                while (!q.isEmpty() && q.peek() >= 100) {
                    q.poll();
                    count++;
                }
                index += count;
                result.add(count);
            }
        }
        
        int size = result.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}