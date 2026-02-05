// 5 Feb : Aadhar Smart Queue Optimization

import java.util.ArrayList;
import java.util.List;

class Person {
    int personID;
    int arrivalTime;
    int urgencyLevel;
    int serviceType;

    public Person(int personID, int arrivalTime, int urgencyLevel, int serviceType) {
        this.personID = personID;
        this.arrivalTime = arrivalTime;
        this.urgencyLevel = urgencyLevel;
        this.serviceType = serviceType;
    }
}

public class Day8 {

    public boolean isHigherPriority(Person p1, Person p2) {
        if (p1.urgencyLevel != p2.urgencyLevel) {
            return p1.urgencyLevel > p2.urgencyLevel;
        } else if (p1.arrivalTime != p2.arrivalTime) {
            return p1.arrivalTime < p2.arrivalTime;
        } else if (p1.serviceType != p2.serviceType) {
            return p1.serviceType < p2.serviceType;
        } else {
            return p1.personID < p2.personID;
        }
    }

    public List<Integer> user_logic(int N, int K, List<Person> person) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (!isHigherPriority(person.get(i), person.get(j))) {
                    // Swap persons
                    Person temp = person.get(i);
                    person.set(i, person.get(j));
                    person.set(j, temp);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            result.add(person.get(i).personID);
        }

        return result;
    }

    public static void main(String[] args) {
        Day8 day8 = new Day8();

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, 10, 3, 2));
        personList.add(new Person(2, 5, 4, 1));
        personList.add(new Person(3, 15, 2, 3));
        personList.add(new Person(4, 20, 4, 2));
        personList.add(new Person(5, 25, 3, 1));

        int N = personList.size();
        int K = 3;

        List<Integer> result = day8.user_logic(N, K, personList);
        
        System.out.println(result); // Output: [2, 4, 1]
    }
}
