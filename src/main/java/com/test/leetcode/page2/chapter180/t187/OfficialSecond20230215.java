package com.test.leetcode.page2.chapter180.t187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: OfficialSecond20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 08:46
 * @Version: 1.0
 */
public class OfficialSecond20230215 {

    static final int L = 10;
    Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        // 对应二进制00
        put('A', 0);
        // 对应二进制01
        put('C', 1);
        // 对应二进制10
        put('G', 2);
        // 对应二进制11
        put('T', 3);
    }};

    /**
     * 哈希表 + 滑动窗口 + 位运算
     * <p>
     * 很牛逼，想不到
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        int n = s.length();
        if (n <= L) {
            return ans;
        }
        int x = 0;
        // 先初始化前9个字符
        for (int i = 0; i < L - 1; ++i) {
            x = (x << 2) | bin.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int i = 0; i <= n - L; ++i) {
            // 注意这个地方取的是s.charAt(i + L - 1),也就是从第10个字符(下标为9)开始取
            // x向右移两位，则右边两位为00,或(|)上新的字符的二进制，将新的字符加入。
            // 此时还需要将右移的高两位去掉，需要 & ((1 << (L * 2)) - 1)
            // 这个(1 << (L * 2)) - 1是一个常量，我觉得没必要每次都要计算

            // 呃,1本来是1位,结果右移20位为21位,-1之后就是一个20位且全是1的数
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        return ans;
    }
}
