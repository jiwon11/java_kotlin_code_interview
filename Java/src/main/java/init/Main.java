package init;

import algorithm.stringManipulation.MostCommonWord;
import algorithm.stringManipulation.ValidPalindrome;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String [] banned = {"hit"};
        System.out.println(mostCommonWord.mostCommonWord("Ross hit a ball, the hit Ball flew far away after it was hit", banned));

    }
}