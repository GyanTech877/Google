/*
Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3
*/

class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }
 
public class Solution {
    public ListNode insertionSortList(ListNode A) {
        if(A == null || A.next == null ) return A;
        ListNode result = new ListNode(0);
        ListNode prev = result;
        ListNode curr = A;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            while(prev.next!=null && prev.next.val<curr.val) prev = prev.next;
            curr.next = prev.next;
            prev.next = curr;
            prev = result;
            curr = next;
        }
        
        return result.next;
    }
}
