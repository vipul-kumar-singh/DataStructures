package com.vkstech.algorithms.practice2.queue;

public class CircularTour {

    public static class Node {
        int petrol;
        int distance;

        public Node(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {

        Node[] queue = {new Node(6, 4),
                new Node(3, 6),
                new Node(7, 3)};

        int start = printTour(queue);

        System.out.println(start == -1 ? "No Solution" : "Start = " + start);

    }

    private static int printTour(Node[] queue) {
        int start = 0;
        int end = 1;
        int curr_petrol = queue[start].petrol - queue[start].distance;

        while (end != start || curr_petrol < 0) {

            while (curr_petrol < 0 && start != end) {
                curr_petrol -= queue[start].petrol - queue[start].distance;
                start = (start + 1) % queue.length;

                if (start == 0)
                    return -1;
            }
            curr_petrol += queue[end].petrol - queue[end].distance;
            end = (end + 1) % queue.length;
        }

        return start;
    }
}
