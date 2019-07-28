class Solution {
    public int tribonacci(int n) {
        int first=0,second=1,third=1;
        // here first,second and third are the previous three elements
        if(n<2)
            return n;
        // if n=0 or n=1 then the tribonacci number is n itself 
        // else for loop will be executed
        for(int i=3;i<=n;i++)
        {
            int newElement=first+second+third;
            first=second;
            second=third;
            third=newElement;
        }
        return third;
    }
}
