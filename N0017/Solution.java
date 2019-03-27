import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> result;
    private Map<String, String> phone;

    public List<String> letterCombinations(String digits) {
       result = new ArrayList<String>();
       phone = new HashMap<String, String>();

       phone.put("2", "abc");
       phone.put("3", "def");
       phone.put("4", "ghi");
       phone.put("5", "jkl");
       phone.put("6", "mno");
       phone.put("7", "pqrs");
       phone.put("8", "tuv");
       phone.put("9", "wxzy");

       String combination = "";
       if (digits.length() != 0) 
          backtrack("",digits);
       return result;
    }

    private void backtrack(String combination, String restdigits) {
       if (restdigits.length() == 0) {
          result.add(combination);
       } else {
          String digit = restdigits.substring(0,1);
          String letters = phone.get(digit);

          for (int i = 0; i < letters. length(); i++){
             String letter = letters.substring(i,i+1);
             backtrack(combination+letter, restdigits.substring(1));
          }
       }
    }
}

