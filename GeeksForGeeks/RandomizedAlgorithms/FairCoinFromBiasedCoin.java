class FairCoin {
    public int toss() {
        int val1 = foo();
        int val2 = foo();

        if (val1 == 0 && val2 == 1) {
            return 0;
        }

        if (val1 == 1 && val2 == 0) {
            return 1;
        }

        return toss();
    }


    // return 0 with 60 % probability and 1 with 40% probability
    public int foo() {
        return 0;
    }
}
