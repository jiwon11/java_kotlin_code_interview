package algorithm.stringManipulation;

import java.util.ArrayList;

public class ReorderDataInLogFiles {
    public String[] reorder(ArrayList<String> logs) {
        ArrayList<String> letterList = new ArrayList<>();
        ArrayList<String> numberList = new ArrayList<>();

        for(String log: logs) {
            if(Character.isDigit(log.split(" ")[1].charAt(0))) {
                numberList.add(log);
            } else {
                letterList.add(log);
            }
        }

        letterList.sort((s1, s2) -> {
            String[] targetS1 = s1.split(" ", 2);
            String[] targetS2 = s2.split(" ", 2);

            int compared = targetS1[1].compareTo(targetS2[1]);
            // 비교 대상의 순서가 동일한 경우 0, 순서가 앞인 경우 1, 순서가 뒤일 경우 -1 반환
            if(compared == 0) {
                return targetS1[2].compareTo(targetS2[2]);
            } else {
                return compared;
            }
        });
        letterList.addAll(numberList);
        return letterList.toArray(new String[0]); // Java에서 List를 Array로 변환할 때 사용되는 매우 일반적이고 중요한 패턴
        /*
        제네릭 타입 정보를 런타임에 넘겨줍니다.
        Java의 제네릭(List<String>)은 런타임에는 타입 정보가 지워지기 때문에 (List), 이 String[0] 배열은
        "내가 원하는 배열의 타입은 **String[]**이다"라는 것을 런타임에 명시적으로 알려줍니다.

        new String[0]은 크기 0짜리 배열을 잠시 타입 템플릿으로 제공하고,
        실제 반환되는 배열은 letterList.size()와 같은 크기가 됩니다.

        a의 크기 >= (리스트의 요소 수)일 경우: 메서드는 새로운 배열을 생성하지 않고, 전달된 배열 a에 요소들을 복사한 후 a를 반환
         */
    }
}
