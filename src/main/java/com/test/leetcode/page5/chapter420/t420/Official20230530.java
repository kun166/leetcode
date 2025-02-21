package com.test.leetcode.page5.chapter420.t420;

/**
 * @ClassName: Official20230530
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/30 17:40
 * @Version: 1.0
 */
public class Official20230530 {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        // 计算数字，小写字母，大写字母需要修改的次数
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (int i = 0; i < n; ++i) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLower = 1;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = 1;
            } else if (Character.isDigit(ch)) {
                hasDigit = 1;
            }
        }
        // 需要修改的次数
        int categories = hasLower + hasUpper + hasDigit;

        if (n < 6) {
            // 这个时候，密码长度最长为5，最大重复次数也只是5，修改仅需要重复次数/3,也即最多是5/3=1，可以不判断
            return Math.max(6 - n, 3 - categories);
        } else if (n <= 20) {
            // 如果长度小于等于20，则不需要删除字符串
            // 需要替换的次数
            int replace = 0;
            // 重复的次数
            int cnt = 0;
            // 重复的字符串，预设值了一个字符串中没有的字符为开始字符
            char cur = '#';

            for (int i = 0; i < n; ++i) {
                char ch = password.charAt(i);
                if (ch == cur) {
                    // 如果重复就+1
                    ++cnt;
                } else {
                    // 不重复的话就需要计算各个值了
                    replace += cnt / 3;
                    cnt = 1;
                    cur = ch;
                }
            }
            // 最后别忘了最后一个重复字符的次数
            replace += cnt / 3;
            // 返回最大值
            return Math.max(replace, 3 - categories);
        } else {
            // 下面这个逻辑是最难的
            // 替换次数和删除次数
            int replace = 0, remove = n - 20;
            // k mod 3 = 1 的组数，即删除 2 个字符可以减少 1 次替换操作
            // k mod 3 =1 ,是如4,7,10等这种
            int rm2 = 0;
            int cnt = 0;
            char cur = '#';

            for (int i = 0; i < n; ++i) {
                char ch = password.charAt(i);
                if (ch == cur) {
                    ++cnt;
                } else {
                    if (remove > 0 && cnt >= 3) {
                        if (cnt % 3 == 0) {
                            // 3个的话删除一个字符，就不用替换了。6个的话，删除一个，只需要替换1个。9个的话，删除一个只需要替换2个
                            // 如果是 k % 3 = 0 的组，那么优先删除 1 个字符，减少 1 次替换操作
                            --remove;
                            --replace;
                        } else if (cnt % 3 == 1) {
                            // cnt % 3 == 0 需要删除1次，那么cnt % 3 == 1就需要删除两次……
                            // 如果是 k % 3 = 1 的组，那么存下来备用
                            ++rm2;
                        }
                        // cnt % 3 == 0删除一个的目的就是为了 cnt % 3 == 2，同理cnt % 3 == 1删除两个也是为了cnt % 3 == 2
                        // k % 3 = 2 的组无需显式考虑
                    }
                    // 替换的个数为cnt/3，向下取整
                    replace += cnt / 3;
                    // cnt重置为1
                    cnt = 1;
                    // 重复支付为ch
                    cur = ch;
                }
            }
            // 下面逻辑只不过是处理尾部重复的字符串，和上面ch != cur是一样的
            if (remove > 0 && cnt >= 3) {
                if (cnt % 3 == 0) {
                    --remove;
                    --replace;
                } else if (cnt % 3 == 1) {
                    ++rm2;
                }
            }
            replace += cnt / 3;

            // 使用 k % 3 = 1 的组的数量，由剩余的替换次数、组数和剩余的删除次数共同决定
            int use2 = Math.min(Math.min(replace, rm2), remove / 2);
            replace -= use2;
            remove -= use2 * 2;
            // 由于每有一次替换次数就一定有 3 个连续相同的字符（k / 3 决定），因此这里可以直接计算出使用 k % 3 = 2 的组的数量
            int use3 = Math.min(replace, remove / 3);
            replace -= use3;
            remove -= use3 * 3;
            return (n - 20) + Math.max(replace, 3 - categories);
        }
    }
}
