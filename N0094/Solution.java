import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        inorder(res, root);
        return res;
    }

    private void inorder(List<Integer> res, TreeNode node) {
       if (node == null) return;
       inorder(res, node.left);
       res.add(node.val);
       inorder(res, node.right);
    }
}
