package java_assignment_7;

class InheritanceHierarchy {
    public static void main(String[] args) {
        Rodent[] rodents = {new Rat(), new Mice(), new Squirrel()};
        for (Rodent rodent : rodents) {
            rodent.printName();
            rodent.printLivingHabits();
        }
    }
}

abstract class Rodent {
    abstract void printName();

    abstract void printLivingHabits();

    Rodent() {
        System.out.println("This is Rodent Abstract class constructor.");
    }
}

class Rat extends Rodent {

    Rat() {
        System.out.println("This is Rat Constructor.");
    }

    @Override
    void printName() {
        System.out.println("This is Rat.");
    }

    @Override
    void printLivingHabits() {
        System.out.println("BlackRats build their nests high up and BrownRats like to be close to the ground.");
    }
}

class Mice extends Rodent {

    Mice() {
        System.out.println("This is Mice Constructor.");
    }

    @Override
    void printName() {
        System.out.println("This is Mice.");
    }

    @Override
    void printLivingHabits() {
        System.out.println("Mice build their nests in burrows.");
    }
}

class Squirrel extends Rodent {

    Squirrel() {
        System.out.println("This is Squirrel Constructor.");
    }

    @Override
    void printName() {
        System.out.println("This is Squirrels.");
    }

    @Override
    void printLivingHabits() {
        System.out.println("Squirrels digs holes in Trees or on ground.");
    }
}
