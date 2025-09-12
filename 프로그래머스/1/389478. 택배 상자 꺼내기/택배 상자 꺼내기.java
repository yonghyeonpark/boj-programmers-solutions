import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int rowNum = (n / w) + 1;
        List<List<Integer>> boxes = new ArrayList();
        int box = 1;
        int row = 0;
        for (int i = 0; i < rowNum; i++) {
            List<Integer> l = new ArrayList();
            for (int j = 0; j < w; j++) {
                if (box == num) row = i;
                if (box > n) {
                    l.add(0);
                    continue;
                }
                l.add(box);
                box++;
            }
            if (i % 2 == 1) Collections.reverse(l);
            boxes.add(l);
        }
        
        List<Integer> l = boxes.get(row);
        int column = l.indexOf(num);
        
        int answer = rowNum - row;
        if (boxes.get(rowNum - 1).get(column) == 0) answer--;
        return answer;
    }
}