import java.util.Deque;
import java.util.LinkedList;
class Solution {
    // push elements into stack, scan from left to right
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){
           TreeNode curr = new TreeNode(nums[i]);
           while (!stack.isEmpty() && stack.peek().val < nums[i]) {
               curr.left = stack.pop(); // remove element at the head
           }
           if (!stack.isEmpty()) {
               stack.peek().right = curr;
           }
           stack.push(curr); // add to the head
        }
        if (stack.isEmpty()) return null;
        return stack.removeLast(); // element at the tail
    }
}
