
import java.util.HashMap;

public class Solution {

   // manchester algorithm    
   public String longestPalindrome(String s) {
      if (s == null) throw new java.lang.IllegalArgumentException();

      String res = pre(s);
      System.out.println(res);

      int C = 0, R = 0;
      int len = res.length();
      int[] p = new int[len];

      for (int i = 0; i < len; i++){
         p[i] = 0;
      }

      for (int i = 1; i < len-1; i++){
         int imirror = 2*C -1;
         System.out.println("i, imirror/C="+i+" "+imirror+" "+C);
         p[i] = (R >i) ? Math.min(R-i,p[imirror]) : 0;


         while (i-1-p[i] >= 0 && i+1+p[i] < len && res.charAt(i+1+p[i]) == res.charAt(i-1-p[i])){
           p[i]++;
         }
         
         if (i + p[i] > R){
            C = i;
            R = i + p[i];
         }
      }

      int maxLen = 0;
      int cindex = 0;
      for (int i = 0; i < len - 1; i++){
         if (p[i] > maxLen){
           maxLen = p[i];
           cindex = i;
         }
      }


      int lo = (cindex-1-maxLen)/2;
      int end = lo + maxLen;
      System.out.println("maxlen/cindex = "+maxLen+" "+cindex);
      System.out.println("lo/end = " + lo + " " + end);
      

      return s.substring(lo, end);
   }


   // ******************************
   private String pre(String s){
      int len = s.length();
      if (len < 2) return s;       
      
      String res = "";
      for (int i = 0; i < len; i ++){
         res += "#" + s.charAt(i);
      }
     res += "#";
     return res;
   }


   /*
     **************** approach 3 *************** 
     unfinished 
   */ 
   
   public String longestPalindrome3(String s) {
       if (s == null || s.length() < 1) return "";
       if (s.length() == 1) return s;

       int len = s.length();
       String result = "";

       int max = 1;

       boolean[][] pij = new boolean[len][len];

       for (int j = 0; j < len; j++){
          for (int i = 0; i <= j; i++){
             boolean isPalindrome = s.charAt(i) == s.charAt(j);
             
             if ( j - i <= 2){ //true if isPandinlrom and length (j-i+1) is <= 3
                pij[i][j] = isPalindrome;
             } else {
               pij[i][j] = pij[i+1][j-1] && isPalindrome;
             }

             if (pij[i][j] && j-i+1 > max){
                max = j - i + 1;
                result = s.substring(i,j+1);
             }
          }
       }

       System.out.println("max length of palindrom string="+max);
       return result;

   }

   //*****************Appraoch 4, expand around center
   public String longestPalindrome4(String s) {
       if (s == null || s.length() < 1) return "";
       int start = 0, end = 0;
       for (int i = 0; i < s.length(); i++) {
           int len1 = expandAroundCenter(s, i, i);
           int len2 = expandAroundCenter(s, i, i + 1);
           int len = Math.max(len1, len2);
           if (len > end - start) {
               start = i - (len - 1) / 2;
               end = i + len / 2;
           }
       }
       return s.substring(start, end + 1);
   }
   
   private int expandAroundCenter(String s, int left, int right) {
       int L = left, R = right;
       while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
           L--;
           R++;
       }
       return R - L - 1;
   }



   public static void main(String[] args){
        Solution ns = new Solution();
        String s = args[0];
        //String subs = ns.longestPalindrome(s);
        String subs = ns.longestPalindrome3(s);

        System.out.println("largest palindromic substring = " + subs);
   }

}
