// 17 Feb : Cyber Cafe Session Tracker

import java.util.List;
import java.util.PriorityQueue;

class Customer {
    String id;
    int arrival;
    int duration;
    
    Customer(String id, int arrival, int duration) {
        this.id = id;
        this.arrival = arrival;
        this.duration = duration;
    }
}

public class Day20 {
    public static int countDeniedCustomers(int N, List<Customer> customers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int denied = 0;

        for(Customer c : customers) {
            int arrival = c.arrival;
            int duration = c.duration;

            while(!pq.isEmpty() && pq.peek() <= arrival) {
                pq.poll();
            }

            if(pq.size() < N){
                pq.add(arrival+duration);
            } else{
                denied++;
            }
        }
        return denied;
    }

    public static void main(String[] args) {
        List<Customer> customers = List.of(
            new Customer("C1", 0, 5),
            new Customer("C2", 1, 3),
            new Customer("C3", 2, 6),
            new Customer("C4", 4, 2)
        );
        int N = 2;
        int denied = countDeniedCustomers(N, customers);
        System.out.println("Number of denied customers: " + denied); // Output: Number of denied customers: 1
    }
}
