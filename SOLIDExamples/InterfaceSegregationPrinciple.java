interface LivingThing {
    void breathe();
    void walk();
}

class Tree implements LivingThing {
    void breathe() {
        System.out.println("Human breathes"); 
    }

    // ISP Violation
    void walk() {
        // Implementation intentionally left empty,
        // because trees don't walk.
    }
}

class Human implements LivingThing {
    void breathe() {
        System.out.println("Human breathes"); 
    }

    void walk() {
        System.out.println("Human walks");
    }
} 
