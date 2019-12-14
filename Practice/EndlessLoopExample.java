class EndlessLoopExample {
    public static void main(String[] args) {
        byte rigid = 0;
        while (rigid < 10){
            System.out.println(rigid);
            rigid--;
        }

        System.out.println(rigid);
        System.out.println("Broken");
    }
}
