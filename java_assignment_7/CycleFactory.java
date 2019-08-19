package java_assignment_7;

class CycleFactory {
    public static void main(String[] args) {
        CycleInterface unicycle = UnicycleFactory.getUnicycle();
        CycleInterface bicycle = BicycleFactory.getBicycle();
        CycleInterface tricycle = TricycleFactory.getTricycle();

    }
}

interface CycleInterface {
    void type();
}

class Unicycle implements CycleInterface {
    Unicycle() {
        System.out.println("unicycle ready");
    }

    public void type() {
        System.out.println("this is unicycle");
    }
}


class Bicycle implements CycleInterface {
    Bicycle() {
        System.out.println("bicycle ready");
    }

    public void type() {
        System.out.println("this is bicycle");
    }
}

class Tricycle implements CycleInterface {
    Tricycle() {
        System.out.println("tricycle ready");
    }

    public void type() {
        System.out.println("this is tricycle");
    }
}

class UnicycleFactory {
    public static Unicycle getUnicycle() {
        return new Unicycle();
    }
}

class BicycleFactory {
    public static Bicycle getBicycle() {
        return new Bicycle();
    }
}


class TricycleFactory {
    public static Tricycle getTricycle() {
        return new Tricycle();
    }
}

