package com.test.leetcode.page3.chapter250.t255;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Other20230317
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/17 07:48
 * @Version: 1.0
 */
public class Other20230317 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(getFactors(32)));
    }


    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> retList = new LinkedList<>();
        if (n == 1) {
            return retList;
        }
        List<Integer> path = new LinkedList<>();
        dfsTraverse(retList, 2, n, path);
        return retList;
    }

    private void dfsTraverse(List<List<Integer>> retList, int start, int n, List<Integer> path) {
        if (n == 1) {
            if (path.size() > 1) {
                retList.add(new LinkedList<>(path));
            }
            return;
        }
        // 遍历所有可能的选择 进行选择
        for (int i = start; i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            path.add(i);
            // 回溯
            dfsTraverse(retList, i, n / i, path);
            // 退回选择
            path.remove(path.size() - 1);
        }
    }
}
