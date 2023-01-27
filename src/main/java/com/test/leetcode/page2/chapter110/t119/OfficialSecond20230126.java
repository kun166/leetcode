package com.test.leetcode.page2.chapter110.t119;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialSecond20230126
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/26 12:11
 * @Version: 1.0
 */
public class OfficialSecond20230126 {

    /**
     * 这看似只用了两个list，其实是多个list，比first稍微好一点。用过的list可以被垃圾回收了
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }
}
