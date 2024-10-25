class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int i = 1;
        while (true) {
            // 약수만 검증
            if (yellow % i != 0) {
                i++;
                continue;
            }
            int m = yellow / i;
            int s = (m * 2) + (i * 2) + 4; 
            if (s == brown) {
                answer[0] = Math.max(m, i) + 2;
                answer[1] = Math.min(m, i) + 2;
                break;
            }
            i++;
        }
        return answer;
    }
}