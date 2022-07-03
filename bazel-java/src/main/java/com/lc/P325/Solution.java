package com.lc.P325;

import java.util.HashMap;

public class Solution {
    public static int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
        int curSum = 0;
        int soFar = 0;
        for(int i = 0; i < nums.length; i ++){
            curSum += nums[i];
            if(curSum == k){
                soFar = Math.max(soFar, i+1);
            }else{
                Integer index = sums.get(curSum - k);
                if(index != null){
                    soFar = Math.max(soFar, i - index);
                }
            }
            if(!sums.containsKey(curSum)){
                sums.put(curSum, i);
            }
        }
        return soFar;
    }
}
