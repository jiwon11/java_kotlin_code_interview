package Algorithm;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
        while (start < end) {
            // 영숫자인지 판별하고 유효하지 않으면 한 칸씩 이동
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            } else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            } else {  // 유효한 문자라면 앞글자와 뒷글자를 모두 소문자로 변경해 비교
                if(Character.toLowerCase(s.charAt(start))!= Character.toLowerCase((s.charAt(end)))) {
                    // 하나라도 일치하지 않으면 false 리턴
                    return false;
                }
            }
            // 앞문자는 한칸 뒤로, 뒷문자는 한칸 앞으로 이동
            start++;
            end--;
        }
        // 모두 일치한다면 true 리턴
        return true;
    }

    public boolean isPalindrome2(String s) {
        String s_filter = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        String s_reversed = new StringBuilder(s_filter).reverse().toString();

        return s_filter.equals(s_reversed);
    }
}