import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length -2; i++){
            if(nums[i] > 0) break;
            if (i> 0 && nums[i] == nums[i-1]) continue;

            int low = i + 1;
            int high = nums.length - 1;


            while (low < high){
                int sum = nums[low] + nums[high] + nums[i];
                if (sum > 0) {
                   high--;
                } else if (sum < 0){
                   low++;
                } else {
                   List<Integer> result = new ArrayList<>();
                   result.add(nums[i]);
                   result.add(nums[low]);
                   result.add(nums[high]);
                   results.add(result);

                   while (low < high && nums[low] == nums[low + 1]) {
                      low++;
                   }

                   while (low < high && nums[high] == nums[high - 1]) {
                      high--;
                   }

                   low++;
                   high--;
                }
            }
        }
        
        return results;
    }
}
