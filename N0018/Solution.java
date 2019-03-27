import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4)
            return results;

        Arrays.sort(nums);

        if (4 * nums[0] > target || 4 * nums[len-1] < target)
            return results;
 
        int sum;
        int max = nums[len-1];

        for (int i = 0; i < len - 3; i++) {
            int z = nums[i];
            if (i > 0 && z == nums[i-1]) continue; // avoid repeating result

            if (z + 3 * max < target) continue; // sum is too small
            if (z * 4 > target) continue; // sum is too large
            if (z * 4 == target) { // z is the boundary
               if (i + 3 < len && nums[i + 3] == z)
                  results.add(Arrays.asList(z, z, z, z));
               break;
            }
            
            for (int j = i + 1; j < len - 2; j++) {
               if (j > i + 1 && nums[j] == nums[j-1]) continue;
               int newtarget = target - nums[i] - nums[j];

               int minTwoSum = nums[j+1] + nums[j+2];
               int maxTwoSum = nums[len-1] + nums[len-2];
               if (minTwoSum > newtarget || maxTwoSum < newtarget) continue;

               int low = j + 1;
               int high = len -1;

               while (low < high){
                  sum = nums[low] + nums[high];
                  if (sum < newtarget){
                     while (low < high && nums[low] == nums[low+1]) low++;
                     low++;
                  } else if (sum > newtarget) {
                     while (low < high && nums[high] == nums[high-1]) high--;
                     high--;
                  } else {
                     List<Integer> result = new ArrayList<>();
                     result = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                     results.add(result);
                     while (low < high && nums[low] == nums[low+1]) low++;
                     while (low < high && nums[high] == nums[high-1]) high--;
                     low++;
                     high--;
                  }
               }
            }
        }

        return results;
    }

}
