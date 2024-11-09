import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                int num = Integer.parseInt(operation.split(" ")[1]);
                pqMax.offer(num);
                pqMin.offer(num);
                continue;
            }
            if (pqMax.isEmpty()) continue;
            if (operation.equals("D 1")) {
                int max = pqMax.poll();
                pqMin.remove(max);
                continue;
            }
            int min = pqMin.poll();
            pqMax.remove(min);
        }
        
        int max = 0;
        int min = 0;
        if (!pqMax.isEmpty()) {
            int size = pqMax.size();
            if (size == 1) {
                max = pqMax.poll();
                min = max;
            }
            if (size != 1) {
                max = pqMax.poll();
                min = pqMin.poll();
            }
        }
        int[] answer = {max, min};
        return answer;
    }
}