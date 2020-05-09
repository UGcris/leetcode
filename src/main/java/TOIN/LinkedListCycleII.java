package TOIN;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/11/3
 **/
public class LinkedListCycleII {
    /**
     * 笨方法
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        List<ListNode> nums=new ArrayList<>();
        ListNode temp=head;
        while(null!=temp){
            if(nums.contains(temp)){
                return temp;
            }
            nums.add(temp);
            temp=temp.next;
        }
        return null;
    }

    /**
     * Floyd 算法
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast=head,slow=head;
        while (null!=fast&&null!=slow){
            if(fast==slow) break;
            slow=slow.next;
            fast=null!=fast.next?fast.next.next:null;
        }
        if(null!=fast&&null!=slow&&fast==slow){
            fast=head;
            while (fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            return fast;
        }
        return null;
    }
}
