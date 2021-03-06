package D202009;

import TOIN.TreeNode;

/**
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/9/20
 **/
public class SumOfLeftLeaves {
    private int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (null != root) {
            if (null != root.left && null == root.left.left && null == root.left.right) {
                ans += root.left.val;
            }
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);
        }
        return ans;
    }
}
