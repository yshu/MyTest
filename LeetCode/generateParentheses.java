public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder s = new StringBuilder();

        dfs(result, s, n, n);
        
        return result;
    }

    void dfs (List<String> result, StringBuilder s, int left, int right) {
        if(left == 0 && right == 0) {
            result.add(s.toString());
            return;
        }
        if(left > 0) {
            s.append("(");
            dfs(result, s, left-1, right);
            s.setLength(s.length()-1);
        }
        if(right > 0 && left < right) {
            s.append(")");
            dfs(result, s, left, right-1);
            s.setLength(s.length()-1);
        }
    }
}