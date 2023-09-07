package com.test.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: KMP
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/9/4 11:04
 * @Version: 1.0
 */
public class KMP {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(kmp("abababca")));
    }


    public int[] kmp(String s) {
        int length = s.length();
        int[] ans = new int[length];
        for (int i = 1, j = 0; i < length; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = ans[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            ans[i] = j;
        }
        return ans;
    }

}
