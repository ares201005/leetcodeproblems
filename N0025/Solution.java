class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       if (head == null || head.next == null || k < 2)
          return head;

       ListNode start;
       ListNode aux;

       aux = new ListNode(0);
       aux.next = head;
       start = aux;

       int i = 0;
       while (head != null){
           i++;
           if (i % k == 0){
               start = reverse(start, head.next);
               head = start.next;
           } else {
               head = head.next;
           }
       }
       return aux.next;
    }

    private ListNode reverse(ListNode start, ListNode tail) {
        ListNode curr = start.next;
        ListNode next, first;
        ListNode prev = start;

        // start --> ... --> ... --> tail --> ...
        // ... --> tail--> ... --> start --> ...
        // ...
        // tail --> ... --> ... --> start --> ...

        first = curr;
        while (curr != tail) {
            next = curr.next;
            curr.next = prev;  //
            prev = curr;
            curr = next;
        }
        start.next = prev;
        first.next = curr;
        return first;
    }
}
