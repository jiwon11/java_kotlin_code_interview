package algorithm.stringManipulation;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String p, String[] banned) {
        /*
        주요 아이디어
        1. 대소문자, 구두점 등에 대한 전처리
        2. HashMap을 사용한 키:값 자료구조에서의 최대값 찾기 / 정렬
        */

        //금지어 목록이 String 배열이므로, 비교 메소드를 제공하는 Set으로 변경
        Set<String> ban = new HashSet<>(Arrays.asList(banned));

        // 각 단어별 개수가 저장될 키-값 맵
        Map<String, Integer> counts = new HashMap<>();

        // 전처리 작업 후 단어 목록을 배열로 저장
        /*
        * 정규식에서 \W : 단어 문자가 아닌 것
        * \w : 단어 문자를 뜻함
        * 문자 뒤에 + : 연속적인 값을 의미
        * -> \W+ : 연속적으로 단어 문자가 아닌 값을 의미
        */
        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for(String w: words) {
            // 금지 단어가 아닌 경우 개수 처리
            if(!ban.contains(w)) {
                // 존재하지 않는 단어라면 기본값을 0으로 지정. 추출한 값에 +1하여 저장
                counts.put(w, counts.getOrDefault(w,0)+1);
            }
        }
        /*
        Collections.max : 메소드의 2번째 파라미터로 compare() 메소드를 정의한 Comparator 객체를 넘겨주면,
        compare() 메소드에 정의한 기준으로 Collection의 대소를 비교하여, 최대값, 최소값을 찾아서 해당 Collection 객체를 리턴

        Map.entrySet() : Map에 저장된 모든 키-값 쌍을 Map.Entry 객체들의 Set으로 반환하는 기능
        -> 키와 값(value)이 모두 필요한 경우 Map을 순회(iteration)할 때 주로 사용
        ex) [the=1, a=1, ball=2, away=1, far=1, flew=1, ross=1, was=1, after=1, it=1]

        Map.Entry.comparingByValue() : Map의 엔트리(키-값 쌍)들을 값(Value)을 기준으로 오름차순 정렬해주는 Comparator 객체를 반환하는 정적 메서드
        -> 객체들 간의 비교를 수행하는 Comparator를 생성하여 반환하므로 sorted(), max() 메소드 등에서 Comparator 인자로 사용 가능
        -> Map의 내용을 값 기준의 순서로 쉽게 정렬
        */
        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
