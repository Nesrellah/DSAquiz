package com.nasri.linearstructure;
import java.util.Stack;
public class QueueUsingStacks<T> {
        private Stack<T> enqueueStack;
        private Stack<T> dequeueStack;

        public QueueUsingStacks() {
            enqueueStack = new Stack<>();
            dequeueStack = new Stack<>();
        }

        public void enqueue(T item) {
            enqueueStack.push(item);
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty. Cannot dequeue.");
            }

            if (dequeueStack.isEmpty()) {
                transferElements();
            }

            return dequeueStack.pop();
        }

        public boolean isEmpty() {
            return enqueueStack.isEmpty() && dequeueStack.isEmpty();
        }

        public int size() {
            return enqueueStack.size() + dequeueStack.size();
        }

        private void transferElements() {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        public static void main(String[] args) {
            QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 10
            queue.enqueue(40);
            System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 20
            System.out.println("Size: " + queue.size()); // Output: Size: 2
        }
}
