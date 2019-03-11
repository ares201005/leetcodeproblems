class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        if (str == null || len ==0) return 0;
        
        int index = 0;
        int ans = 0, tmp=0;
        int res = 0;
        int sign = 1;
        while ( index < len && str.charAt(index) == ' '){
            index++;
            if (index >= len) return 0;
        }
        
        if (str.charAt(index) == '-'){
            sign = -1;
            index++;
        } else if (str.charAt(index) == '+'){
            index++;
        }
        
        while (index < len){
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;            
            res = str.charAt(index) - '0';
            tmp = ans;
            ans = 10 * ans + res;            
            if ( (ans-res)/10 != tmp || ans < 0 ){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }
        
        return ans*sign;
    }
}
