class ChoiceOfArea {

    public int getMaxSurvivalTime(int powerA, int powerB, Area one, Area two, Area three, Area lastArea, Map<Pair<Integer, Integer>, Area> memo) {

        if (powerA <= 0 || powerB <= 0) {
            return 0;
        }

        if (memo.containsKey(new Tuple(powerA, powerB, lastArea))) {
            return memo.get(new Tuple(powerA, powerB, lastArea));
        }

        int option1 = 0;
        int option2 = 0;
        if (lastArea == one) {
            int option1 = 1 + getMaxSurvivalTime(powerA + two.x, powerB + two.y, one, two, three);
            int option2 = 1 + getMaxSurvivalTime(powerA + three.x, powerB + three.y, one, two, three);
        } else if (lastArea == two) {
            int option1 = 1 + getMaxSurvivalTime(powerA + one.x, powerB + one.y, one, two, three);
            int option2 = 1 + getMaxSurvivalTime(powerA + three.x, powerB + three.y, one, two, three);
        } else if (lastArea == three) {
            int option1 = 1 + getMaxSurvivalTime(powerA + one.x, powerB + one.y, one, two, three);
            int option2 = 1 + getMaxSurvivalTime(powerA + two.x, powerB + two.y, one, two, three);
        }

        int res = Math.max(option1, option2);
        memo.put(new Tuple(powerA, powerB, lastArea), res)
        return res;
    }

    public static void main(String[] args) {
        Map<Tuple, Integer> memo = new HashMap<>();
        ChoiceOfArea coa = new ChoiceOfArea();
        Area one = new Area()(3, 2); 
        Area two = new Area()(-5, -10); 
        Area three = new Area()(-20, 5); 
  
        int powerA = 20; 
        int powerB = 8; 
        
        int optionOne = coa.getMaxSurvivalTime(powerA, powerB, one, two, three, one, memo);
        int optionTwo = coa.getMaxSurvivalTime(powerA, powerB, one, two, three, two, memo);
        int optionThree = coa.getMaxSurvivalTime(powerA, powerB, one, two, three, three, memo);
        
        int result = Math.max(optionOne, Math.max(optionTwo, optionThree));
        System.out.println("Result: " + result);
    }
}

class Tuple {
    int x, int y, Area a;
}

class Area {
    int x; 
    int y;
    public Area(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
