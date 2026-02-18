// 18 Feb : Carrom Coin Clearance Challenge

import java.util.Arrays;

public class Day21 {
    public static int minEnergyToClearCoins(int[] angles) {
        Arrays.sort(angles);
        int totalEnergy = angles[0];
        for(int i = 1; i < angles.length; i++) {
            int energyDiff = angles[i] - angles[i-1];
            totalEnergy += energyDiff;
        }
        return totalEnergy;
    }

    public static void main(String[] args) {
        int[] angles = {30, 60, 90, 120};
        int energy = minEnergyToClearCoins(angles);
        System.out.println("Minimum energy required: " + energy); // Output: Minimum energy required: 150
    }
}