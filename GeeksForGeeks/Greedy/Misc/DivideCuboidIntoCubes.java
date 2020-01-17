class DivideCuboidIntoCubes {
    static int gcd(int m, int n) {
        if (n == 0)
            return m;
        else if (n > m)
            return gcd(n, m);
        else
            return gcd(n, m % n);
    }
    
    // Print the maximum side and no 
    //     of cube. 
    static void maximizecube(int l, int b, int h) {
        // GCD to find side. 
        int side = gcd(l, gcd(b, h));
    
        // dividing to find number of cubes. 
        int num = l / side;
        num = (num * b / side);
        num = (num * h / side);
    
        System.out.println(side + " " + num);
    }
}
