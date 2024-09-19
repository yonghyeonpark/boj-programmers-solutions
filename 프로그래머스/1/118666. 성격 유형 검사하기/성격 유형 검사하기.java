import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> score = new LinkedHashMap<>();
        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            String content = survey[i];
            char first = content.charAt(0);
            char second = content.charAt(1);
            int choice = choices[i];
            
            if (choice > 4) {
                // 오른쪽에 추가
                score.put(second, score.get(second) + (choice - 4));
            }
            if (choice < 4) {
                // 왼쪽에 추가
                score.put(first, score.get(first) + (4 - choice));
            }
        }

        StringBuilder result = new StringBuilder();
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(score.entrySet());
        for (int i = 0; i < entryList.size(); i += 2) {
            Map.Entry<Character, Integer> first = entryList.get(i);
            Map.Entry<Character, Integer> second = entryList.get(i + 1);
            
            if (first.getValue() >= second.getValue()) {
                result.append(first.getKey());
                continue;
            }
            result.append(second.getKey());
        }
        return result.toString();
    }
}