import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {       
        int length = commands.length;
        int[] answer = new int[length];
        for (int z = 0; z < length; z++) {
            int[] command = commands[z];
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            int[] copy = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(copy);
            answer[z] = copy[k - 1];
        }
        return answer;
    }
}