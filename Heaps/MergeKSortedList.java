/*
Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 
public class Solution {
	
	public ListNode mergeKLists1(ArrayList<ListNode> a) {
	    int j=a.size()-1;
	    while(j!=0){
	    int i=0;
	    while(i<j){
	            a.set(i,sortedMerge(a.get(i),a.get(j)));
	            i++;
	            j--;
	        }
	     }
	     return a.get(0);
	}
	
	private ListNode sortedMerge(ListNode a,ListNode b){
	    if(a==null && b==null) return a;
	    if(a==null) return b;
	    if(b==null) return a;
	    if(a.val>b.val) return sortedMerge(b,a);
	    ListNode res = a;
	    ListNode tempRes=res;
	    ListNode tempA= a;
	    ListNode tempB= b;
	    tempA = tempA.next;
	    while(tempA!=null && tempB!=null){
	        if(tempA.val<=tempB.val){
	            tempRes.next = tempA;
	            tempA=tempA.next;
	        }
	        else{
	            tempRes.next =tempB;
	            tempB=tempB.next;
	        }
	        tempRes=tempRes.next;
	    }
	    while(tempA!=null){
	       tempRes.next = tempA;
           tempA=tempA.next;
           tempRes=tempRes.next;
	     }
	    while(tempB!=null){
           tempRes.next = tempB;
           tempB=tempB.next;  
           tempRes=tempRes.next;
        }
	    return res;
	}
	
	public ListNode mergeKLists2(ArrayList<ListNode> a) {
	    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
	        new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        
	    ListNode result = new ListNode(-1);
	    ListNode tempRes= result;
	    for(int i=0;i<a.size();i++){
	        minHeap.offer(a.get(i));
	    }
	    while(!minHeap.isEmpty()){
	        ListNode minNode = minHeap.poll();
	        tempRes.next = new ListNode(minNode.val);
	        tempRes = tempRes.next;
	        if(minNode.next!=null) minHeap.offer(minNode.next);
	    }
	    return result.next;
	}
}
