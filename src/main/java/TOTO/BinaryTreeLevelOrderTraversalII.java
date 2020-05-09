package TOTO;

import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/27
 **/
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(null!=root){
            next(root,ans,0);
        }
        Collections.reverse(ans);
        return ans;
    }
    private void next(TreeNode root, List<List<Integer>> ans, int index) {
        List<Integer> list=ans.size()>index?ans.get(index):new ArrayList<>();
        list.add(root.val);
        if(ans.size()<=index){
            ans.add(list);
        }
        if(null!= root.left){
            next(root.left,ans,index+1);
        }
        if(null!=root.right){
            next(root.right,ans,index+1);
        }
    }
}
