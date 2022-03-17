package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author cqm
 * @date 2022/3/17
 **/
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        //统计次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //小根堆 升序
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                if (count > queue.peek()[1]) {
                    queue.remove();
                    queue.add(new int[]{num, count});
                }
            } else {
                queue.add(new int[]{num, count});
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.remove()[0];
        }

        return ans;
    }

}
