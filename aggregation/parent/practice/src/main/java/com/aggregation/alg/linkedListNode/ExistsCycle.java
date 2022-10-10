package com.aggregation.alg.linkedListNode;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/21 上午12:29
 */
public class ExistsCycle {


    /**
     * @Desc 链表是否有环
     * @Date 2022/3/21 上午12:30
     **/
    public boolean existsCycle(ListNode listNode) {
        ListNode fast = listNode;
        ListNode slow = listNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


}
