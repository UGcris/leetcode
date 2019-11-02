/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/11/1
 **/
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(null==head||null==head.next) return head;
        ListNode result=new ListNode(0);
        ListNode tempNode=result;
        int temp=0==head.val?1:0;
        while (null!=head){
            if(head.val!=temp&&(null==head.next||head.val!=head.next.val)){
                temp=head.val;
                tempNode.next=head;
                tempNode=head;
                head=head.next;
            }else {
                temp=head.val;
                head=head.next;
            }
        }
        tempNode.next=null;
        return result.next;
    }
}
