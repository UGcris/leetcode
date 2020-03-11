package TOTO;

import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/3/11
 **/
public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(null!=root){
            List<TreeNode> list= Arrays.asList(root);
            next(list,ans);
        }
        return ans;
    }
    private void next(List<TreeNode> rootList, List<Double> ans) {
        List<TreeNode> subList=new ArrayList<>();
        Double sum=0D;
        for (TreeNode node:rootList) {
            if(null!=node.left)subList.add(node.left);
            if(null!=node.right)subList.add(node.right);
            sum+=node.val;
        }
        ans.add(sum/rootList.size());
        if(subList.size()>0){
            next(subList,ans);
        }
    }
}
