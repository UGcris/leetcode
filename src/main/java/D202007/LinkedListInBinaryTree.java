package D202007;

import TOIN.ListNode;
import TOIN.TreeNode;

/**
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * <p>
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 * <p>
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 解释：树中蓝色的节点构成了与链表对应的子路径。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：false
 * 解释：二叉树中不存在一一对应链表的路径。
 *  
 * <p>
 * 提示：
 * <p>
 * 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
 * 链表包含的节点数目在 1 到 100 之间。
 * 二叉树包含的节点数目在 1 到 2500 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/22
 **/
public class LinkedListInBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (null == root) return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    /**
     * 逐一匹配
     *
     * @param head
     * @param root
     * @return
     */
    private boolean dfs(ListNode head, TreeNode root) {
        if (null == head) return true;
        if (null == root) return false;
        if (head.val != root.val) return false;
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }

    /**
     * error code
     *
     * @param head
     * @param root
     * @param base
     */
    boolean ans = false;

    private void isSubPath(ListNode head, TreeNode root, ListNode base) {
        if (null == head) ans = true;
        if (!ans && null != head && null != root) {
            ListNode next = base;
            if (root.val == head.val) {
                next = head.next;
            } else if (root.val == base.val) {
                next = base.next;
            }
            isSubPath(next, root.left, base);
            isSubPath(next, root.right, base);
        }
    }
}
