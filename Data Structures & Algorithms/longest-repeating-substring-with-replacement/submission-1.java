class Solution {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];

        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            count[s.charAt(right) - 'A']++;

            maxFrequency = Math.max(
                maxFrequency,
                count[s.charAt(right) - 'A']
            );

            int windowLength = right - left + 1;

            int replacements = windowLength - maxFrequency;

            while (replacements > k) {

                count[s.charAt(left) - 'A']--;

                left++;

                windowLength = right - left + 1;

                replacements = windowLength - maxFrequency;
            }

            maxLength = Math.max(maxLength, windowLength);
        }

        return maxLength;
    }
}