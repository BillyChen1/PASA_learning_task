package org.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cqm
 * @date 2022/3/13
 **/
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] ans = new int[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int i = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            ans[i++] = course;
            for (int target : adjacency.get(course)) {
                if (--inDegree[target] == 0) {
                    q.offer(target);
                }
            }
        }
        if (i == numCourses) {
            return ans;
        } else {
            return new int[]{};
        }
    }
}
