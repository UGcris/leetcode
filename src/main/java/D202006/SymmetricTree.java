package D202006;

import TOIN.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/6/6
 **/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(null==root) return true;
        return find(root.left,root.right);
    }

    private boolean find(TreeNode left, TreeNode right) {
        if(null==left&&null==right) return true;
        if(null!=left&&null!=right){
            if(left.val!=right.val) return false;
            return find(left.left,right.right)&&find(left.right,right.left);
        }
        return false;
    }
}
