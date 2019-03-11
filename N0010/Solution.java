public class Solution{
    public boolean isMatch(String s, String p) {
       if (s == p) return true;       
       if (s == null || p == null){
          return false;
       }

       int lens = s.length();
       int lenp = p.length();
       boolean[][] dp = new boolean[lens + 1][lenp + 1];
       // dp[i][j] represents if the first i-st character (index is i-1) 
       // in s can match the first j-th (index is j-1) character in p;

       dp[0][0] = true;  // empty string matches empty pattern

       /* dp[i][0] should be false since empty pattern cannot match non-empty string
          dp[0][j] can be true, if the pattern string is x*x*x* or x*x*x**
          i.e., index of *in p should be 2*n+1 or lenp - 1, then j should be even or lenp
       */
       
       for (int j = 2; j < lenp + 1; j += 1){
           if (p.charAt(j - 1) == '*' && dp[0][j - 2]){
              dp[0][j] = true;
           }
       }

       if (lenp > 1 && p.charAt(lenp - 1) == '*' && dp[0][lenp - 2]){
           dp[0][lenp-1] = true;
       }

       for (int i = 1; i < lens + 1; i++){
          for (int j = 1; j < lenp + 1; j++){
             if (p.charAt(j-1) == '.'){
                dp[i][j] = dp[i-1][j-1];
             }
             if (p.charAt(j-1) == s.charAt(i-1)){
                dp[i][j] = dp[i-1][j-1];
             }
             if (p.charAt(j-1) == '*' ){
                 if (p.charAt(j-2) != '.' && p.charAt(j-2) != s.charAt(i-1)){
                     dp[i][j] = dp[i][j-2];
                 }else{
                     dp[i][j] = (dp[i][j-2] || dp[i][j-1] || dp[i-1][j]);
                 }
             }
          }
       }
       
       return dp[lens][lenp]; 
    }

   public static void main(String[] args){
      Solution s = new Solution();

      String s0 = "abc";
      String p0 = "abc";

      boolean result = s.isMatch(s0,p0);

      //System.out.println("isMatch="+result);

   }
}

