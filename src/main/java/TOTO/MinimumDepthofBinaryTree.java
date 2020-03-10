package TOTO;

import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/3/10
 **/
public class MinimumDepthofBinaryTree {
    /**
     * 暴力递归
     */
    int deep=0;
    public int minDepth1(TreeNode root) {
        if(null!=root){
            List<TreeNode> list= Arrays.asList(root);
            next(list,1);
        }
        return deep;
    }
    private void next(List<TreeNode> rootList,  int index) {
        List<TreeNode> subList=new ArrayList<>();
        for (TreeNode node:rootList) {
            if(null==node.left&&null==node.right) {
                deep=index;
                subList.clear();
                break;
            }
            if(null!=node.left)subList.add(node.left);
            if(null!=node.right)subList.add(node.right);
        }
        if(subList.size()>0){
            next(subList,++index);
        }
    }

    public int minDepth(TreeNode root){
        if(root == null)return 0;
        if(root.left == null && root.right == null)return 1;

        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        else if(root.right == null){
            return minDepth(root.left) + 1;
        }
        else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
