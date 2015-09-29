public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();

        dfs(result, solution, k, n, 1);

        return result;
    }

    void dfs(List<List<Integer>> result, List<Integer> solution, int k, int n, int start) {
        if(n < 0 || k < 0) return;
        if(n == 0 && k == 0) {
            result.add(new ArrayList<Integer>(solution));
        }

        for(int i=start; i<10; i++) {
            solution.add(i);
            dfs(result, solution, k-1, n-i, i+1);
            solution.remove(solution.size()-1);
        }

    }
}