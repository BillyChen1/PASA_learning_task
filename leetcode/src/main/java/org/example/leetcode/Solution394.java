package org.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cqm
 * @date 2022/3/18
 **/
public class Solution394 {
    public String decodeString(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<String> strs = new LinkedList<>();
        int num = 0;
        StringBuilder res = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                num = num * 10 + arr[i] - '0';
            } else if (arr[i] >= 'a' && arr[i] <= 'z') {
                res.append(arr[i]);
            } else if (arr[i] == '[') {
                nums.push(num);
                num = 0;
                strs.push(res.toString());
                res = new StringBuilder();
            } else {
                int times = nums.pop();
                // tmp为[入栈之前暂存的结果
                String tmp = strs.pop();
                for (int j = 0; j < times; j++) {
                    tmp += res.toString();
                }
                res = new StringBuilder(tmp);
            }
        }
        return res.toString();
    }
}
