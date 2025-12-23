package algorithm.linearDataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayPartitionOne {

    public int ascendingOrder(int[] nums) {

        int sum = 0;
        Arrays.sort(nums);
        List<Integer> pair = new ArrayList<>();

        for( int n : nums) {
            pair.add(n);
            if(pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }
        return sum;
    }
    public int evenNumber(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i%2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
