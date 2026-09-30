class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Agar s1 bada hai, to permutation s2 me nahi aa sakti
        if (s1.length() > s2.length()) {
            return false;
        }

        // s1 ke characters ka count
        int[] count1 = new int[26];

        // Current window ke characters ka count
        int[] count2 = new int[26];

        // s1 ke characters count karo
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }

        // s2 me s1 ki length ki window check karenge
        for (int i = 0; i < s2.length(); i++) {

            // Current character ko window me add karo
            count2[s2.charAt(i) - 'a']++;

            // Agar window s1 se badi ho gayi
            if (i >= s1.length()) {

                // Window ke leftmost character ko remove karo
                count2[s2.charAt(i - s1.length()) - 'a']--;
            }

            // Dono frequency arrays same hain?
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        // Koi permutation nahi mili
        return false;
    }
}