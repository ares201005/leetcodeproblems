import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final int[] R2int = new int[26];
    public int romanToInt(String s) {
        R2int['I' - 'A'] = 1;
        R2int['V'-'A'] = 5;
        R2int['X'-'A'] = 10;
        R2int['L'-'A'] = 50;
        R2int['C'-'A'] = 100;
        R2int['D'-'A'] = 500;
        R2int['M'-'A'] = 1000;

        int len = s.length();
        int n;
        int next = 0;
        int result = 0;
        next = R2int[s.charAt(0) - 'A'];
        for (int i = 0; i < len - 1; i++){
            n = next;
            next = R2int[s.charAt(i+1) - 'A'];

            if (n < next) {
               result -= n;
            } else{
               result += n;
            }

            //System.out.println(s.charAt(i)+"="+next+" current result="+result);
        }       
        result += next;

        return result;
    }

    //using hash table
    public int romanToInt2(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int len = s.length();
        int n;
        int next = 0;
        int result = 0;
        next = map.get(s.charAt(0));
        for (int i = 0; i < len - 1; i++){
            n = next;
            next = map.get(s.charAt(i+1));
            if (n < next) {
               result -= n;
            } else{
               result += n;
            }

            System.out.println(s.charAt(i)+"="+next+" current result="+result+" next="+next);
        }       
        result += next;

        return result;
    }


    public static void main(String[] args){
        Solution s = new Solution();
    
        int result;
        int result2;
        result = s.romanToInt(args[0]);
        result2 = s.romanToInt2(args[0]);
        System.out.println("Roman(n)="+result);
        System.out.println("Roman(n)="+result2);
    }
   
}

