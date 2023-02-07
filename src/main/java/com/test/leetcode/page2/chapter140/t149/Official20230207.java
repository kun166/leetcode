package com.test.leetcode.page2.chapter140.t149;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Official20230207
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/7 08:38
 * @Version: 1.0
 */
public class Official20230207 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            // 1个点就一个，2个点就两个
            return n;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            // 点i之后，最多还有n-i个点位，如果ret>=n-i，后面就不用判了
            // 同理,如果i之前的直线上已经聚集了超过n/2的点了，后面的直线上的点也不可能超过n/2了，跳出循环
            if (ret >= n - i || ret > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < n; j++) {
                // 判断i之后的点位。
                // 计算i和j两点之间的x,y差值，求斜率
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                // 对横纵坐标上的点特殊处理
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    /**
     * 求a,b的最大公约数……
     * 这个算法牛逼了，一定要记住啊，要记住
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
