import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        for (int i = 0; i < mats.length / 2; i++) {
            int temp = mats[i];
            mats[i] = mats[mats.length - 1 - i];
            mats[mats.length - 1 - i] = temp;
        }
        
        for (int mat : mats) {
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[0].length; j++) {
                    if (!park[i][j].equals("-1")) continue;
                    if (check(park, i, j, mat)) {
                        return mat;
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean check(String[][] park, int i, int j, int mat) {
        if (park.length < i + mat || park[0].length < j + mat) {
            return false;
        }
        
        for (int n = i; n < i + mat; n++) {
            for (int m = j; m < j + mat; m++) {
                if (!park[n][m].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}