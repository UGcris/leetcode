package TOTO;

import TOIN.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 *
 * 提示：
 *
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/3/11
 **/
public class CousinsinBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean ans=false;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            boolean xExist=false;
            boolean yExist=false;
            for (int i = nodes.size(); i >0 ; i--) {
                TreeNode node=nodes.poll();
                if(null==node.left&&null==node.right){
                    continue;
                }
                if(null!=node.left&&(x==node.left.val||y==node.left.val)&&null!=node.right&&(x==node.right.val||y==node.right.val)){
                    return false;
                }
                if(null!=node.left){
                    xExist=xExist||x==node.left.val;
                    yExist=yExist||y==node.left.val;
                    nodes.add(node.left);
                }
                if(null!=node.right){
                    xExist=xExist||x==node.right.val;
                    yExist=yExist||y==node.right.val;
                    nodes.add(node.right);
                }
                if(xExist&&yExist){
                    return true;
                }
            }
        }
        return ans;
    }
}
