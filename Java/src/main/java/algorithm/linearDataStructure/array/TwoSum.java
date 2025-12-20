package algorithm.linearDataStructure.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
    문제 자체는 매우 쉬움
    최적화할 수 있는 방법이 숨어 있어, 코딩 인터뷰 시 높은 빈도로 출제됨.
     */
    public int[] bruteForce(int[] nums, int target) {
        /*
        * 브루스 포스 : 모든 조합을 더해서 일일히 확인해보는 무차별 대입 방식
        * 시간 복잡도 : O(n^2)
        * -> 매우 비효율적
        * */
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[] diff(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        // 키와 값을 바꿔서 맵으로 저장
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        /*
        주요 아이디어
        target에서 첫 번째 수를 뺀 결과를 키로 조회하고 현재 인덱스가 아닌 경우 정답으로 리턴
        1. target 변수에서 첫 번째 수를 빼면 두 번째 수를 알 수 있음
        2. 두번째 수를 키로 하고 기존의 인덱스는 값으로 바꿔서 맵으로 저장 -> 나중에 두 번째 수를 키로 조회하여 정답을 찾을 수 있음
        3. target에서 첫 번째 수를 뺀 결과를 키로 조회해보면 두 번째 수의 인덱스를 조회할 수 있음

        주의점
        1. 차이값과 첫 번째 수가 같을 경우, 현재 인덱스를 정답으로 착각 할 수 있음
        예) [3,2,4] , target = 6 일 경우, numsMap(3) = 0, [0,0]이 정답으로 착각할 수 있음
        i != numsMap.get(target - nums[i])으로 현재 인덱스가 아닌 경우에만 정답으로 간주
         */
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i]; // 타겟값과 첫 번째 수 간의 차이값
            if (numMap.containsKey(diff) && i != numMap.get(diff)) {
                return new int[]{i, numMap.get(diff)};
            }
        }
        return null;
    }

    public int[] implementDiff(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();

        // 하나의 for문으로 통합
        for (int i = 0; i < nums.length; i++) {
            // target에서 num을 뺀 값이 numMap 키에 있으면 정답으로 리턴
            if(numMap.containsKey(target-nums[i])) {
                // nums의 차례대로 맵에 삽입하며 결과를 찾기 때문에 맵에 들어있는 값이 현재 인덱스보다 항상 더 작으므로 맵에 있는 값을 먼저 리턴
                return new int[]{numMap.get(target-nums[i]), i};
            } else {
                // 정답이 아니므로 다음번 비교를 위해 인덱스를 맵에 저장
                numMap.put(nums[i], i);
            }
        }
        return null;

    }
}
