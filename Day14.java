// 11 Feb : Optimal Food Kit Allocation for Daily Needs

import java.util.Arrays;

public class Day14 {
    public static int max_people_with_calories(int[] needs, int[] kits) {
        Arrays.sort(needs);
        Arrays.sort(kits);

        int i = 0;
        int j = 0;
        int count = 0;

        while(i < needs.length && j < kits.length) {
            if(needs[i] <= kits[j]){
                    count++;
                    i++;
                    j++;
            } else {
                j++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] needs = {500, 1000, 1500, 2000};
        int[] kits = {800, 1200, 1600, 2500};

        int result = max_people_with_calories(needs, kits);
        System.out.println(result);
    }
}