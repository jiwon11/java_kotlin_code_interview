package algorithm.stringManipulation;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        주요 아이디어
        1. 애너그램을 판단하는 가장 간단한 방법 : 정렬하여 비교
        -> 애너그램을 이루는 단어들을 정렬하면 모두 같은 값을 갖음
        2. 단어를 비교하는 건 String -> char로 변환 후 변환한 char을 정렬
         */

        // 애너그램 결과를 보관하기 위한 맵 선언
        Map<String, List<String>> results = new HashMap<>();

        //입력값인 문자열 배열을 순회
        for(String str : strs) {
            // 문자열을 문자 배열로 변환
            char[] chars = str.toCharArray();
            // 문자 배열 정렬
            Arrays.sort(chars);
            // 정렬된 문자 배열을 키로하기 위해 다시 문자열로 변환
            String key = String.valueOf(chars);

            // 만약 기존에 없던 키라면 빈 리스트를 삽입
            if(!results.containsKey(key)){
                results.put(key, new ArrayList<>());
            }
            // 키에 해당하는 리스트에 추가
            results.get(key).add(str);
        }
        // 문제에서 요구하는 출력값 형태로 변경
        return new ArrayList<>(results.values());
    }
}
