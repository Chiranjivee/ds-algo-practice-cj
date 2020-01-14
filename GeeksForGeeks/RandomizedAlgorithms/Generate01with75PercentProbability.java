class Generate01With75PercentProb {
    static int rand50() {
        // rand() function will generate odd or even  
        // number with equal probability. If rand()  
        // generates odd number, the function will  
        // return 1 else it will return 0.  
        return (int)(10 * Math.random()) & 1;
    }
    
    // Random Function to that returns 1 with 75%  
    // probability and 0 with 25% probability using  
    // Bitwise OR  
    static int rand75() {
        return rand50() | rand50();
    }
}