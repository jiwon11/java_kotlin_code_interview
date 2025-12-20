package algorithm.linearDataStructure.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    public int twoPointer(int[] height) {
        int right = height.length-1; // 오른쪽 포인터 인덱스
        int left = 0; // 왼쪽 포인터 인덱스
        int rightMax = height[right]; // 오른쪽 최대 높이
        int leftMax = height[left]; // 왼쪽 최대 높이
        int volume = 0;

        // 투 포인터가 서로 곂칠 때까지 반복
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            /*
                더 높은 쪽을 향해 투 포인터 이동
                이 경우 적어도 낮은 쪽은 그만큼 항상 물이 채워질 것
                -> 좌우 어느 포인터든 낮은 쪽은 높은 쪽을 향해서 포인터가 가운데로 점점 이동
             */
            if(leftMax <= rightMax) {
                //왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터가 이동
                volume += leftMax - height[left];
                left += 1;
            } else {
                //오른쪽 막대 최대 높이와의 차이를 더하고 오른쪽 포인터가 이동
                volume += rightMax - height[right];
                right -= 1;
            }
        }
        return volume;
    }

    public int stack(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            // 변곡점을 만나는 경우
            // peek() : pop()과 같이 스택에서 엘리먼트를 추출하는 것이 아닌, 다음번에 추출될 엘리먼트가 무엇인지 조회만 함.
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 스택에서 꺼냄
                Integer top = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }
                // 스택의 마지막 위치까지를 거리로 계산
                int distance = i - stack.peek() - 1;
                // 현재 높이 또는 스택의 마지막 위치 높이 중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];

                // 물이 쌓이는 양은 거리와 물 높이의 곱
                volume += distance * waters;
            }

            // 진행하면서 현재 위치를 스택에 삽입
            stack.push(i);
        }

        return volume;
    }
}
