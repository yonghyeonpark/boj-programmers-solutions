import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> result = new HashMap<>();
        
        // 동명이인 검증을 위해 값 증가
        for (String p : participant) {
            result.put(p, result.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            result.put(c, result.get(c) + 1);
        }
        
        // 완주를 했다면 value는 항상 짝수여야 합니다.
        // 홀 + 홀 = 짝, 짝 + 짝 = 짝
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return null;
    }
}