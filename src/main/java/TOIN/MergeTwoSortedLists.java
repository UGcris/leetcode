package TOIN;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/9/24
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=null;
        if(null!=l1||null!=l2){
            if(null==l2||(null!=l1&&l1.val<=l2.val)){
                result=new ListNode(l1.val);
                l1=l1.next;
            }else {
                result=new ListNode(l2.val);
                l2=l2.next;
            }
            ListNode temp=result;
            while (null!=l1||null!=l2){
                ListNode node=null;
                if(null==l2||(null!=l1&&l1.val<=l2.val)){
                    node=new ListNode(l1.val);
                    l1=l1.next;
                }else {
                    node=new ListNode(l2.val);
                    l2=l2.next;
                }
                temp.next=node;
                temp=node;
            }
        }
        return result;
    }

}
