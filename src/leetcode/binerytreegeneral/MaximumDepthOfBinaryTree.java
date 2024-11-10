package leetcode.binerytreegeneral;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        var thirdLeft = new TreeNode(15);
        var thirdRight = new TreeNode(7);
        var secondLeft = new TreeNode(9, null, null);
        var secondRight = new TreeNode(20, thirdLeft, thirdRight);
        var root = new TreeNode(3, secondLeft, secondRight);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMax = depth(root.left, 1);
        int rightMax = depth(root.right, 1);

        return Math.max(leftMax, rightMax);
    }

    public static int depth(TreeNode node, int depth) {
        int maxDepth = depth;
        if (node != null) {
            maxDepth = Math.max(
                    depth(node.left, maxDepth + 1),
                    depth(node.right, maxDepth + 1));
        }
        return maxDepth;
    }
}
