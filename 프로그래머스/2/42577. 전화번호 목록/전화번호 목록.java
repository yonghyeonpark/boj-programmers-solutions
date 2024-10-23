import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> phoneNums = new HashMap<>();
        for (String phoneNum : phone_book) {
            phoneNums.put(phoneNum, 0);
        }
        
        for (String key : phoneNums.keySet()) {
            int length = key.length();
            for(int i = 1; i < length; i++) {
                if (phoneNums.containsKey(key.substring(0, i))) return false;
            }
        }
        return true;
    }
}