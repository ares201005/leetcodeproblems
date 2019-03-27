import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> maps = new HashMap<Character, Character>();
        maps.put(')', '(');
        maps.put('}', '{');
        maps.put(']', '[');


        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);


           // if the current character is a closing braket
           if (maps.containsKey(c)) {
               // Get the top element of the stack
               char Element = stack.empty() ? '#' : stack.pop();
               
               if (Element != maps.get(c)) return false;
           } else {
             stack.push(c);
           }
        }
        return stack.isEmpty();
    }
}
