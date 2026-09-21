class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodingstr = new StringBuilder();
        for(String str : strs){
            encodingstr.append(str.length()).append("#").append(str);
        }
        return encodingstr.toString();

    }

  public List<String> decode(String s) {

    List<String> result = new ArrayList<>();
    int i = 0;

    while (i < s.length()) {

        int j = s.indexOf('#', i);//i se start karo and next # find karo.

        int len = Integer.parseInt(s.substring(i, j));//i se start karo and j se pehle tak characters lo.

        result.add(s.substring(j + 1, j + 1 + len));

        i = j + 1 + len;
    }
  
    return result;
    
    }
}
