
class Solution {
    // two pass algorithm,
    // firstly, find the length L
    public ListNode removeNthFromEnd(ListNode head, int n) {

       // create an auxiliary node, pointing to the list head
       ListNode aux = new ListNode(0);
       aux.next = head;

       ListNode first = head;
       int L = 0;
       while (first != null) {
          L++;
          first = first.next;
       }

       // the nth node from the end is the L-n+1 th node from the begining
       // the corresponding index is L-n
       int m = L - n;

       first = aux;
       while (m > 0) {
          m--;
          first = first.next;
       }
       first.next = first.next.next;
       
       return aux.next;
        
    }

    // one pass algorithm,
    public ListNode removeNthFromEnd2(ListNode head, int n) {

       // create an auxiliary node, pointing to the list head
       ListNode aux = new ListNode(0);
       aux.next = head;

       // making two pointers separated by n nodes apart
       ListNode first = aux;
       ListNode second = aux;
       int L = 0;
       // start the first pointer first so that the gap between
       // the two pointers is n node
       for (int i = 0; i <= n; i++) {
          first = first.next;
       }

       // move the first to the end, then the second pointer is at the n+1-th node from the ned
       while (first != null) {
          first = first.next;
          second = second.next;
       }
       second.next = second.next.next;
       
       return aux.next;
    }        
}
