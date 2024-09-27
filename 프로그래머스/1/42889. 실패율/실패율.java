import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 해당 스테이지에 도달한 유저수 계산
        int[] stageCounts = new int[N + 2];
        for (int stage : stages) {
            stageCounts[stage] += 1;
        }
        
        // 스테이지마다 실패율 계산
        Map<Integer, Double> failureRate = new HashMap<>();
        double userCount = (double) stages.length;
        for (int i = 1; i <= N; i++) {
            double stageCount = (double) stageCounts[i];
            if (stageCount == 0) {
                failureRate.put(i, 0.0);
            } else {
                failureRate.put(i, stageCount / userCount);
            }
            userCount -= stageCount;
        }
        
        // 실패율 내림차순 정렬
        // 실패율이 같을 시, 스테이지 오름차순 정렬
        List<Map.Entry<Integer, Double>> failureRateList = new ArrayList<>(failureRate.entrySet());
        failureRateList.sort(Comparator.comparing(Map.Entry<Integer, Double>::getValue).reversed()
                            .thenComparing(Map.Entry<Integer, Double>::getKey));
        
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = failureRateList.get(i).getKey();
        }
        return result;
    }
}