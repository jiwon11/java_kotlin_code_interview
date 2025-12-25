package algorithm.linearDataStructure.array;


public class ProductOfArrayExceptSelf {

    public int[] productOfArrayExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int p = 1;
        for (int i=0; i < nums.length; i++) {
            result[i] = p;  // 1. 현재까지의 누적 곱(p)을 결과에 기록
            p *= nums[i];  // 2. 현재 숫자(nums[i])를 곱해 다음 칸을 위한 p를 준비
        }

        p = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] *= p;  // 1. 이미 저장된 '왼쪽 곱'에 '현재까지의 오른쪽 곱(p)'을 곱함
            p *= nums[i];    // 2. 현재 숫자(nums[i])를 곱해 다음 칸(왼쪽 칸)을 위한 p를 준비
        }

        return result;
    }
}
