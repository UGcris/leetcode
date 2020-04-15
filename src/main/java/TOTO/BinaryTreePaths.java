package TOTO;

import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/4/15
 **/
public class BinaryTreePaths {
    private final String connector="->";

    /**
     * 糟糕的递归,换stringbuffer拼接字符串比较好些
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        if(null!=root){
            String pre=new String();
            pre+=root.val;
            List<String> left=binaryTreePaths(root.left);
            List<String> right=binaryTreePaths(root.right);
            if(left.isEmpty()&&right.isEmpty()){
             ans.add(pre);
            }
            if(!left.isEmpty()){
                for (String str:left ) {
                    ans.add(pre+connector+str);
                }
            }
            if(!right.isEmpty()){
                for (String str:right ) {
                    ans.add(pre+connector+str);
                }
            }
        }
        return ans;
    }
}
