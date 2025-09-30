import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIndex = getIndex(ext);
        int sortIndex = getIndex(sort_by);
        
        int[][] answer = Arrays.stream(data)
            .filter(d -> d[extIndex] < val_ext)
            .toArray(int[][]::new);
        
        Arrays.sort(answer, Comparator.comparing(d -> d[sortIndex]));
        
        return answer;
    }
    
    private int getIndex(String s) {
        if (s.equals("date")) {
            return 1;
        }
        if (s.equals("maximum")) {
            return 2;
        }
        if (s.equals("remain")) {
            return 3;
        }
        return 0; 
    }
}