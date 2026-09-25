class Solution {
    public int trap(int[] height) {

        // Array ki length
        int n = height.length;

        // Agar array empty hai to water = 0
        if (n == 0) {
            return 0;
        }

        // leftMax[i] = index i ke left side ka maximum height
        int[] leftMax = new int[n];

        // rightMax[i] = index i ke right side ka maximum height
        int[] rightMax = new int[n];


        // -------------------------------
        // STEP 1: leftMax array banana
        // -------------------------------

        // First element ke left mein kuch nahi hai,
        // isliye leftMax[0] current height hi hogi
        leftMax[0] = height[0];

        // Left se right ki taraf jao
        for (int i = 1; i < n; i++) {

            // Previous maximum aur current height mein
            // jo bada hai, wahi leftMax[i] hoga
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }


        // -------------------------------
        // STEP 2: rightMax array banana
        // -------------------------------

        // Last element ke right mein kuch nahi hai,
        // isliye rightMax[last] current height hi hogi
        rightMax[n - 1] = height[n - 1];

        // Right se left ki taraf jao
        for (int i = n - 2; i >= 0; i--) {

            // Previous right maximum aur current height mein
            // jo bada hai, wahi rightMax[i] hoga
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }


        // -------------------------------
        // STEP 3: Water calculate karna
        // -------------------------------

        // Total trapped water
        int totalWater = 0;

        // Har position par water calculate karo
        for (int i = 0; i < n; i++) {

            // Water ki height smaller boundary decide karegi
            //
            // Example:
            // leftMax = 3
            // rightMax = 5
            // current height = 1
            //
            // Water = min(3, 5) - 1
            //       = 3 - 1
            //       = 2
            int waterLevel =
                Math.min(leftMax[i], rightMax[i]) - height[i];

            // Current position ka water total mein add karo
            totalWater = totalWater + waterLevel;
        }


        // Total trapped water return karo
        return totalWater;
    }
}