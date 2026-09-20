class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Number ki frequency store karne ke liye
        HashMap<Integer, Integer> map = new HashMap<>();

        // Har number ki frequency count karo
        for (int num : nums) {

            if (map.containsKey(num)) {
                // Number already hai, frequency +1
                map.put(num, map.get(num) + 1);
            } else {
                // Number first time mila
                map.put(num, 1);
            }
        }

        // Map ke saare numbers ko List me convert karo
        ArrayList<Integer> list = new ArrayList<>(map.keySet());

        // Frequency ke according highest to lowest sort karo
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // Top k elements store karne ke liye
        int[] result = new int[k];

        // First k elements answer me daalo
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}