package TOIN;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/11/3
 **/
public class AddTwoNumbersII {
    /**
     * 一个list<List>存岔开相加的值
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null==l1||0==l1.val) return l2;
        if(null==l2||0==l2.val) return l1;
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        while (null!=l1){
            list1.add(l1.val);
            l1=l1.next;
        }
        while (null!=l2){
            list2.add(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode result=null;
        for (int i = list1.size()-1,j=list2.size()-1; i >=0||j>=0 ; i--,j--) {
            int val=(i>=0?list1.get(i):0)+(j>=0?list2.get(j):0)+carry;
            ListNode temp=new ListNode(val%10);
            temp.next=result;
            result=temp;
            carry=val/10;
        }
        if(0!=carry){
            ListNode temp=new ListNode(carry);
            temp.next=result;
            return temp;
        }
        return result;
    }
}
