/*
Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
*/

public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
 
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
       ArrayList<Interval> result = new ArrayList<>();
       if(intervals == null || intervals.size() ==0) return result;
       Collections.sort(intervals,(a,b)->(a.start-b.start));
       int i = 0;
       while(i<intervals.size()){
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            while(i<intervals.size()-1 && intervals.get(i+1).start<=end) {
                start = Math.min(start,intervals.get(i+1).start);
                end = Math.max(end,intervals.get(i+1).end);
                i++;
            }
            result.add(new Interval(start,end));
            i++;
       }
       return result;
    }
}
