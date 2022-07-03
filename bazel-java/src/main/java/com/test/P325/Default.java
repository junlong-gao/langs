package com.lc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Default {
  @Test
  public void example() throws Exception {
    int[] nums = new int[]{1,-1,5,-2,3};
    int k = 3;

    int ans = com.lc.P325.Solution.maxSubArrayLen(nums, k);

    assertEquals(ans, 4);
  }
}