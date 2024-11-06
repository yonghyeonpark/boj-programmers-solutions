import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        int answer = 1;
        int check = routes[0][1];
        int length = routes.length;
        for (int i = 1; i < length; i++) {
            int s = routes[i][0];
            int e = routes[i][1];
            
            if (s <= check && check <= e) continue;
            check = e;
            answer++;
        }
        return answer;
    }
}