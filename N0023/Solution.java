
class Solution {
    // merge sort by divide and conquer

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeKLists(lists, 1, lists.length);
    }

    public ListNode mergeKLists(ListNode[] lists, int step, int size) {
       while ( step < size) {
          for (int i = 0; i < size - step; i += 2 * step) {
              lists[i] = mergeTwoLists(lists[i], lists[i+step]);
          }
          step = step * 2;
       }
       return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
