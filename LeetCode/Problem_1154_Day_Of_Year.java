class Solution {
    
    static int [] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public int dayOfYear(String date) {
        String [] dateSplit = date.split("-");
        int year = Integer.valueOf(dateSplit[0]);
        int month = Integer.valueOf(dateSplit[1]);
        int day = 0;
        for (int i = 0; i < month; i++) {
            day += days[i];
        }
        
        if (month > 2 && isLeapYear(year)) {
            day += 1;
        }
        
        day += Integer.valueOf(dateSplit[2]);
        return day;
    }
    
    public boolean isLeapYear(int year) {
        
        // If a year is multiple of 400,  
        // then it is a leap year  
        if (year % 400 == 0)  
            return true;  

        // Else If a year is muliplt of 100,  
        // then it is not a leap year  
        if (year % 100 == 0)  
            return false;  

        // Else If a year is muliplt of 4,  
        // then it is a leap year  
        if (year % 4 == 0)  
            return true;  
        return false;
    }
}
