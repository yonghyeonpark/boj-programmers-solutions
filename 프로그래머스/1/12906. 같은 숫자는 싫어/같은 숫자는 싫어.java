import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        int length = arr.length;
        s.push(arr[0]);
        for (int i = 1; i < length; i++) {
            int num = arr[i];
            if (s.peek() == num) continue;
            s.push(num);
        }
        
        int size = s.size();
        int[] answer = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            answer[i] = s.pop();
        }
        return answer;
    }
}