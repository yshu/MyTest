public class Solution {
    public int totalNQueens(int n) {
        ArrayList<ArrayList<Integer>> result  = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        dfs(result, solution, n);
        return result.size();
    }

    void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution, int n) {
        if(solution.size() == n) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }

        for(int i=0; i<n; i++) {
            if(isValid(solution, i)) {
                solution.add(i);
                dfs(result, solution, n);
                solution.remove(solution.size()-1); 
            }
        }
    }

    boolean isValid(ArrayList<Integer> solution, int i) {
        for(int j=0; j<solution.size(); j++) {
            if(i == solution.get(j)) return false;
            if( solution.get(j)+solution.size()-j == i) return false;
            if( solution.get(j)-solution.size()+j == i) return false;
        }  

        return true; 
    }
}