public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();

        Arrays.sort(candidates);
        dfs(result, solution, candidates, target, 0);

        return result;
    }

    void dfs(List<List<Integer>> result, List<Integer> solution, int[] candidates, int target, int start) {
        if(target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            solution.add(candidates[i]);
            dfs(result, solution, candidates, target - candidates[i], i);
            solution.remove(solution.size()-1);
        }
    }
}