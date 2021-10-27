//Rearrange Words
class Solution {
    public String arrangeWords(String text) {
        if(text == null || text.length() == 0) {
            return "";
        }
        String[] parts = text.split(" ");
        
        Arrays.sort(parts, (a,b) -> a.length() - b.length());
        StringBuilder result = new StringBuilder();
        for(String s : parts) {
            result.append(s.toLowerCase());
            result.append(" ");
        }
        String resultString = Character.toUpperCase(result.charAt(0))+ result.toString().substring(1);
        return resultString.trim();
    }
}

//Evealuate the bracket pairs of string
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        if(s == null || s.length() == 0) {
            return "";
        }
        Map<String, String> map = new HashMap<>();
        for(List<String> k : knowledge) {
            String key = k.get(0);
            String val = k.get(1);
            map.put(key, val);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                i++;
                StringBuilder sb = new StringBuilder();
                while(s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                    i++;
                }
                if(map.containsKey(sb.toString())) {
                    result.append(map.get(sb.toString()));
                } else {
                    result.append("?");
                }
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}