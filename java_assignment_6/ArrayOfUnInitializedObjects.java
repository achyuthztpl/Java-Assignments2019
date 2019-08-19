package java_assignment_6;

public class ArrayOfUnInitializedObjects {
    ArrayOfUnInitializedObjects(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {

        //It wont print the messages as only references are created.
        ArrayOfUnInitializedObjects arrayOfUnInitializedObjects[] = new ArrayOfUnInitializedObjects[10];
    }
}
