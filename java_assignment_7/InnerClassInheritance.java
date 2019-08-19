package java_assignment_7;


public class InnerClassInheritance {
    public static void main(String[] args) {
        OuterclassTwo outerclassTwo = new OuterclassTwo();
        OuterclassOne outerclassOne = new OuterclassOne();

        OuterclassTwo.InnerclassTwo innerclassTwo = outerclassTwo.new InnerclassTwo(outerclassOne);
    }
}

class OuterclassOne {
    class InnerclassOne {
        InnerclassOne(String parameter) {
            System.out.println("In InnerClassOne with string:" + parameter);
        }
    }
}

class OuterclassTwo {
    class InnerclassTwo extends OuterclassOne.InnerclassOne {
        InnerclassTwo(OuterclassOne outerclassOne) {
            outerclassOne.super("Hello");
            System.out.println("In InnerClassTwo");
        }

    }
}
