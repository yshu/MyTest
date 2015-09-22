/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode start = new ListNode(0);
        start.next = head;

        ListNode walk = start;
        ListNode preM = head;
        ListNode nodeN = head;
        ListNode postN = head;

        for(int i=1; i<m; i++) {
            walk = walk.next;
        }
        preM = walk;

        walk = start;
        for(int i=0; i<n; i++) {
            walk = walk.next;
        }
        nodeN = walk;
        postN = walk.next;

        walk = preM.next.next;
        ListNode prev = preM.next;
        ListNode temp = walk;
        while(prev != nodeN) {
            temp = walk.next;
            walk.next = prev;
            prev = walk;
            walk = temp;
        }

        preM.next.next = postN;
        preM.next = nodeN;

        return start.next;
    }
}