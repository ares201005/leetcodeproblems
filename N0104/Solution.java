import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    // BFS solution
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        level(res, root, 0);
        return res;
    }

    private void level(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) return;

        if (level >= res.size()) {
           res.add(0, new LinkedList<Integer>());
        }
        level(res, node.left, level + 1);
        level(res, node.right, level + 1);
        res.get(res.size() - 1 - level).add(node.val);
    }


    // DFS solution
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) return res;

        queue.add(root);
        while (!queue.isEmpty()) {

        }
        return res;
    }

}
