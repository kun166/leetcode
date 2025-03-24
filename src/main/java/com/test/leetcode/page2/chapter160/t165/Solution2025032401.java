package com.test.leetcode.page2.chapter160.t165;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution2025032401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/24 09:11
 * @Version: 1.0
 */
public class Solution2025032401 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString("a.b".split("\\.")));
        System.out.println('1' == '.');
    }

    /**
     * 先来个最简单的吧
     * <p>
     * 1ms	击败73.50%
     * 40.79MB	击败44.69%
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        int index = 0;
        while (index < a1.length && index < a2.length) {
            Integer i1 = new Integer(a1[index]);
            Integer i2 = new Integer(a2[index]);
            if (!i1.equals(i2)) {
                return i1.compareTo(i2);
            }
            index++;
        }
        while (index < a1.length) {
            if (Integer.parseInt(a1[index++]) > 0)
                return 1;
        }
        while (index < a2.length) {
            if (Integer.parseInt(a2[index++]) > 0)
                return -1;
        }
        return 0;
    }
}
