import java.util.HashMap;

public class pushTest {

    public static ListNode removedulicate1(ListNode head) {
        if (head == null) {
            return head;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            if (!map.containsKey(temp.val)) {
                map.put(temp.val, temp.val);
                pre = temp;
                temp = temp.next;
            } else {
                pre.next = temp.next;
                temp = temp.next;
            }
        }
        return head;
    }

    public static ListNode removedulicate2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode point1 = head;
        ListNode point2 = point1.next;
        ListNode pre = point1;

        while (point1 != null) {
            while (point2 != null) {
                if (point2 != null && point1.val == point2.val) {
                    pre.next = point2.next;
                    point2 = pre.next;
                } else {
                    pre = point2;
                    point2 = point2.next;
                }

            }
            point1 = point1.next;
            pre = point1;
            if (point1 != null) {
                point2 = point1.next;
            }
        }
        return head;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(6);
        ListNode l9 = new ListNode(3);
        ListNode l10 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        ListNode l = removedulicate1(l1);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
