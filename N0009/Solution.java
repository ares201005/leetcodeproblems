class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true; // true if 0<x<10;
        if (x !=0 && x % 10 == 0) return false;
        
        int reverse = 0;
        while (x > 0){
            reverse = reverse * 10 + x % 10;
            x = x/10;
            if (x == reverse || x/10 == reverse) return true;
            if (x < reverse) return false;
        }
        return x == reverse || x/10 == reverse;
    }
}
