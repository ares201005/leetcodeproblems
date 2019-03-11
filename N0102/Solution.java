import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        level(res, root, 0);
        return res;
    }

    private void level(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) return;

        if (level >= res.size()) {
           res.add(new LinkedList<Integer>());
        }
        res.get(level).add(node.val);
        level(res, node.left, level + 1);
        level(res, node.right, level + 1);
    }
}

