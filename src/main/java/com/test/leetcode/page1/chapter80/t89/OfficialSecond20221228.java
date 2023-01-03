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
     * <p>
     * 如果我们有一个二进制数序列，我们也可以将它直接转换成格雷码序列。假设n位二进制数为b，对应的格雷码为g，转换规则如下：
     * g(i)=b(i+1)⊕b(i),0≤i<n
     * 其中⊕是按位异或运算，g(i)和b(i)分别表示g和b的第i位，且b(n)=0。
     * 考虑n位二进制数b(i)和对应的转换码 g(i), 并且 b(i+1) = b(i) + 1 也是n位二进制数。
     * b(i+1)与b(i)的区别在于 b(i+1)将 b(i) 二进制下末位连接的1全部变成0，然后将最低位的0变成1。
     * 假设变化涉及到的二进制位数为k位，则按照上述转换规则， g(i+1)与g(i)只有在第k−1位不相同，其他位都相同。
     * 因此转换得到的码相邻的数只有一位不同，而转换码第一个整数和最后一个整数分别由二进制数0和 2^n-1转换而来，
     * 也只有一位不同。因为二进制数的取值范围为 [0,2^n]，且上述转换规则为一对一映射，
     * 因此得到的转换码也是互不相同的，且取值范围也在 [0,2^n]，得证。
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
