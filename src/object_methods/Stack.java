package object_methods;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INTIAL_CAPACITY = 16;
    public Stack() {
        this.elements = new Object[DEFAULT_INTIAL_CAPACITY];
        System.out.println(elements.length);
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // Eliminate Obsolete reference
        return result;
    }

    // Ensure space for least one more element
    private void ensureCapacity() {
        if(elements.length == size) {
//            elements = Arrays.copyOf(elements, 2*size+1);
            System.out.println(elements.length);
        }
    }


    @Override
    public Stack clone() {
        try {
            Stack result = (Stack)super.clone();
            // we call elements.clone() recursively because elements are objects
            // and object of arrays have accept clone method automatically
            result.elements = elements.clone();
            return result;
        }

        catch(CloneNotSupportedException e) {
            throw new AssertionError(elements.length + ": " + Arrays.toString(elements));
        }

    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(10);
        stack.push(20);

        // pop element make the object null
        stack.pop();


        Stack result = stack.clone();
        stack.pop();
        for(Object ele: stack.elements) {
            System.out.print(ele+"\t");
        }

        System.out.println();
        for(Object ele: result.elements) {
            System.out.print(ele+"\t");
        }

        System.out.println();

    }
}
