package com.test.leetcode.page1.chapter80.t89;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20221228
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/28 09:07
 * @Version: 1.0
 */
public class OfficialFirst20221228 {

    /**
     * 对称生成
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }
        return ret;
    }
}
