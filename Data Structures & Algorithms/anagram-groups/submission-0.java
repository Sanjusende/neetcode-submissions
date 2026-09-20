class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){    //strs array ke har element ko
                                 // ek-ek karke str variable me rakho.

            char [] ch = str.toCharArray();//covert string array to charArray
            Arrays.sort(ch);
            String st=new String(ch); //char to String
            if(!map.containsKey(st)){  // Agar key pehle se map mein nahi hai,
                                            // to uske liye naya group banao
                map.put(st,new ArrayList<>());
            }
            map.get(st).add(str);

        }
        return new ArrayList<>(map.values());
    }
}
