class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        boolean[] day = new boolean[7];
        for (int i = 0; i < 7; i++) {
            if (startday > 7) startday -= 7;
            if (startday != 6 && startday != 7) {
                day[i] = true;
            }
            startday++;
        }
        
        int answer = 0;
        int length = schedules.length;
        for (int i = 0; i < length; i++) {
            int limit = getLimit(schedules[i]);
            
            boolean can = true;
            int[] timelog = timelogs[i];
            for (int j = 0; j < 7; j++) {
                if (!day[j]) continue;
                if (timelog[j] > limit) {
                    can = false;
                    break;
                }
            }
            if (can) answer++;
        }
        return answer;
    }
    
    private int getLimit(int schedule) {
        int hour = schedule / 100;
        int minute = (schedule % 100) + 10;
        
        if (minute >= 60) {
            minute -= 60;
            hour += 1;
        }
        return (hour * 100) + minute;
    }
}