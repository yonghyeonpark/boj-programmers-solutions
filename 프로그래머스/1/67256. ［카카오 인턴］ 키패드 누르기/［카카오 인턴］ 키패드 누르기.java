import java.util.*;

class Solution {
    
    private Map<Integer, Point> board = new HashMap<>();
    private List<Integer> left = List.of(1, 4, 7);
    private List<Integer> right = List.of(3, 6, 9);
    
    public String solution(int[] numbers, String hand) {
        // 각 번호 위치 저장
        board.put(0, new Point(3, 1));
        board.put(1, new Point(0, 0));
        board.put(2, new Point(0, 1));
        board.put(3, new Point(0, 2));
        board.put(4, new Point(1, 0));
        board.put(5, new Point(1, 1));
        board.put(6, new Point(1, 2));
        board.put(7, new Point(2, 0));
        board.put(8, new Point(2, 1));
        board.put(9, new Point(2, 2));
        
        // 왼손 시작 {3, 0} 오른손 시작 {3, 2}
        Point leftP = new Point(3,0);
        Point rightP = new Point(3,2);
        StringBuilder answer = new StringBuilder();
        for (int number : numbers) {
            Point numberP = board.get(number);
            if (left.contains(number)) {
                answer.append("L");
                leftP = numberP;
                continue;
            }
            if (right.contains(number)) {
                answer.append("R");
                rightP = numberP;
                continue;
            }
            int x = numberP.x;
            int y = numberP.y;
            
            // 누를 번호의 위치로부터 왼손, 오른손으로의 거리 계산
            int leftMove = Math.abs(leftP.x - x) + Math.abs(leftP.y - y);
            int rightMove = Math.abs(rightP.x - x) + Math.abs(rightP.y - y);
            
            if (leftMove > rightMove) {
                answer.append("R");
                rightP = numberP;
                continue;
            }
            if (leftMove < rightMove) {
                answer.append("L");
                leftP = numberP;
                continue;
            }
            if (leftMove == rightMove) {
                if (hand.equals("right")) {
                    answer.append("R");
                    rightP = numberP;
                    continue;
                }
                answer.append("L");
                leftP = numberP;
            }
        }
        return answer.toString();
    }
    
    private class Point {
        int x;
        int y;
        
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}