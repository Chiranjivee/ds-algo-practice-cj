import java.util.Collections;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class ComputeKClosest {

    public List<Star> kClosest(List<Star> allStars, int k) {
        PriorityQueue<Star> queue = new PriorityQueue<>(k + 1, (a, b) -> b.distance - a.distance);
        for (Star star : allStars) {
            queue.add(star);
            if (queue.size() == k + 1) {
                queue.remove();
            }
        }
        List<Star> result = new ArrayList<>(queue);
        Collections.sort(result, (a, b) -> a.distance - b.distance);
        return result;
    }

    public static void main(String[] args) {
        Star star1 = new Star(1,1,1);
        Star star2 = new Star(2,2,2);
        Star star3 = new Star(3,3,3);
        Star star4 = new Star(4,4,4);
        List<Star> input = new ArrayList<>();
        input.add(star1);
        input.add(star2);
        input.add(star3);
        input.add(star4);
        ComputeKClosest kClosest = new ComputeKClosest();
        List<Star> result = kClosest.kClosest(input, 2);
        for (Star star : result) {
            System.out.println(star.distance + " " + star.x + " " + star.y + " " + star.z);
        }
    }
}

class Star {
    int x, y , z;
    int distance;
    public Star(int x, int y, int z) {
        this.x = x; 
        this.y = y;
        this.z = z;
        this.distance = distance();
    }

    public int distance() {
        return (int) Math.sqrt(x * x + y * y + z * z);
    }
}