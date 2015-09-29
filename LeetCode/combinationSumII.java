public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();

        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        dfs(result, solution, candidates, target, 0, visited);

        return result;
    }

    void dfs(List<List<Integer>> result, List<Integer> solution, int[] candidates, int target, int start, boolean[] visited) {
        if(target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            if(i>0 && candidates[i]==candidates[i-1] && visited[i-1]==false) continue;
            solution.add(candidates[i]);
            visited[i] = true;
            dfs(result, solution, candidates, target-candidates[i], i+1, visited);
            solution.remove(solution.size()-1);
            visited[i] = false;
        }
    }
}