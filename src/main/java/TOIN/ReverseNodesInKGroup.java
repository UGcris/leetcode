package TOIN;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/24
 **/
public class ReverseNodesInKGroup {
    /**
     * 递归调用
     * 栈
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<2) return head;
        boolean isDivisible=true;
        int index=k;
        ListNode temp=head;
        while (index>=0){
            if(null==temp) return head;
            else index--;temp=temp.next;
        }
        temp=head;
        ListNode[] array=new ListNode[k];
        for (int i = 0; i < k; i++) {
            array[i]=temp;
            temp=temp.next;
        }
        ListNode result = array[k-1];
        ListNode node=result;
        for (int i = k-2; i >=0; i--) {
            node.next=array[i];
            node=array[i];
        }
        node.next = reverseKGroup(temp,k);
        return result;
    }
}
