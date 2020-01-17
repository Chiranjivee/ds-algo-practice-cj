class SplitNInMaxCompositeNumber {
    int count(int n) {
        // 4 is the smallest composite number 
        if (n<4)
            return -1;
    
        // stores the remainder when n is divided 
        // by 4 
        int rem = n % 4;
    
        // if remainder is 0, then it is perfectly  
        // divisible by 4. 
        if (rem == 0)
            return n / 4;
    
        // if the remainder is 1 
        if (rem == 1) {
    
            // If the number is less then 9, that 
            // is 5, then it cannot be expressed as  
            // 4 is the only composite number less  
            // than 5 
            if (n<9)
                return -1;
    
            // If the number is greater then 8, and  
            // has a remainder of 1, then express n 
            // as n-9 a and it is perfectly divisible  
            // by 4 and for 9, count 1. 
            return (n - 9) / 4 + 1;
        }
    
        // When remainder is 2, just subtract 6 from n,  
        // so that n is perfectly divisible by 4 and 
        // count 1 for 6 which is subtracted. 
        if (rem == 2)
            return (n - 6) / 4 + 1;
    
        // if the number is 7, 11 which cannot be  
        // expressed as sum of any composite numbers 
        if (rem == 3) {
            if (n<15)
                return -1;
    
            // when the remainder is 3, then subtract 
            // 15 from it and n becomes perfectly  
            // divisible by 4 and we add 2 for 9 and 6, 
            // which is getting subtracted to make n  
            // perfectly divisible by 4. 
            return (n - 15) / 4 + 2;
        }
    }
}