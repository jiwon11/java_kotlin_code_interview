package OOP.RefrenceType;

public class ReferenceVariableCompareExample {
    public static void main(String[] args) {
        int [] arr1;
        int [] arr2;
        int [] arr3;

        arr1 = new int[] {1,2,3};
        arr2 = new int[] {1,2,3};
        arr3 = arr2;

        System.out.println(arr1 == arr2);
        /*
        * 스택 영역에 저장된 arr1은 힙 영역의 X번지 배열 객체로 저장
        * */
        System.out.println(arr2 == arr3);
        /*
         * 스택 영역에 저장된 arr2은 힙 영역의 Y번지 배열 객체로 저장
         *
         * arr3는 arr2 변수의 번지가 대입
         * */
    }
}
