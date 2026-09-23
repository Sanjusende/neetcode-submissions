class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Array sort kar do
        Arrays.sort(nums);

        // Ek number fix karo
        for (int i = 0; i < nums.length - 2; i++) {

            // Duplicate first number skip karo
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Ab Two Sum karna hai
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                // Two Sum ka target = -nums[i]
                int sum = nums[left] + nums[right];

                // Agar nums[left] + nums[right] = -nums[i]
                if (sum == -nums[i]) {

                    result.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));

                    // Duplicate values skip karo
                    while (left < right &&
                           nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right &&
                           nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }

                // Sum chhota hai → bigger number chahiye
                else if (sum < -nums[i]) {
                    left++;
                }

                // Sum bada hai → smaller number chahiye
                else {
                    right--;
                }
            }
        }

        return result;
    }
}