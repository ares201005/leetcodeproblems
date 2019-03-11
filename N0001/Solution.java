////package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution{

   public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
           map.put(nums[i], i);
       }
       for (int i = 0; i < nums.length; i++) {
           int complement = target - nums[i];
           if (map.containsKey(complement) && map.get(complement) != i) {
               return new int[] { i, map.get(complement) };
           }
       }
       throw new IllegalArgumentException("No two sum solution");
   }

   //
   public static void main(String[] args){
      Solution ns = new Solution();

      int[] a = {10, 2, 5, 6, 7, 9, 3 , 5, 3, 1, 0, 11, 20, 31, 44, 32, 21, 22, 23, 32, 16, 18, 19, 10};
      int[] b = ns.twoSum(a,8);

      System.out.println(b[0]+" "+b[1]);
   }

}
