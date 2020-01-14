class Rand3FromRand2 {
    public int rand3() {
        int outcome = 2 * rand2() + rand2();
        if (outcome < 3) {
            return outcome;
        }

        return rand3();
    }
}
