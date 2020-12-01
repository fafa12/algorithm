package leetcode;

public class SortList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 148. 排序链表
     *
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     * 进阶：
     *
     *     你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     */
    public ListNode sortList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode start = new ListNode(0, head);
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {

                ListNode index = start;
                while (index.next.val < curr.val) {
                    index = index.next;
                }

                lastSorted.next = curr.next;
                curr.next = index.next;
                index.next = curr;
            }

            curr = lastSorted.next;
        }

        return start.next;
    }
}
