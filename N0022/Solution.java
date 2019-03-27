import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, "", 0, 0, n);
        return res;
    }
  
    private void backtrack(List<String> res, String current, int nopen, int nclose, int max)
    {
       if (current.length() == max * 2) {
          res.add(current);
          return;
       }
       
       if (nopen < max) {
          backtrack(res, current+'(', nopen + 1, nclose, max);
       } 
       
       if (nopen > nclose) {
          backtrack(res, current+')', nopen, nclose + 1, max);
       }
    }
}
