public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(result, path, nums, 0);
        return result;
        
    }

    void dfs(List<List<Integer>> result, ArrayList<Integer> path, int[] nums, int start) {
        result.add(new ArrayList<Integer>(path));
        if(start >= nums.length) return;

        for(int i=start; i<nums.length; i++) {
            path.add(nums[i]);
            dfs(result, path, nums, i+1);
            path.remove(path.size()-1);
        }
    }
}

public class Solution2 { //bit operation (1>>n) or Math.pow(2,n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i=0; i<(1<<nums.length); i++) {
            List<Integer> subset = new ArrayList<Integer>();

            for(int j=0; j<nums.length; j++) {
                if( ((1<<j)&i) != 0 ) {
                    subset.add(nums[j]);
                }
            }

            Collections.sort(subset);
            result.add(subset);
        }
        return result;
        
    }
}