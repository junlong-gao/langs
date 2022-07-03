package com.example;

public class ProjectRunner {
    public static void main(String args[]) {
        // Some examples...
        int[] nums = new int[]{1,-1,5,-2,3};
        int k = 3;

        int ans = com.lc.P325.Solution.maxSubArrayLen(nums, k);
        System.out.printf("ans=%d\n", ans);

        nums = new int[]{0,1,0,3,12};
        com.lc.P283.Solution.moveZeroes(nums);
        System.out.printf("{");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", i);
        }
        System.out.printf("}");
    }
}
