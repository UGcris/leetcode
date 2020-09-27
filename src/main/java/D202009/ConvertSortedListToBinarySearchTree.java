package D202009;

import TOIN.ListNode;
import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/9/27
 **/
public class ConvertSortedListToBinarySearchTree {
    /**
     * version 1
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (null != head) {
            list.add(head.val);
            head = head.next;
        }
        return build(list, 0, list.size());
    }

    private TreeNode build(List<Integer> list, int begin, int end) {
        if (begin < 0 || end < 0 || begin > end) {
            return null;
        }
        int mid = begin + (end - begin) / 2 + (end - begin) % 2;
        return new TreeNode(list.get(mid), build(list, begin, mid - 1), build(list, mid + 1, end));
    }

    /**
     * version 2 from others
     */
    ListNode assignHead;
    public TreeNode sortedListToBST(ListNode head) {
        assignHead = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return dfs(1, len);
    }

    TreeNode dfs(int index, int n) {
        if (index > n) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.left = dfs(index * 2, n);
        if (assignHead == null) {
            return null;
        }
        root.val = assignHead.val;
        assignHead = assignHead.next;
        root.right = dfs(index * 2 + 1, n);
        return root;
    }
}
