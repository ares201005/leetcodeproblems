
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Merge;
import java.util.Random;
import java.util.Arrays;

public class Solution {

   public static void main(String[] args){

      // generate two random arrys;
      int n1 = 1;
      int n2 = 2;

      int[] nums1 = new int[n1];
      int[] nums2 = new int[n2];

      nums1 = getRandomArray(1, 100, nums1.length);
      nums2 = getRandomArray(1, 100, nums2.length);

      Arrays.sort(nums1);
      Arrays.sort(nums2);

      for(int i = 0; i < nums1.length; i++){
        StdOut.println("i,nums1[i]="+i+" , "+ nums1[i]);
      }

      StdOut.println("\n"+"nums2");
      for(int i = 0; i < nums2.length; i++){
        StdOut.println("i,nums2[i]="+i+" , "+ nums2[i]);
      }

      Solution s = new Solution();
      double median = s.findMedianSortedArrays(nums1,nums2);

      StdOut.println("median="+median);
   }


   private static int[] getRandomArray(int min, int max, int size){
       int[] a = new int[size];
       Random r = new Random();
       for (int i = 0; i < size; i++){
          a[i] = r.nextInt((max - min) + 1) + min;
       }
       return a;
   }


   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int len1 = nums1.length;
       int len2 = nums2.length;
       int len = Math.min(len1, len2);

       // make sure A.size (len1) < B.size (len2)
       int[] A;
       int[] B;
       if(len1 > len2){
          B = nums1;
          A = nums2;
          len1 = nums2.length;
          len2 = nums1.length;
       } else{
          A = nums1;
          B = nums2;
       }

       
       int imin = 0; 
       int imax = len;
       int halflen = (len1 + len2 + 1)/2;
       while (imin <= imax){
          // set i = (imin+imax)/2 and j = (m+n+1)/2 -i
          // if B[j-1] < A[i] and A[i-1] < B[j]
          // then i is perfect
          // if B[j-1] > A[i], i is small, increase imin
          // if A[i-1] > B[j], j is small, decrease imax
          int i = (imin + imax)/2;
          int j = halflen -i;

          StdOut.println("i="+i + " j="+j);
          // i is small
          if ( i < imax && B[j-1] > A[i] ){
             imin = i + 1;
             StdOut.println("new imin="+imin);
          }
          else if (i > imin && A[i-1] > B[j]){
             // i is large
             imax = i - 1;
             StdOut.println("new imax="+imax);
          }
          else {
              // median is max(A[i-1],B[j-1]) if m+n is odd
              // is max(A[i-1],B[j-1]) + min(A[i],B[i]))/2 if m+n is even
              int left = 0;
              if (i == 0 ) {
                 left = B[j-1];
              }
              else if (j == 0) {
                 left = A[i-1];
              }
              else {
                 left = Math.max(A[i-1],B[j-1]);
              }

              int right = 0;
              if(i == len1) { right = B[j]; }
              else if(j == len2) { right = A[i]; }
              else {
                  right = Math.min(A[i],B[j]);
              }
              return (left + right)/2;
          }

       }
       return 0;
   }

}
