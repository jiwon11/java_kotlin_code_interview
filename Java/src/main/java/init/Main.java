package init;

import algorithm.stringManipulation.LongestPalindromeSubstring;
import algorithm.stringManipulation.MostCommonWord;
import algorithm.stringManipulation.ValidPalindrome;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
        String results = longestPalindromeSubstring.longestPalindromeSubstring("dcbabcdd");
        System.out.println("results : " + results);

    }
}