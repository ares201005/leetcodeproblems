////package leetcode;

//import java.util.Map;

public class Solution{

   public class ListNode{
      int val;
      ListNode next;
      ListNode(int x){
         val = x;
      }

      private void print(){
         ListNode ncopy = this;
         while (ncopy != null){
            System.out.print(ncopy.val);
            ncopy = ncopy.next;
         }
         System.out.println("");
      }
   }

   public ListNode addTwoNumbers(ListNode l1, ListNode l2){
      
      if (l1 == null && l2 == null) throw new IllegalArgumentException("L1/2 is null");

      ListNode head = new ListNode(0);
      ListNode curr = head;
      ListNode p = l1;
      ListNode q = l2;

      int mode = 0;

      while (p != null || q != null) {
        int a = (p !=null) ? p.val : 0;
        int b = (q !=null) ? q.val : 0;

        int sum = a + b + mode;
        mode = sum / 10;
        curr.next = new ListNode(sum % 10);
//        System.out.println("q/pvalu="+a+" / "+b+" mode="+mode);
//        curr.print();
        curr = curr.next;
//        curr.print();
//        head.print();
  
        if (p != null) p = p.next;
        if (q != null) q = q.next;
      }         

      if (mode > 0) {
        curr.next = new ListNode(mode);
      }

      return head.next;
   }
   // 
   
   public static void main(String[] args){

      Solution s = new Solution();

      ListNode l1 = s.new ListNode(2);
      l1.next = s.new ListNode(5);
      l1.next.next = s.new ListNode(3);

      ListNode l2 = s.new ListNode(8);
      l2.next = s.new ListNode(4);

      l1.print();
      l2.print();

      ListNode l3 = s.addTwoNumbers(l1,l2);

      System.out.print("l3=");
      l3.print();

   }
}
