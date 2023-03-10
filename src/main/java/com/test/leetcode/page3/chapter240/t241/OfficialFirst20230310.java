package com.test.leetcode.page3.chapter240.t241;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 14:22
 * @Version: 1.0
 */
public class OfficialFirst20230310 {

    // +
    static final int ADDITION = -1;
    // -
    static final int SUBTRACTION = -2;
    // *
    static final int MULTIPLICATION = -3;

    /**
     * 方法一：记忆化搜索
     *
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ops = new ArrayList<Integer>();
        // 解析表达式
        for (int i = 0; i < expression.length(); ) {
            if (!Character.isDigit(expression.charAt(i))) {
                if (expression.charAt(i) == '+') {
                    ops.add(ADDITION);
                } else if (expression.charAt(i) == '-') {
                    ops.add(SUBTRACTION);
                } else {
                    ops.add(MULTIPLICATION);
                }
                i++;
            } else {
                int t = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    t = t * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ops.add(t);
            }
        }

        // 二维数组？
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<Integer>();
            }
        }
        return dfs(dp, 0, ops.size() - 1, ops);
    }

    /**
     * 初始化从l到r的所有结果，存放到list里
     *
     * @param dp  dp数组
     * @param l   左边界
     * @param r   右边界
     * @param ops 操作数列表
     * @return
     */
    public List<Integer> dfs(List<Integer>[][] dp, int l, int r, List<Integer> ops) {
        // 为空就初始化
        if (dp[l][r].isEmpty()) {
            // 这一步，无限拆分之后，最终只会获取到数值，而不是计算符号……
            if (l == r) {
                dp[l][r].add(ops.get(l));
            } else {
                // 左右两个边界不相等，每隔两个位置拆分。因为从left开始拆,left肯定是数,left+1是计算符号
                // 能保证dp[l][r]存放的一定是数
                for (int i = l; i < r; i += 2) {
                    // 从左边界到右边界，每两个距离拆分
                    // 递归拆
                    // 左侧
                    List<Integer> left = dfs(dp, l, i, ops);
                    // 右侧
                    List<Integer> right = dfs(dp, i + 2, r, ops);
                    // 笛卡尔积
                    for (int lv : left) {
                        for (int rv : right) {

                            if (ops.get(i + 1) == ADDITION) {
                                dp[l][r].add(lv + rv);
                            } else if (ops.get(i + 1) == SUBTRACTION) {
                                dp[l][r].add(lv - rv);
                            } else {
                                dp[l][r].add(lv * rv);
                            }
                        }
                    }
                }
            }
        }
        return dp[l][r];
    }

}
