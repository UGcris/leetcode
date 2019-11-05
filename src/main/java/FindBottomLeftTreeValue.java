import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *  
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/11/4
 **/
public class FindBottomLeftTreeValue {
    /**
     * queue 平常真是少用到。。。
     * 大佬还是大佬
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    int max = Integer.MIN_VALUE;
    int res ;
    public int findBottomLeftValue2(TreeNode root) {
        DFS(root,0);
        return res;
    }
    public void DFS(TreeNode root,int n){
        if(root == null ) return ;
        if(root.left == null && root.right == null){
            if( n > max ) {
                res = root.val;
                max = n;
            }
        }
        DFS(root.left,n + 1);
        DFS(root.right,n + 1);
    }
}
