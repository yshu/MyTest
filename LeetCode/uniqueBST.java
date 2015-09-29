public class Solution {
    public int numTrees(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        //if(n == 3) return 5;
        //if(n == 4) return 14;
        
        int sum = 0;
        int i = n;
        for(int j=n; j>0; j=j-2) {
            if(j > 2) {
                sum += numTrees(i-1) * numTrees(n-i) * 2;
            }
            else {
                sum += numTrees(i-1) * numTrees(n-i) * j;
            }
            i--;
        }

        return sum;
    }
}