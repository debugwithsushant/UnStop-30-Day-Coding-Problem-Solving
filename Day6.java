// 3 Feb : Employee Money Transfer System

import java.util.*;

public class Day6 {
    public List<Boolean> canPaySalaries(int companyMoney, List<String> employeeNames, List<Integer> employeeSalaries) {
        List<Boolean> result = new ArrayList<>();

        for (int salary : employeeSalaries) {
            if (companyMoney >= salary) {
                result.add(true);
                companyMoney -= salary;
            } else {
                result.add(false);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Day6 solution = new Day6();
        List<String> employeeNames = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> employeeSalaries = Arrays.asList(1000, 2000, 1500);
        int companyMoney = 3000;

        List<Boolean> canPay = solution.canPaySalaries(companyMoney, employeeNames, employeeSalaries);
        System.out.println(canPay); // Output: [true, true, false]
    }
}
