class Solution {
    
    private int[] total;
    
    public int solution(int n, int[] lost, int[] reserve) {
        total = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            total[i] = 1;
        }
        for (int s : lost) {
            total[s]--;
        }
        for (int s : reserve) {
            total[s]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (total[i] == 0) {
                if (total[i - 1] == 2) {
                    total[i]++;
                    total[i - 1]--;
                    continue;
                }
                if (total[i + 1] == 2) {
                    total[i]++;
                    total[i + 1]--;
                }
            }
        }
        int answer = 0;
        for (int c : total) {
            if (c >= 1) answer++;
        }
        return answer;
    }
}