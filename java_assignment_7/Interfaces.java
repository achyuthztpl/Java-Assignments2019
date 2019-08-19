package java_assignment_7;

interface Interface1 {
    void interface1_1();

    void interface1_2();
}

interface Interface2 {
    void interface2_1();

    void interface2_2();

}

interface Interface3 {
    void interface3_1();

    void interface3_2();
}

interface Interface4 extends Interface1, Interface2, Interface3 {
    void interface4_1();
}

public class Interfaces {
    public static void main(String arg[]) {
        Root root = new Root();
        root.fetchInterface1(root);
        root.fetchInterface2(root);
        root.fetchInterface3(root);
        root.fetchInterface4(root);
    }
}

class ClassExtended {
    ClassExtended() {
        System.out.println("Inside ClassExtended");
    }

}


class Root extends ClassExtended implements Interface4 {

    void fetchInterface1(Interface1 root) {
        root.interface1_1();
        root.interface1_2();
    }

    void fetchInterface2(Interface2 root) {
        root.interface2_1();
        root.interface2_2();
    }

    void fetchInterface3(Interface3 root) {
        root.interface3_1();
        root.interface3_2();
    }

    void fetchInterface4(Interface4 root) {
        root.interface4_1();
    }

    @Override
    public void interface1_1() {
        System.out.println("Inside interface 1_1");
    }

    @Override
    public void interface1_2() {
        System.out.println("Inside interface 1_2");

    }

    @Override
    public void interface2_1() {
        System.out.println("Inside interface 2_1");

    }

    @Override
    public void interface2_2() {
        System.out.println("Inside interface 2_2");

    }

    @Override
    public void interface3_1() {
        System.out.println("Inside interface 3_1");

    }

    @Override
    public void interface3_2() {
        System.out.println("Inside interface 3_2");
    }

    @Override
    public void interface4_1() {
        System.out.println("Inside interface 4_1");
    }
}
