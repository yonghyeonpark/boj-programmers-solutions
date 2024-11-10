import java.util.*;

class Solution {
    
    private int size;
    private List<String> nums;
    private Set<Integer> result;
    private boolean[] v;
    
    public int solution(String numbers) {
        nums = new ArrayList<>();
        char[] ca = numbers.toCharArray();
        for (char number : ca) {
            nums.add(Character.toString(number));
        }
        size = nums.size();
        v = new boolean[size];
        
        result = new HashSet<>();
        dfs("", 0);
        
        int answer = 0;
        for (int num : result) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    // 중복되는 숫자가 있기 때문에, 소수 판별과 같이 진행할 수 없음
    private void dfs(String num, int index) {
        if (!num.equals("")) result.add(Integer.parseInt(num));
        if (index == size) return;
        
        for (int i = 0; i < size; i++) {
            if (v[i]) continue;
            v[i] = true;
            dfs(num + nums.get(i), index + 1);
            v[i] = false;
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
		// 에라토스테네스 체
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}