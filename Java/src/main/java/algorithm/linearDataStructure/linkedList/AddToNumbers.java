package algorithm.linearDataStructure.linkedList;

import java.math.BigInteger;

public class AddToNumbers {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, node = head;
        // 노드 끝으로 이동할 때까지 순회
        while (node != null) {
            // 현재 노드의 다음 노드 미리 지정
            ListNode next = node.next;
            // 현재 노드의 다음으로 이전 노드 지정
            node.next = prev;
            // 이전 노드는 현재 노드로 지정
            prev = node;
            // 미리 지정했던 다음 노드를 현재 노드로 변경
            node = next;
        }
        // prev는 뒤집힌 연결 리스트의 첫 번째 노드
        return prev;
    }

    // 연결 리스트를 임의 정밀도 정수형으로 변환
    public BigInteger toBigInt(ListNode node) {
        String val = "";
        // 연결 리스트를 순회하며 한 글자씩 조합
        while (node != null) {
            val += node.val;
            node = node.next;
        }
        // 조합한 글자를 임의 정밀도 정수형으로 변환
        return new BigInteger(val);
    }

    // 임의 정밀도 정수형을 연결 리스트로 변환
    public ListNode toReversedLinkedList(BigInteger val) {
        ListNode prev = null, node = null;
        // 정수형을 문자로 바꾼 다음 문자 배열로 전환하여 한 글자씩 순회
        for (char c: String.valueOf(val).toCharArray()) {
            //한 글자씩 숫자로 변환하여 노드 지정
            node = new ListNode(Character.getNumericValue(c));
            // 최종 결과는 뒤집어야 하므로 현재 노드의 다음으로 이전 노드 지정
            node.next = prev;
            prev = node;
        }
        return node;
    }

    public ListNode TypeCasting(ListNode l1, ListNode l2) {
        // 2개의 연결 리스트를 뒤집는다.
        ListNode l1reversed = reverseList(l1);
        ListNode l2reversed = reverseList(l2);

        // 임의 정밀도 정수형으로 변환하여 다하기 연산 실행
        BigInteger result = toBigInt(l1reversed).add(toBigInt(l2reversed));
        //결과를 다시 역순 연결 리스트로 변환
        return toReversedLinkedList(result);
    }


    public ListNode fullAdder(ListNode l1, ListNode l2) {
        // 값을 계산할 임시 노드 선언
        ListNode node = new ListNode(0);
        // 임시 노드를 첫 번째 노드로 선언
        ListNode root = node;

        // 자릿수의 합(sum), 자리올림수(carry), 나머지(remainder)를 저장할 변수 선언
        int sum, carry =0 , remainder;
        // 모든 연결 리스트를 끝까지 순회하고, 자리올림수도 0이 될때까지 진행
        while (l1 != null || l2 != null || carry != 0 ) {
            sum = 0;
            // 첫 번째 연결리스트 합산 및 진행
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // 두 번째 연결리스트 합산 및 진행
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 노드의 값으로 사용할 나머지 계산
            remainder = (sum + carry) % 10;
            // 10으로 나누었을 때 몫은 자릿수가 증가했다는 의미이므로 자리올림수로 사용
            carry = (sum + carry) / 10;
            // 나머지는 다음 노드의 값으로 지정
            node.next = new ListNode(remainder);
            // 계산할 노드를 다음으로 이동
            node = node.next;
        }

        // 첫 번째 노드는 임시노드이므로 그 다음부터 결과로 리턴
        return root.next;
    }
}
