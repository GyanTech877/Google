/*
Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5
*/

class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; 
      }
 }

public class Solution {
    public ListNode sortList(ListNode A) {
        if(A==null || A.next == null) return A;
        ListNode prev = null;
        ListNode slow = A;
        ListNode fast = A;
        while(fast != null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return merge(sortList(A),sortList(slow));
    }
    private ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head;
        ListNode temp;
        if(l1.val<=l2.val){
            head = l1;
            l1=l1.next;
        }
        else{
            head = l2;
            l2=l2.next;
        }
        temp = head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next=l1;
                l1=l1.next;
            }
            else{
              temp.next = l2;
              l2= l2.next;
            }
            temp= temp.next;
        }
        while(l1!=null){
            temp.next=l1;
            l1=l1.next;
            temp=temp.next;
        }
        while(l2!=null){
            temp.next=l2;
            l2=l2.next;
            temp=temp.next;
        }
        return head;
    }
}
