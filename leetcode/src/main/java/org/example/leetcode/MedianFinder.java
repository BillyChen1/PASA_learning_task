package org.example.leetcode;

import java.util.PriorityQueue;

/**
 * @author cqm
 * @date 2022/3/17
 **/
public class MedianFinder {
    //大根堆
    PriorityQueue<Integer> queMin = new PriorityQueue<>((a, b) -> (b - a));
    //小根堆
    PriorityQueue<Integer> queMax = new PriorityQueue<>((a, b) -> (a - b));

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMin.size() > queMax.size() + 1) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() == queMax.size()) {
            return (queMin.peek() + queMax.peek()) / 2.0;
        } else {
            return queMin.peek();
        }
    }
}
