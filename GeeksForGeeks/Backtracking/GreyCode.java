class Grey {
    static void grayCodeUtil(Vector<Integer> res, int n) {
        // base case when we run out bits to process 
        // we simply include it in gray code sequence. 
        if (n == 0) {
            res.add(num);
            return;
        }
    
        // ignore the bit. 
        grayCodeUtil(res, n - 1);
    
        // invert the bit. 
        num = num ^ (1<< (n - 1));
        grayCodeUtil(res, n - 1);
    }
    
    // returns the vector containing the gray  
    // code sequence of n bits. 
    static Vector<Integer> grayCodes(int n) {
        Vector<Integer> res = new Vector<Integer> ();
    
        // num is passed by reference to keep 
        // track of current code. 
        num = 0;
        grayCodeUtil(res, n);
    
        return res;
    }
}
