package java_assignment_10;

import java.util.NoSuchElementException;

public class GenericList {
    public static void main(String[] args) {
        SList<Integer> sList = new SList<Integer>();
        SListIterator sListIterator = sList.iterator();

        System.out.println(sList);

        sListIterator.add(1);
        System.out.println(sList);

        sListIterator.add(2);
        System.out.println(sList);

        sListIterator.add(3);
        System.out.println(sList);

        System.out.println("iterator hasNext() -> " + sListIterator.hasNext() + "\n next() -> " + sListIterator.next());

        Integer removed = (Integer) sListIterator.remove();
        System.out.println("List after remove() -> " + sList + " and the removed value is " + removed);
    }
}

/**
 * This is the main list class form which we can access list through list iterator.
 * @param <T>
 */
class SList<T> {
    private Node<T> head = new Node<T>(null);

    /**
     * @return Iterator to the list.
     */
    SListIterator iterator() {

        return new SListIterator<T>(head);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        SListIterator sListIterator = this.iterator();
        stringBuilder.append('[');
        while (sListIterator.hasNext()) {
            stringBuilder.append(sListIterator.next() + " " + (sListIterator.hasNext() ? ',' : ""));
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

/**
 * This is single node class definition used in the list.
 * Each node contains its data and link to the next node in the list.
 * @param <T>
 */
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }

    Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}

/**
 * This is a list iterator through which we can iterate list, add and remove objects from list.
 * Iterator keeps track of the elements using its pointer(indexNode).
 * @param <T>
 */
class SListIterator<T> {
    private Node<T> indexNode;

    SListIterator(Node<T> node) {
        this.indexNode = node;
    }

    boolean hasNext() {
        return indexNode != null && indexNode.next != null;
    }

    /**
     *
     * @return next available node after the iterator pointer(indexNode)
     */
    T next() {
        if (indexNode.next == null) throw new NoSuchElementException();
        indexNode = indexNode.next;
        return (T)indexNode.data;
    }

    /**
     * adds new node into the list next to the pointer of the iterator.
     * @param data
     */
    void add(T data) {
        indexNode.next = new Node<T>(data, indexNode.next);
    }

    /**
     * removes the next available object in the list after iterator pointer.
     * @return value of removed object.
     */
    T remove() {
        if (indexNode.next == null)
            throw new IllegalStateException("No elements to delete further.");
        T returnValue = indexNode.next.data;
        indexNode.next = indexNode.next.next;

        return returnValue;
    }
}