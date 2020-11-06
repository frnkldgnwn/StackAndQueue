import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;

class QueueArray {
    int[] queue;
    int counter;

    public QueueArray(int len) {
        queue = new int[len];
        counter = 0;
    }

    public void enqueue(int enqueue) {
        if (!isFull()) {
            queue[counter] = enqueue;
            counter++;
        } else {
            System.out.println("Queue penuh!");
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int returnVal = queue[0];
            System.arraycopy(queue, 1, queue, 0, queue.length - 1);
            queue[queue.length - 1] = 0;
            counter--;
            return returnVal;
        } else {
            System.out.println("Queue kosong!");
            return Integer.MIN_VALUE;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return queue[0];
        } else {
            System.out.println("Queue kosong!");
            return Integer.MIN_VALUE;
        }
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == queue.length;
    }

    public void forEach(Consumer<Integer> consumer) {
        Objects.requireNonNull(consumer);
        for (int j : queue) {
            consumer.accept(j);
        }
    }
}

class QueueLinkedList {
    LinkedList<Integer> queue;

    public QueueLinkedList() {
        queue = new LinkedList<Integer>();
    }

    public void enqueue(Integer enqueue) {
        queue.addLast(enqueue);
    }

    public Integer dequeue() {
        if (!isEmpty()) {
            return queue.removeFirst();
        } else {
            System.out.println("Stack kosong!");
            return null;
        }
    }

    public int peek() {
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public void forEach(Consumer<Integer> consumer) {
        Objects.requireNonNull(consumer);
        for (int j : queue) {
            consumer.accept(j);
        }
    }
}

public class MainQueue {
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(10);
        QueueLinkedList queueLinkedList = new QueueLinkedList();

        queueLinkedList.enqueue(5);
        queueLinkedList.enqueue(10);
        queueLinkedList.enqueue(11);
        queueLinkedList.enqueue(62);
        queueLinkedList.enqueue(63);
        queueLinkedList.enqueue(1);
        queueLinkedList.enqueue(4);

        queueLinkedList.forEach((elem)-> {
            System.out.print(elem + " ");
        });

        System.out.println("\n" + queueLinkedList.dequeue());
        queueLinkedList.forEach((elem)-> {
            System.out.print(elem + " ");
        });
    }
}
