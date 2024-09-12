import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        int num = 1;
        for (String privacie : privacies) {
            String[] privacieSplit = privacie.split(" ");
            String privacieDate = privacieSplit[0];
            String type = privacieSplit[1];
            
            int dl = 0;
            for (String term : terms) {
                if (term.contains(type)) {
                    dl = Integer.parseInt(term.split(" ")[1]);
                }
            }
            if (isExpired(today, privacieDate, dl)) {
                answer.add(num);
            }
            num++;
        }
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
    
    private boolean isExpired(String today, String privacieDate, int dl) {
        String[] todaySplit = today.split("\\.");
        int todayY = Integer.parseInt(todaySplit[0]);
        int todayM = Integer.parseInt(todaySplit[1]);
        int todayD = Integer.parseInt(todaySplit[2]);
            
        String[] pDate = privacieDate.split("\\.");
        int pDateY = Integer.parseInt(pDate[0]);
        int pDateM = Integer.parseInt(pDate[1]);
        int pDateD = Integer.parseInt(pDate[2]);
        
        int y = todayY - pDateY;
        int m = todayM - pDateM;
        int d = todayD - pDateD;
        
        int month = (y * 12) + m;
        if (d >= 0) month++;
        
        return month > dl; 
    }
}