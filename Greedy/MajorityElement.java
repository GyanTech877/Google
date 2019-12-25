/*
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 
*/

 public int majorityElement(final int[] A) {
        if(A ==null || A.length == 0) return -1;
        int majElement = A[0];
        int count = 1;
        for(int i=1;i<A.length;i++){
            if(A[i]==majElement) count ++;
            else count--;
            if(count==0){
              majElement = A[i];
              count = 1;
            }
        }
        return majElement;
 }
