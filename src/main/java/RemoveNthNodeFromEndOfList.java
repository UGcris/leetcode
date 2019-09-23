import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 * @Author UGcris
 * @date 2019/9/23
 **/
public class RemoveNthNodeFromEndOfList {
    /**
     * 找到顺数的index，将该node之前的node指向该node.next
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int size=0;
        while (null!=temp){
            size++;
            temp=temp.next;
        }
        int index=size-n;
        if(index<=0){
            return head.next;
        }

        int i=1;
        temp=head;
        while (i<index){
            temp=temp.next;
            i++;
        }
        if(index+1<size){
            temp.next=temp.next.next;
        }else {
            temp.next=null;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList=new RemoveNthNodeFromEndOfList();
        ListNode root=new ListNode(1);
        ListNode temp=root;
        for (int i=2;i<6;i++){
            ListNode child=new ListNode(i);
            temp.next=child;
            temp=child;
        }
        ListNode result=removeNthNodeFromEndOfList.removeNthFromEnd(root,4);
        while (null!=result){
            System.out.println(result.val);
            result=result.next;
        }
    }
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
