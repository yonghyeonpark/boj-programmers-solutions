import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int length = numbers.length;
        String[] nums = new String[length];
        
        for (int i = 0; i < length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (n1, n2) -> {
            // String sum1 = n1 + n2;
            // String sum2 = n2 + n1;
            // return sum2.compareTo(sum1);
            int sum1 = Integer.parseInt(n1 + n2);
            int sum2 = Integer.parseInt(n2 + n1);
            return Integer.compare(sum2, sum1);
        });
        
        if (nums[0].equals("0")) return "0";
        
        StringBuilder answer = new StringBuilder();
        for (String num : nums) {
            answer.append(num);
        }
        return answer.toString();
    }
}