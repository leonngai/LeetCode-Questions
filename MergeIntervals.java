/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
           public int compare(Interval a, Interval b) {
               return a.start - b.start;
           } 
        });
        
        List<Interval> answer = new ArrayList<>();
        for (Interval i: intervals) {
            if (answer.isEmpty() || answer.get(answer.size()-1).end < i.start)
                answer.add(i);
            
            else 
                answer.get(answer.size()-1).end = Math.max(answer.get(answer.size()-1).end, i.end);
        }
        
        return answer;
    }
}

//sort intevals from smallest to largest interval starts, compare the interval end with interval start until we find one that is false, then we add that as one interval
 //repeat until done

//O(nlogn) to sort and O(n) to iterate through list so O(nlogN)
//O(1) space
