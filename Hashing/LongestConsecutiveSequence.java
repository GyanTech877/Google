/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example:
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
public class Solution {
    public int longestConsecutive(final List<Integer> A) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.size();i++){
            if(map.containsKey(A.get(i))) continue;
            int leftLength = map.containsKey(A.get(i)-1)?map.get(A.get(i)-1):0;
            int rightLength = map.containsKey(A.get(i)+1)?map.get(A.get(i)+1):0;
            int sum = leftLength+rightLength+1;
            res = Math.max(res,sum);
            map.put((A.get(i)-leftLength),sum);
            map.put((A.get(i)+rightLength),sum);
            map.put(A.get(i),sum);
        }
        return res;
    }
}
