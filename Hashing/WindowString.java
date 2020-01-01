/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
*/

public class Solution {
    public String minWindow(String A, String B) {
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int[] hash = new int[128];
        for(int i=0;i<B.length();i++){
            hash[B.charAt(i)]++;
        }
        int minStart = 0;
        int counter = B.length();
        while(end<A.length()){
            if(hash[A.charAt(end)]>0) counter--;
            hash[A.charAt(end)]--;
            end++;
            while(counter==0){
              if((end-start)<minLength){
                minLength = end-start;  
                minStart = start; 
              }
              hash[A.charAt(start)]++;
              if(hash[A.charAt(start)]>0) counter++;
              start++;
            }
        }
        return (minLength==Integer.MAX_VALUE)?"":A.substring(minStart,minStart+minLength);
    }
}
