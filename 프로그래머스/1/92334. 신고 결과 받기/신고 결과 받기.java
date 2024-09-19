import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> count = new HashMap<>();
        Map<String, List<String>> state = new LinkedHashMap<>();
        for (String id : id_list) {
            count.put(id, 0);
            state.put(id, new ArrayList<>());
        }
        
        // 동일한 유저의 신고건은 한 번으로 처리
        Set<String> uniqueReport = new HashSet<>();
        for (String content : report) {
            uniqueReport.add(content);
        }
        
        // 신고 결과 저장
        for (String content : uniqueReport) {
            String[] detail = content.split(" ");
            String a = detail[0];
            String b = detail[1];
            
            count.put(b, count.get(b) + 1);
            state.get(a).add(b);
        }
        
        // 지정 횟수 넘는지 체크 후, 정지 대상 찾기
        List<String> blackList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() >= k) {
                blackList.add(entry.getKey());
            }
        }
        
        // 정지 대상을 갖고 있는 유저 체크
        int index = 0;
        for (List<String> l : state.values()) {
            int mail = 0;
            for (String user : blackList) {
                if (l.contains(user)) mail++;
            }
            answer[index] = mail;
            index++;
        }
        
        return answer;
    }
}