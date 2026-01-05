package algorithm.linearDataStructure.linkedList;

public class MergeTwoSortedList {
    public ListNode recursion(ListNode list1, ListNode list2) {
        // 두 노드 중 한쪽이 null이면 null이 아닌 노드를 리턴
        if(list1 == null) return list2;
        if (list2 == null) return list1;

        // l2가 더 크면 l1에 재귀 호출 결과를 겪고 l1을 리턴
        if(list1.val < list2.val) {
            list1.next = recursion(list1.next, list2);
            return list1;
            // l1이 더 크거나 같으면 l2에 재귀 호출 결과를 엮고 l2를 리턴
        } else {
            list2.next = recursion(list1, list2.next);
            return list2;
        }
    }

    public ListNode iterative(ListNode list1, ListNode list2) {
        // 1. 시작점 역할을 할 Dummy Node 생성
        ListNode dummy = new ListNode(0);
        // 2. 결과 리스트를 만들어 나갈 현재 포인터(curr)
        ListNode curr = dummy;

        // 3. 두 리스트 중 어느 하나가 끝날 때까지 반복
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            // curr를 방금 추가한 노드로 이동
            curr = curr.next;
        }

        // 4. 반복문이 끝난 후 남은 노드가 있다면 통째로 붙임
        if (list1 != null) {
            curr.next = list1;
        } else if (list2 != null) {
            curr.next = list2;
        }

        // dummy의 다음 노드가 실제 합쳐진 리스트의 시작점
        return dummy.next;
    }
}
