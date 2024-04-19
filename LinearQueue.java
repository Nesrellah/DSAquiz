package com.nasri.linearstructure;

public class LinearQueue {
        private int maxSize; // maximum size of the queue
        private int[] queueArray; // array to store the elements
        private int front; // front/head of the queue
        private int rear; // rear/tail of the queue
        private int currentSize; // current number of elements in the queue

        public LinearQueue(int size) {
            maxSize = size;
            queueArray = new int[maxSize];
            front = 0;
            rear = -1;
            currentSize = 0;
        }

        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is full. Unable to enqueue.");
                return;
            }

            rear = (rear + 1) % maxSize; // circularly increment rear
            queueArray[rear] = item;
            currentSize++;
            System.out.println("Enqueued: " + item);
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Unable to dequeue.");
                return -1;
            }

            int dequeuedItem = queueArray[front];
            front = (front + 1) % maxSize; // circularly increment front
            currentSize--;
            System.out.println("Dequeued: " + dequeuedItem);
            return dequeuedItem;
        }

        public int front() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return queueArray[front];
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }

        public boolean isFull() {
            return currentSize == maxSize;
        }

        public int size() {
            return currentSize;
        }
        public static void main(String[] args) {
            LinearQueue queue = new LinearQueue(5);

            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.enqueue(40);
            queue.enqueue(50);

            System.out.println("Front of the queue: " + queue.front());
            System.out.println("Queue size: " + queue.size());

            while (!queue.isEmpty()) {
                queue.dequeue();
            }

            System.out.println("Is the queue empty? " + queue.isEmpty());
        }

}
