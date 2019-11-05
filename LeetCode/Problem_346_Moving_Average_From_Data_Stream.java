/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
class MovingAverage {    
    Deque<Double> window = new LinkedList<>();
    int windowSize = 0;
    int size = 0;
    double sum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        windowSize = size;
    }
    
    public double next(int val) {
        window.offer((double)val);
        size++;
        sum += val;
        if (size > windowSize) {
            double elem = window.pollFirst();
            size--;
            sum -= elem;
        }
        
        return sum / size;
    }
}
