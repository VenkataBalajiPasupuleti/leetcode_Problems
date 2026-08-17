/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {

        List<Integer> li = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            li.add(temp.val);
            temp = temp.next;
        }

        int sum = 0;
        int power = 0;

        for (int i = li.size() - 1; i >= 0; i--) {
            sum = sum + li.get(i) * (int)Math.pow(2, power);
            power++;
        }

        return sum;
    }
}
