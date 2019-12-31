/*
Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

 Example:
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].
*/

public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        if(a == null || a.size()==0) return 0;
        if(a.size()<2) return a.size();
        int i=0;
        int j=0;
        while(j<a.size()-1){
            while(j<a.size()-1 && a.get(j).equals(a.get(j+1)))j++;
            j++;
            i++;
            if(j<a.size()){
                a.set(i,a.get(j));
            }
        }
        if(j==a.size()-1) {
            i++;
            if(i<a.size())
            a.set(i,a.get(j));
        }
        return i;
    }
}
