import java.util.*;

class Solution {
    public String solution(String new_id) {
        // [step 1] 소문자 치환
        String stepOne = new_id.toLowerCase();
    
        // [step 2] 정규식으로 문자 제거
        String stepTwo = stepOne.replaceAll("[^a-z0-9._-]", "");
    
        // [step 3] 연속된 마침표 치환
        String stepThree = stepTwo.replaceAll("\\.{2,}", ".");
    
        // [step 4] 양끝 마침표 존재 여부 확인
        String stepFour = stepThree;
        if (stepThree.endsWith(".")) {
            stepFour = stepThree.substring(0, stepThree.length() - 1);
        }
        if (stepFour.startsWith(".")) {
            stepFour = stepFour.substring(1);
        }
    
        // [step 5] 빈문자가 되었다면 a로 치환
        String stepFive = stepFour;
        if (stepFour.equals("")) {
            stepFive = "a";
        }
    
        // [step 6] 길이를 15로 맞춘 후, 끝이 마침표라면 제거
        String stepSix = stepFive;
        if (stepFive.length() > 15) {
            stepSix = stepFive.substring(0, 15);
        }
        if (stepSix.endsWith(".")) {
            stepSix = stepSix.substring(0, 14);
        }
    
        // [step 7] 2자 이하면 마지막 문자 추가
        String stepSeven = stepSix;
        int stepSixLength = stepSix.length();
        if (stepSixLength <= 2) {
            String add = stepSix.substring(stepSixLength - 1);
            int stepSevenLength = stepSeven.length();
            while(stepSevenLength <= 2) {
                stepSeven += add;
                stepSevenLength++;
            }
        }
        return stepSeven;
    }
}