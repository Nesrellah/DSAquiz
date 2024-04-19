package com.nasri.linearstructure;

public class CircularQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;

        public CircularQueue(int capacity) {
            queue = new int[capacity];
            front = -1;
            rear = -1;
            size = 0;
        }

        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot enqueue.");
                return;
            }

            if (isEmpty()) {
                front = 0;
            }

            rear = (rear + 1) % queue.length;
            queue[rear] = data;
            size++;

            System.out.println("Enqueued: " + data);
        }

        public void dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return;
            }

            int data = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % queue.length;
            }
            size--;

            System.out.println("Dequeued: " + data);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == queue.length;
        }

        public int front() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty.");
            }
            return queue[front];
        }

        public int rear() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty.");
            }
            return queue[rear];
        }

        public int size() {
            return size;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }

            System.out.print("Queue: ");
            int index = front;
            for (int i = 0; i < size; i++) {
                System.out.print(queue[index] + " ");
                index = (index + 1) % queue.length;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            CircularQueue queue = new CircularQueue(5);
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.display(); // Output: Queue: 10 20 30
            System.out.println("Front: " + queue.front()); // Output: Front: 10
            System.out.println("Rear: " + queue.rear()); // Output: Rear: 30
            queue.dequeue();
            queue.display(); // Output: Queue: 20 30
            System.out.println("Size: " + queue.size()); // Output: Size: 2
        }
}
