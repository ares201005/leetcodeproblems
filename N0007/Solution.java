class Solution {
    public int reverse(int x) {
       int result = 0;

       int xcopy = x;
       int tail = 0;

       int res = 0;
       while (xcopy !=0){
          tail = xcopy % 10;
          res = result;
          result = result * 10 + tail;
          if( (result-tail)/10 != res )
              return 0;
           
          xcopy = xcopy / 10;
       }

       return result;
    }
}
