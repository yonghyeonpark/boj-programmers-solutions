import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int answer = 0;
        int curTime = 0;
        int index = 0;
        int process = 0;
        int length = jobs.length;
        // 현재 시간에 해당하는 작업들 모두 추가
        // 하나의 작업이 끝난 시간 기준으로 작업들 다시 추가
        // 모든 작업이 끝나면 반복문 종료
        while (process < length) {
            for (int i = index; i < length; i++) {
                int[] job = jobs[i];
                if (job[0] <= curTime) {
                    pq.add(job);
                    index++;
                }
            }
            
            if (pq.isEmpty()) {
                curTime++;
                continue;
            }
            
            int[] cur = pq.poll();
            answer += (curTime - cur[0]) + cur[1];
            curTime += cur[1];
            process++;
        }
        return answer / length;
    }
}