package D202007;

import TOIN.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/2
 **/
public class PalindromeLinkedList {

    /**
     * 结果并不理想
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        StringBuffer str = new StringBuffer();
        StringBuffer reverse = find(head, str);
        return str.toString().equals(reverse.toString());
    }

    private StringBuffer find(ListNode head, StringBuffer str) {
        StringBuffer result = new StringBuffer();
        if (null != head) {
            str.append(head.val);
            result = find(head.next, str).append(head.val);
        }
        return result;
    }
}
