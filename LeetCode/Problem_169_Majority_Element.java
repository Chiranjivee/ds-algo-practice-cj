class Solution {
    public int majorityElement(int[] num) {
       int count = 0; 
       int major = num[0];
       for(int i:num) {
           if(count==0){ major=i; count++;	}
           else if(i==major) count++;
           else count--;
       }
       return major;
   }
}
