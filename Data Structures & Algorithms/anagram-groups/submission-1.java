class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         // Har sorted string ke liye ek group store karega
        HashMap<String, List<String>> map = new HashMap<>();
       // strs array ke har element ko ek-ek karke str variable me rakho.
        for (String str : strs) {
            char [] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if (!map.containsKey(key)) {
                                          // Agar key pehle se map mein nahi hai,
                                               // to uske liye naya group banao
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
