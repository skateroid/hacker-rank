package leetcode.binerytreegeneral;

public class SameTree {
    public static void main(String[] args) {
        var leftSecondLeft = new TreeNode(2);
        var leftRoot = new TreeNode(1, leftSecondLeft, null);
        var rightSecondRight = new TreeNode(2);
        var rightRoot = new TreeNode(1, null, rightSecondRight);
        System.out.println(isSameTree(leftRoot, rightRoot));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null & q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
