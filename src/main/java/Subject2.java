public class Subject2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int temp=0;
//        int index=0;
//        ListNode result=new ListNode(0);
//        ListNode resultRoot=result;
//        while(null!=l1||null!=l2){
//            if(null!=l1){
//                temp+=l1.val;
//                l1=l1.next;
//            }
//            if(null!=l2){
//                temp+=l2.val;
//                l2=l2.next;
//            }
//            resultRoot.next=new ListNode(temp%10);
//            resultRoot=resultRoot.next;
//            temp=temp/10;
//        }
//        if(temp!=0){
//            resultRoot.next=new ListNode(temp);
//        }
//        return result.next;
//    }
}
