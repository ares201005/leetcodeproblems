public class Solution {
    public String intToRoman(int num) {
        String result = "";
        int a = num;
        
        String roman[][] = { {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                             {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},        
                             {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                             {"", "M", "MM", "MMM", "",    "",  "",   "",   "",     ""}
                           };
        
        int i = 0;
        int res = 0;
        while (a>0){
            res = a % 10;
            a = a / 10;
            result = roman[i][res] + result;
            i++;
        }
        return result;
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        Solution s = new Solution();
    
        String result;
        result = s.intToRoman(n);
        System.out.println("Roman(n)="+result);
    }
   
}

