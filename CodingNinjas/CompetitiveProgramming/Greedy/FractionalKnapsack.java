import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapSack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	long d = sc.nextLong();
      
      	List<Painter> painters = new ArrayList<>();
      	for (int i = 0; i < n; i++) {
          	painters.add(new Painter(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
      
      	Collections.sort(painters, (p1, p2) -> {
          	if (p1.time == p2.time) {
              	if (p1.speed == p2.speed) return p1.cost - p2.cost;
              	return p2.speed - p1.speed;
            }
          
          	return p1.time - p2.time;
        });
      
      	Painter currentBest = painters.get(0);
      	int bestSpeed = 0;
      	int cost = 0;
      	long remainingArea = d;
      	int lastTime = painters.get(0).time;
      	for (Painter currentPainter : painters) {
          	remainingArea -= (currentBest.speed * (currentPainter.time - lastTime));
          	if (remainingArea <= 0) break;
          	if (currentPainter.speed > bestSpeed) {
              	cost += currentPainter.cost;
              	bestSpeed = currentPainter.speed;
              	currentBest = currentPainter;
            }
          	lastTime = currentPainter.time;
        }
      	System.out.println(cost);
	}
}

class Painter {
 	int time;
  	int cost;
  	int speed;
  	Painter(int time, int cost, int speed) {
      	this.time = time;
      	this.cost = cost;
      	this.speed = speed;
    }
}
