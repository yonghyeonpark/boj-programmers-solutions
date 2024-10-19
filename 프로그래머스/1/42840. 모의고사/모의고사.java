import java.util.*;

class Solution {
    
    private int[] one = {1, 2, 3, 4, 5};
    private int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    private int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        Map<Integer, Integer> scores = new HashMap<>();
        
        int length = answers.length;
        for (int i = 0; i < length; i++) {
            int answer = answers[i];
            
            if (answer == one[i % 5]) {
                scores.put(1, scores.getOrDefault(1, 0) + 1);
            }
            if (answer == two[i % 8]) {
                scores.put(2, scores.getOrDefault(2, 0) + 1);
            }
            if (answer == three[i % 10]) {
                scores.put(3, scores.getOrDefault(3, 0) + 1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (max == entry.getValue()) {
                answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}