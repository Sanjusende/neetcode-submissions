class Solution {
    public int maxArea(int[] heights) {

        // Left pointer array ke first element par
        int left = 0;

        // Right pointer array ke last element par
        int right = heights.length - 1;

        // Abhi tak ka maximum water
        int maxwater = 0;

        // Jab tak left aur right alag hain
        while (left < right) {

            // Dono bars ke beech ki width
            int width = right - left;

            // Water ki height chhoti wall decide karegi
            // Example: heights = [7, 6]
            // height = min(7, 6) = 6
            int height = Math.min(heights[left], heights[right]);

            // Container ka area
            // Formula: width × height
            int area = width * height;

            // Ab tak ke maximum area ko update karo
            maxwater = Math.max(maxwater, area);

            // Agar left wali wall chhoti hai
            // to left pointer ko aage move karo
            if (heights[left] < heights[right]) {
                left++;

            } 
            // Agar right wali wall chhoti ya equal hai
            // to right pointer ko peeche move karo
            else {
                right--;
            }
        }

        // Maximum water return karo
        return maxwater;
    }
}