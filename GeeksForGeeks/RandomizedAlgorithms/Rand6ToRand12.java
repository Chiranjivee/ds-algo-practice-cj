class Rand6ToRand12 {
    public int getRand12() {
        return 2 * rand6() - (rand6() & 1);
    }
    // returns random number between 1 - 6
    public int rand6() {

    }
}