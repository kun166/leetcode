package com.test.leetcode.page1.chapter80.t89;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 *
 * @ClassName: OfficialFirst20221228
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/28 09:07
 * @Version: 1.0
 */
public class OfficialFirst20221228 {

    @Test
    public void test() {
        List<Integer> list = grayCode(3);
        for (Integer i : list) {
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println(JSON.toJSONString(list));
    }

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
                // 对ret存的数，倒序取(为什么要倒序取？因为需要对称啊)，取了之后，再二进制最高位上置1
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }
        return ret;
    }
}
