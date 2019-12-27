/*
You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 
*/

public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int count1=0;
        int count2=0;
        int number1=Integer.MIN_VALUE;
        int number2=Integer.MIN_VALUE;
        for(int i=0;i<a.size();i++){
            if(number1 == a.get(i)) count1++;
            else if(number2 == a.get(i)) count2++;
            else{
             if(count1==0) {
                 count1++;
                 number1 = a.get(i);
             }
             else if(count2==0){
                count2++;
                number2 = a.get(i);
             }
             else{
                count1--;
                count2--;
             }
            }
        }
        if(count1<=0 && count2<=0) return -1;
        if(count1>0){
            count1=0;
            for(int i=0;i<a.size();i++){
                if(a.get(i)==number1){
                    count1++;
                }
            }
            if(count1>a.size()/3) return number1;
        }
        if(count2>0){
            count2=0;
            for(int i=0;i<a.size();i++){
                if(a.get(i)==number2){
                    count2++;
                }
            }
            if(count2>a.size()/3) return number2;
        }
        return -1;
    }
}
