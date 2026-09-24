class Solution {
public int trap(int[] height) {
int n = height.length;
if (n == 0) return 0;

// Step 1: Create leftMax and rightMax arrays
int[] leftMax = new int[n];
int[] rightMax = new int[n];

// Step 2: Fill leftMax array
leftMax[0] = height[0];
for (int i = 1; i < n; i++) {
leftMax[i] = Math.max(leftMax[i - 1], height[i]);
}

// Step 3: Fill rightMax array
rightMax[n - 1] = height[n - 1];
for (int i = n - 2; i >= 0; i--) {
rightMax[i] = Math.max(rightMax[i + 1], height[i]);
}

// Step 4: Calculate water trapped at each index
int totalWater = 0;
for (int i = 0; i < n; i++) {
// Water trapped is min(leftMax, rightMax) - current height
int waterLevel = Math.min(leftMax[i], rightMax[i]) - height[i];
totalWater += waterLevel;
}

return totalWater;
}
}