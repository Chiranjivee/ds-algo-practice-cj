import java.util.*;

public class WarmReception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	int start[] = new int[n];
      	int end[] = new int[n];
      	for (int i = 0; i < n; i++) {
          	start[i] = sc.nextInt();
        }
      
      	for (int j = 0; j < n; j++) {
          	end[j] = sc.nextInt();
        }
      
      	List<Interval> intervals = new ArrayList<>();
      	for (int i = 0; i < n; i++) {
          	int diff = end[i] - start[i];
          	if (diff > 0) intervals.add(new Interval(start[i], end[i]));
        }
      	if (intervals.size() == 0) {
          	System.out.println(-1);
          	return;
        }
		System.out.println(findMaxOverlapping(intervals));
	}
  
  	public static int findMaxOverlapping(List<Interval> intervals) {
      	int maxOverlapping = 0;
      	for (int i = 0; i < intervals.size(); i++) {
          	int currentInterval = i;
          	for (int j = 0; j < intervals.size(); j++) {
              	if (intervals.get(currentInterval).doesOverlap(intervals.get(j))) {
                	intervals.get(currentInterval).overlap++;
                }             	
            }
          
          	if (intervals.get(maxOverlapping).overlap < intervals.get(currentInterval).overlap) {
              	maxOverlapping = currentInterval;
            }
				}
				
				System.out.println("Overlapping interval: " + intervals.get(maxOverlapping).start + " " + intervals.get(maxOverlapping).end);
      	return intervals.get(maxOverlapping).overlap;
    }
}

class Interval {
  
  	int start;
  	int end;
  	int overlap;
  
  	public Interval(int start, int end) {
      	this.start = start;
      	this.end = end;
      	this.overlap = 0;
    }
  
  	public boolean doesOverlap(Interval i) {
      	if (this.start >= i.start && this.start < i.end || 
               this.end <= i.end && this.end > i.start ||
               this.start == i.start && this.end == i.end) {
          	return true;
        }
      	return false;
    }
  
  	private boolean isBetweenThisInterval(int x) {
      	if (start <= x && x <= end) {
          	return true;
        } return false;
    }
}