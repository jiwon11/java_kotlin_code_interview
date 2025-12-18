package algorithm.stringManipulation;


public class LongestPalindromeSubstring {
     /*
        최장 공통 부분 문자열 문제(Longest Common Substring Problem)
        : 여러 개의 입력 문자열이 있을 때 서로 공통된 가장 긴 문자열을 찾는 문제
        -> 다이나믹 프로그래밍(DP)로 해결 가능
        -> DP의 문제점 : 직관적으로 이해가 어렵고, 실행 시간이 느리다.
        -> 직관적이고 실행 시간이 빠른 Two-Pointer 방식으로 해결
        -> 투 포인터 방식이 DP보다 직관적인 이유 : DP는 표를 다 채워야 하지만, 이 방식은 "중심에서 양옆이 같으면 계속 전진한다"는 단순한 물리적 확장을 이용

        주요 아이디어
        1. 투 포인터가 팰린드롬을 발견하면 확장하는 형태
        2. 팰린드롬을 판별만 하면 되므로, 매칭이 될 때 중앙을 중심으로 전점 확장해 나가면서 가장 긴 팰린드롬을 판별
        3. 투 포인터는 슬라이딩 윈도우처럼 이동

        방식
        1. 2칸, 3칸으로 구성된 투 포인터가 슬라이딩 윈도우처럼 계속 앞으로 전진
        2. 윈도우에 들어온 문자열이 팰린드롬일 경우 그 자리에서 멈추고 투 포인터는 점점 확장
        팰린드롬은
        - dd처럼 짝수 (2칸, 2->4->6 형태로 증가)
        - bab처럼 홀수(3칸, 1->3->5 형태로 증가)
         짝수, 홀수 모든 경에 대해 판별
         */

    int left, maxLen; // 초기값 : 0
    public void extendPalindrome(String s, int start, int end) {
        // 투 포인터가 유효한 범위 내에 있고 양쪽 끝 문자가 일치하는 팰린드롬인 경우 범위 확장
        System.out.println("two pointer index : " + start + " "+ end);
        while (start>= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            System.out.println("start : " + start);
            System.out.println("end : " + end);
        }

        // 기존 최대 길이보다 큰 경우 값 교체
        if (maxLen < end-start-1) {
            left = start+1;
            maxLen = end-start-1;
        }
        System.out.println("left : " + left);
        System.out.println("maxLen : " + maxLen);
        System.out.println("current Palindrome : "+ s.substring(left, left+maxLen));
    }

    public String longestPalindromeSubstring(String s) {
        int len = s.length();
        if(len < 2) {
            return s;
        }

        //우측으로 한 칸씩 이동하며 투 포인터 조사
        for (int i = 0; i < len-1; i++) {
            System.out.println("current char : " + s.charAt(i));
            System.out.println("// 2칸짜리 투 포인터");
            extendPalindrome(s, i,i+1); // 2칸짜리 투 포인터
            System.out.println("// 3칸짜리 투 포인터");
            extendPalindrome(s, i,i+2); // 3칸짜리 투 포인터
            System.out.println("========================================");
        }

        // 왼쪽과 최대 길이만큼을 더한 오른쪽만큼의 문자를 정답으로 리턴
        /*
        i,문자,포인터 종류,검사 구간 (index),결과 (maxLen),현재 최장 팰린드롬
        0,d,2칸 / 3칸,"(0,1) / (0,2)",1,"""c"" (또는 ""d"")"
        1,c,2칸 / 3칸,"(1,2) / (1,3)",1,"""c"""
        2,b,3칸,"(2, 4) → 확장",7,"""dcbabcd"""
        3,a,2칸 / 3칸,"(3,4) / (3,5)",7,"""dcbabcd"""
        4,b,2칸 / 3칸,"(4,5) / (4,6)",7,"""dcbabcd"""
        5,c,2칸 / 3칸,"(5,6) / (5,7)",7,"""dcbabcd"""
        6,d,2칸 / 3칸,"(6,7) / (6,8)",7,"""dcbabcd"""
         */
        return s.substring(left, left+maxLen);
    }
}
