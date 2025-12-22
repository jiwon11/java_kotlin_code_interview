package algorithm.linearDataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> bruteforce(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        // 앞 뒤로 같은 값이 있을 경우, 쉽게 처리
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j=i+1; j< nums.length-1; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                for (int k = j+1; k< nums.length; k++) {
                    if(k>j+1 && nums[k] == nums[k-1]) {
                            continue;
                    }
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return results;
    }

    public List<List<Integer>> twoPointer(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        int right, left, sum;

        for(int i=0; i < nums.length-2; i++) {

            if(i>0 && nums[i]== nums[i-1]) {
                continue;
            }

            left = i+1;
            right = nums.length-1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if(sum<0) {
                    left += 1;
                } else if (sum>0) {
                    right -= 1;
                } else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 정답이 두 번 나올 수 있음.
                    while (left < right && nums[left] == nums[left+1]) {
                        left +=1;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right -=1;
                    }
                    // 정답이 나왔으므로 투 포인터 모두 한 칸씩 이동.
                    // 합이 0이 아닌 상황이므로 양쪽 모두 이동.
                    left += 1;
                    right -= 1;
                }
            }
        }

        return results;
    }
}
