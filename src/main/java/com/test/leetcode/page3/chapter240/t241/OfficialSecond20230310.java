package com.test.leetcode.page3.chapter240.t241;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialSecond20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 14:51
 * @Version: 1.0
 */
public class OfficialSecond20230310 {

    static final int ADDITION = -1;
    static final int SUBTRACTION = -2;
    static final int MULTIPLICATION = -3;

    /**
     * 方法二：动态规划
     *
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ops = new ArrayList<Integer>();
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

        //前面的就不说了
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<Integer>();
            }
        }
        // 下面会把数分离出来
        for (int i = 0; i < ops.size(); i += 2) {
            dp[i][i].add(ops.get(i));
        }
        for (int i = 2; i <= ops.size(); i++) {
            // 这个第一层循环的i，是下面循环里的l和r的间距
            for (int j = 0; j + i < ops.size(); j += 2) {
                // j从第一个数字开始，每次步长2，跳到下一个数字
                // 确定左侧边界和右侧边界
                int l = j;
                int r = j + i;
                for (int k = j + 1; k < r; k += 2) {
                    // k是操作数
                    List<Integer> left = dp[l][k - 1];
                    List<Integer> right = dp[k + 1][r];
                    // 笛卡尔积
                    for (int num1 : left) {
                        for (int num2 : right) {
                            if (ops.get(k) == ADDITION) {
                                dp[l][r].add(num1 + num2);
                            } else if (ops.get(k) == SUBTRACTION) {
                                dp[l][r].add(num1 - num2);
                            } else if (ops.get(k) == MULTIPLICATION) {
                                dp[l][r].add(num1 * num2);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][ops.size() - 1];
    }

}
