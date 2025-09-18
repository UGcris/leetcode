package D202507;

import TOIN.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/6/3
 **/
public class BinaryTreeMaximumPathSum {

   int ans=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int left=count(root.left);
        int right=count(root.right);
        int val=root.val;
        return max(ans,max(left+right,left,right,0)+val);
    }
    private int count(TreeNode root){
        if(null==root){
            return 0;
        }
        int left=count(root.left);
        int right=count(root.right);
        int val=root.val;
        ans=max(ans,max(left+right,left,right,0)+val);
        return max(left,right,0)+val;
    }

    private int max(int... arr) {
        int max=Integer.MIN_VALUE;
        for(int num:arr){
            max=Math.max(max,num);
        }
        return max;
    }


    public static void main(String[] args) {
        TreeNode root= TreeNode.builder().preorder(new Integer[]{9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6});
        System.err.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }

}
