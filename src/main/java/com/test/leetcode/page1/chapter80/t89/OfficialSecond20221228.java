package com.test.leetcode.page1.chapter80.t89;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 *
 * @ClassName: OfficialSecond20221228
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/28 09:08
 * @Version: 1.0
 */
public class OfficialSecond20221228 {

    @Test
    public void test() {
        List<Integer> list = grayCode(3);
        System.out.println(JSON.toJSONString(list));
    }

    /**
     * 二进制数转格雷码
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }
}
