package ru.job4j.queue;

import java.util.PriorityQueue;

public class PriorityQueueRunner {
    public static void main(String[] args) {
        PriorityQueue<String> stringQueue1 = new PriorityQueue<>();
        stringQueue1.offer("f");
        stringQueue1.offer("a");
        stringQueue1.offer("s");
        stringQueue1.offer("e");
        printStringElements(stringQueue1);
        System.out.println();
        PriorityQueue<Transaction> transactions1 = new PriorityQueue<>(new TransactionSortDescByAmount());
        transactions1.offer(new Transaction(1, "number_1", 100));
        transactions1.offer(new Transaction(2, "number_2", 1000));
        transactions1.offer(new Transaction(3, "number_3", 85));
        transactions1.offer(new Transaction(4, "number_4", 550));
        printTransactionElements(transactions1);
        System.out.println();
        PriorityQueue<String> stringQueue2 = new PriorityQueue<>();
        stringQueue2.offer("f");
        stringQueue2.offer("a");
        stringQueue2.offer("s");
        stringQueue2.offer("e");
        System.out.println("Current element: " + stringQueue2.poll());
        stringQueue2.poll();
        System.out.println("Current element: " + stringQueue2.poll());
        stringQueue2.poll();
        System.out.println("Current element: " + stringQueue2.poll());
        System.out.println();
        PriorityQueue<Transaction> transactions2 = new PriorityQueue<>(new TransactionSortDescByAmount());
        transactions2.offer(new Transaction(1, "number_1", 100));
        transactions2.offer(new Transaction(2, "number_2", 1000));
        transactions2.offer(new Transaction(3, "number_3", 85));
        transactions2.offer(new Transaction(4, "number_4", 550));
        System.out.println("Current element: " + transactions2.peek());
        System.out.println("Current element: " + transactions2);
        System.out.println("Current element: " + transactions2.peek());
        transactions2.poll();
        System.out.println("Current element: " + transactions2.peek());
        System.out.println();
        PriorityQueue<Transaction> transactions = new PriorityQueue<>(new TransactionSortDescByAmount());
        transactions.offer(new Transaction(1, "number_1", 100));
        transactions.offer(new Transaction(2, "number_2", 1000));
        transactions.offer(new Transaction(3, "number_3", 85));
        transactions.offer(new Transaction(4, "number_4", 100));
        transactions.offer(new Transaction(5, "number_5", 1000));
        transactions.offer(new Transaction(6, "number_6", 550));
        transactions.offer(new Transaction(7, "number_7", 100));
        transactions.offer(new Transaction(8, "number_8", 1000));
        printTransactionElements(transactions);
    }

    private static void printStringElements(PriorityQueue<String> queue) {
        while (!queue.isEmpty()) {
            System.out.println("Current element: " + queue.poll());
        }
    }

    private static void printTransactionElements(PriorityQueue<Transaction> queue) {
        while (!queue.isEmpty()) {
            System.out.println("Current element: " + queue.poll());
        }
    }
}
