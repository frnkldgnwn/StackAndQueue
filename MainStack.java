import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;

class StackArray {
    int[] stack;
    int counter;

    public StackArray(int len) {
        stack = new int[len];
        counter = 0;
    }

    public void push(int push) {
        if (!isFull()) {
            stack[counter] = push;
            counter++;
        } else {
            System.out.println("Stack penuh!");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int returnVal = stack[counter - 1];
            stack[counter - 1] = 0;
            counter--;
            return returnVal;
        } else {
            System.out.println("Stack kosong!");
            return Integer.MIN_VALUE;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return stack[counter - 1];
        } else {
            System.out.println("Stack kosong!");
            return Integer.MIN_VALUE;
        }
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == stack.length;
    }

    public void forEach(Consumer<Integer> consumer) {
        Objects.requireNonNull(consumer);
        for (int i = stack.length - 1; i >= 0; i--) {
            consumer.accept(stack[i]);
        }
    }
}

class StackLinkedList {
    LinkedList<Integer> stack;

    public StackLinkedList() {
        stack = new LinkedList<Integer>();
    }

    public void push(Integer push) {
        stack.addLast(push);
    }

    public Integer pop() {
        if (!isEmpty()) {
            return stack.removeLast();
        } else {
            System.out.println("Stack kosong!");
            return null;
        }
    }

    public int peek() {
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public void forEach(Consumer<Integer> consumer) {
        Objects.requireNonNull(consumer);
        for (int i = stack.size() - 1; i >= 0; i--) {
            consumer.accept(stack.get(i));
        }
    }
}

public class MainStack {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(30);
        StackLinkedList stackLinkedList = new StackLinkedList();

        stackLinkedList.push(5);
        stackLinkedList.push(10);
        stackLinkedList.push(11);
        stackLinkedList.push(62);
        stackLinkedList.push(63);
        stackLinkedList.push(1);
        stackLinkedList.push(4);

        stackLinkedList.forEach(System.out::println);

        System.out.println("\n" + stackLinkedList.pop() + "\n");
        stackLinkedList.forEach(System.out::println);

        System.out.println("\n" + stackLinkedList.peek() + "\n");
        stackLinkedList.forEach(System.out::println);
    }
}
