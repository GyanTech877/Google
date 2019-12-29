/*
There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
 NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5 
*/

public class Solution {
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	    if(a==null || b==null || (a.size()==0 && b.size()==0)) return -1.00;
        if(a.size()>b.size()) return findMedianSortedArrays(b,a);
	    if(a.size()==0){
	       int size = b.size();
	       if(size%2==0){
	           return (b.get(size/2-1)+b.get(size/2))/2.00;
	       }
	       else{
	           return b.get(size/2);
	       }
	    }
	    int start = 0;
	    int end = a.size();
	    int length = (a.size()+b.size()+1)/2;
	    while(start<=end){
	        int midA = (start+end)/2;
	        int midB = length - midA;
	        int leftMidA=(midA==0)?Integer.MIN_VALUE:a.get(midA-1);
	        int leftMidB=(midB==0)?Integer.MIN_VALUE:b.get(midB-1);
	        int rightMidA=(midA==a.size())?Integer.MAX_VALUE:a.get(midA);
	        int rightMidB=(midB==b.size())?Integer.MAX_VALUE:b.get(midB);
	        if(leftMidA<=rightMidB && leftMidB<=rightMidA){
	            if((a.size()+b.size())%2==0){
	                return (Math.max(leftMidB,leftMidA) + Math.min(rightMidA,rightMidB))/2.00;
	            }
	            else{
	                return Math.max(leftMidB,leftMidA)*1.00;
	            }
	        }
	        else if(leftMidA>rightMidB){
	            end = midA-1;
	        }
	        else start = midA+1;
	    }
	    return -1.00;
	}
}
