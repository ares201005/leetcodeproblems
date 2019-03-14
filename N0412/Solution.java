import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    // use string concatention
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        for (int i = 1, nFizz = 0, nBuzz = 0; i <= n; i++){
            nFizz++;
            nBuzz++;
            String str = "";
            if (nFizz == 3) {
                str += "Fizz";
                nFizz = 0;
            }
            if (nBuzz == 5) {
                str += "Buzz";
                nBuzz = 0;
            }
            if (str == "") {
                str = Integer.toString(i);
            }

            res.add(str);
        }
        return res;
    }

    // use hash table

    public List<String> fizzBuzz2(int n) {
        List<String> res = new ArrayList<String>();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");

        for (int i = 1, nFizz = 0, nBuzz = 0; i <= n; i++){
            String str = "";
            for (Integer k : map.keySet()) {
                if (i % k == 0) str += map.get(k);
            }
            if (str == "") str = Integer.toString(i);
            res.add(str);
        }
        return res;
    }
}
