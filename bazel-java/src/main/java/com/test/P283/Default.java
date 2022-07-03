package com.lc.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Default {
  @Test
  public void example() throws Exception {
    int[] nums = new int[]{0,1,0,3,12};

    com.lc.P283.Solution.moveZeroes(nums);

    assertArrayEquals(nums, new int[]{1, 3, 12, 0, 0});
  }
}