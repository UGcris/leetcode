package TOIN;

import java.util.*;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/9/24
 */

public class MergekSortedLists {
    /**
     * 投机取巧
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result=null;
        if(lists.length>0){
            List<Integer> valList=new ArrayList<>();
            for (ListNode node:lists) {
                do{
                    valList.add(node.val);
                    node=node.next;
                }while (null!=node);
            }
            if(valList.size()>0){
                Integer[] valArray=valList.toArray(new Integer[0]);
                Arrays.sort(valArray);
                result=new ListNode(valArray[0]);
                ListNode temp=result;
                for (int i = 1; i < valArray.length; i++) {
                    ListNode node=new ListNode(valArray[i]);
                    temp.next=node;
                    temp=node;
                }
            }
        }
        return result;
    }

    /**
     * 递归的思路，有点归并排序的意思
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int size=lists.length;
        if(size<=0){
            return null;
        }
        return mergeList(lists,0,size-1);
    }

    /**
     * 合并list中的部分
     * from begin
     * to end
     * @param lists
     * @param begin
     * @param end
     * @return
     */
    private ListNode mergeList(ListNode[] lists, int begin, int end) {
        if(begin==end){
            return lists[begin];
        }
        if(begin==end-1){
            merge2List(lists[begin],lists[end]);
        }
        return merge2List(mergeList(lists,begin,(begin+end)/2),mergeList(lists,(begin+end)/2+1,end));
    }

    /**
     * 合并两个ListNode
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge2List(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
    }
}
