/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)
Sample Output :

2
You will be given 2 arrays X and Y. Each point is represented by (X[i], Y[i])
*/

public class Solution {
    public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        if(x.isEmpty()){
            return 0;
        }
        HashMap<String,Integer> slope = new HashMap<String,Integer>();
        int max = 0;
        for(int i =0;i<x.size();i++){
            int x1 = x.get(i);
            int y1 = y.get(i);
            int duplicates = 0;
            int localMax = 0;
            slope.clear();
            for(int j=i+1;j<x.size();j++){
                String key = "";
                int x2 = x.get(j);
                int y2 = y.get(j);
                if(x1==x2 && y1==y2){
                    duplicates++;
                    continue;
                }
                else if(x1==x2){
                    key = "Vertical";
                }
                else if(y1==y2){
                    key = "Horizontal";
                }
                else{
                    key = String.valueOf((1.0)*(y2-y1)/(x2-x1));
                }
                slope.put(key,slope.getOrDefault(key,0)+1);
                localMax = Math.max(localMax, slope.get(key));
            }
            max = Math.max(localMax+duplicates+1,max);
        }
        return max;
    }
}
