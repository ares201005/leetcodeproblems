import java.util.Stack;

class Solution {
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstPreorder(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode node = new TreeNode(A[i++]);

        node.left = bstPreorder(A, node.val);
        node.right = bstPreorder(A, bound);
        return node;
    }

    //stack solution
    public TreeNode bstFromPreorder2(int[] preorder) {
        if (preorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            // 
            if (preorder[i] < stack.peek().val) {
                stack.peek().left = node;
            } else {
                // found the parent node
                TreeNode parent = stack.peek();
                while(!stack.isEmpty() && stack.peek().val < preorder[i])
                    parent = stack.pop();
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}
