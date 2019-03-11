
import java.util.HashMap;

public class Solution {
    
    public int lengthOfLongestSubstring(String s) {
       if (s == null) throw new java.lang.IllegalArgumentException();
       int len = s.length();
       int max = 0;
       int index = -1;
       HashMap<Character, Integer> map = new HashMap<Character, Integer>();

       for (int i = 0; i < len; i ++){
           char current = s.charAt(i);
           if (map.containsKey(current))
              index = Math.max(map.get(current), index);

           map.put(current, i);
           max = Math.max(max, i - index);
       }
       
       return max;                     
    }


   public static void main(String[] args){
        Solution ns = new Solution();
        String s = args[0];

        int max = ns.lengthOfLongestSubstring(s);
        System.out.println("largest substring=" + max);
   }

}
