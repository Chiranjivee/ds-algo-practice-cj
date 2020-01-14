class Solution {
    static void primeSum(int total, int N, int S, int index) {
        // if total equals S 
        // And total is reached 
        // using N primes 
        if (total == S && set.size() == N) {
            // display the N primes 
            display();
            return;
        }

        // if total is greater  
        // than S or if index  
        // has reached last 
        // element 
        if (total > S || index == prime.size())
            return;

        // add prime.get(index)  
        // to set vector 
        set.add(prime.get(index));

        // include the (index)th  
        // prime to total 
        primeSum(total + prime.get(index), N, S, index + 1);

        // remove element  
        // from set vector 
        set.remove(set.size() - 1);

        // exclude (index)th prime 
        primeSum(total, N, S, index + 1);
    }
}
