class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] results=new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int startYear=1971,days=0;
        while(startYear<year){
              days+=startYear%4==0?366:365;
              startYear++;
        } 
		// we don't wanna add an other day when the given day is 29 and it is already a leap year
        days+=year%4==0 && day!=29?1:0;
        for(int i=0;i<month;i++)days+=months[i];
        days+=day;
		// Since 1971 started with a friday I have added 4 to the number of days
        return results[(days%7+4)%7];
    }
}
