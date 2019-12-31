/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2)
*/

class Pair {
    int i;
    int j;
    int k;
    public Pair(int i,int j,int k){
        this.i = i;
        this.j = j;
        this.k = k;
    }
    public boolean equals(Object o){
        if(o==this) return true;
        if(!(o instanceof Pair)) return false;
        Pair p=(Pair)o;
        return ((this.i==p.i) && (this.j==p.j) && (this.k==p.k));
    }
    public int hashCode() {
       return Objects.hash(this.i,this.j,this.k);
    }
}
public class Solution {
    public int[][] threeSum(int[] A) {
        if(A==null || A.length ==0) return new int[][]{};
        Arrays.sort(A);
        Set<Pair> resultSet = new HashSet<>();
        for(int i=0;i<A.length-2;i++){
            int j = i+1;
            int k = A.length-1;
            while(j<k){
                if((A[i]+A[j]+A[k])==0){
                    resultSet.add(new Pair(A[i],A[j],A[k]));
                    j++;
                    k--;
                }
                else if((A[i]+A[j]+A[k])>0) k--;
                else j++;
            }
        }
        int[][] result = new int[resultSet.size()][3];
        int i = 0;
        for(Pair p:resultSet){
            result[i][0] = p.i;
            result[i][1] = p.j;
            result[i][2] = p.k;
            i++;
        }
        return result;
    }
}
