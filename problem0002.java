public class problem0002 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        while(result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        int count = 0;
        int carry = 0;
        ListNode temp = new ListNode();
        ListNode current1 = l1;
        ListNode current2 = l2;
        while(current1.val != 0 || current2.val != 0 || carry != 0 || current1.next != null || current2.next != null) {
            if(current1.next == null) {
                current1.next = new ListNode(0);
            }
            if(current2.next == null) {
                current2.next = new ListNode(0);
            }

            int sum = current1.val + current2.val + carry;
            carry = sum / 10;
            int result = sum % 10;
            
            ListNode newCurrent = new ListNode(result);
            if(count == 0) {
                ret = newCurrent;
                temp = newCurrent;
            } else {
                temp.next = newCurrent;
                temp = newCurrent;
            }
            current1 = current1.next;
            current2 = current2.next;
            count++;
        }

        return ret;
    }
}
