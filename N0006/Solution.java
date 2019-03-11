
import java.util.List;
import java.util.ArrayList;

public class Solution {
   // visit by row
   public String convert(String s, int numRows) {
      if (numRows == 1) return s;   

      // characters in row 0 are located at k (2*numRows - 2)
      StringBuilder news = new StringBuilder();
      int len = s.length();
      int step = 2 * numRows - 2;

      for (int i = 0; i < numRows; i++){
         for (int j = 0; j + i < len; j += step){
           news.append(s.charAt(j + i));
           if (i != 0 && i != numRows -1 && j + step - i < len){
              news.append(s.charAt(j + step - i));
           }
         }
      }
      return news.toString();
   }


   // sort by row
   public String convert2(String s, int numRows) {
      if (numRows == 1) return s;

      /*
      Iterate through s from left to right, appending each character to 
      the appropriate row. The appropriate row can be tracked using two 
      variables: the current row and the current direction.

      The current direction changes only when we moved up to the topmost row or 
      moved down to the bottommost row.
      */

      List<StringBuilder> rows = new ArrayList<>();
      for (int i = 0; i < Math.min(numRows, s.length()); i++)
          rows.add(new StringBuilder());

      int curRow = 0;
      boolean goingDown = false;

      for (char c : s.toCharArray()) {
          rows.get(curRow).append(c);
          if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
          curRow += goingDown ? 1 : -1;
      }

      StringBuilder ret = new StringBuilder();
      for (StringBuilder row : rows) ret.append(row);
      return ret.toString();
   }
 
   public static void main(String[] args){
      String s = "PAYPALISHIRING";
      Solution ns = new Solution();

      String news = ns.convert2(s,3);
      //String news = ns.convert(s,3);

      System.out.println("converted s="+news);
   }

}
