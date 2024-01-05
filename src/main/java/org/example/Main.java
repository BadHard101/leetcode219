package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        if (k > nums.length) {
            for (int num : nums) set.add(num);
            return nums.length != set.size();
        } else {
            for (int i = 0; i < k; i++) {
                if (set.contains(nums[i])) return true;
                set.add(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                if (set.contains(nums[i])) return true;
                set.add(nums[i]);
                set.remove(nums[i-k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }
}