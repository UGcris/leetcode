package TOTO;

import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/26
 **/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(null!=root){
            next(root.left,ans,0);
        }
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
