package java_assignment_6;

public class ArrayOfInitializedObjects {
    ArrayOfInitializedObjects(String parameter) {
        System.out.println(parameter);
    }

    public static void main(String[] args) {
        ArrayOfInitializedObjects arrayOfInitializedObjects[] = new ArrayOfInitializedObjects[10];

        for (int i = 0; i < 10; i++) {
            arrayOfInitializedObjects[i] = new ArrayOfInitializedObjects(i+1+". hi");
        }
    }
}
