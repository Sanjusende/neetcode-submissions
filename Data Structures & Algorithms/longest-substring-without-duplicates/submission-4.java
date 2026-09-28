class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            int length = right - left + 1;
            if (maxLength < length) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}
// class Solution {
//     public int lengthOfLongestSubstring(String s) {

//         // HashSet current window ke unique characters store karega
//         HashSet<Character> set = new HashSet<>();

//         // left = sliding window ka starting index
//         int left = 0;

//         // Ab tak ki longest substring ki length
//         int maxLength = 0;

//         // right pointer ek-ek character ko check karega
//         for (int right = 0; right < s.length(); right++) {

//             // Agar right wala character already Set me hai,
//             // iska matlab duplicate character mil gaya
//             while (set.contains(s.charAt(right))) {

//                 // Window ke left wale character ko remove karo
//                 set.remove(s.charAt(left));

//                 // Window ko left se chhota karo
//                 left++;
//             }

//             // Duplicate remove hone ke baad
//             // current character ko Set me add karo
//             set.add(s.charAt(right));

//             // Current window ki length
//             // Formula = right - left + 1
//             int length = right - left + 1;

//             // Agar current window previous maximum se badi hai
//             // to maxLength update karo
//             if (maxLength < length) {
//                 maxLength = length;
//             }
//         }

//         // Sabse badi unique substring ki length return karo
//         return maxLength;
//     }
// }