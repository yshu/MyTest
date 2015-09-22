/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(0); //dummy node
        start.next = head;

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode walk = start;

        while(p1 != null && p1.next != null) {
            p2 = p1.next;
            if(p1.val != p2.val) {
                walk.next = p1;
                walk = walk.next;
                p1 = p1.next;
            }
            else {
                while(p2 != null && p2.val == p1.val) {
                    p2 = p2.next;
                }
                p1 = p2;
                walk.next = p1;
            }
        }

        return start.next;
    }
}

public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(0); //dummy node
        start.next = head;

        ListNode p1 = start;

        while(p1.next != null && p1.next.next != null) {
            if(p1.next.val == p1.next.next.val) {
                int dup = p1.next.val;
                while(p1.next != null && p1.next.val == dup) {
                    p1.next = p1.next.next;
                }
            }
            else {
                p1 = p1.next;
            }
        }

        return start.next;
    }
}