package com.test.leetcode.page4.chapter390.t391;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Official20230517
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/17 09:52
 * @Version: 1.0
 */
public class Official20230517 {

    /**
     * 解法感觉很巧妙啊
     * 第一:判定各个区域的面积和
     * 第二:判定顶点
     *
     * @param rectangles
     * @return
     */
    public boolean isRectangleCover(int[][] rectangles) {
        long area = 0;
        // 最小x，最小y，最大x，最大y
        int minX = rectangles[0][0], minY = rectangles[0][1], maxX = rectangles[0][2], maxY = rectangles[0][3];
        // 顶点，及出现的次数。这个想法很妙啊，比判定相交简单多了
        Map<Point, Integer> cnt = new HashMap<Point, Integer>();
        for (int[] rect : rectangles) {
            // 拿到该点的左下角x,y和右上角a,b
            int x = rect[0], y = rect[1], a = rect[2], b = rect[3];
            // 计算该区域面积
            area += (long) (a - x) * (b - y);

            // 计算整个区域的最小x,y最大x,y
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, a);
            maxY = Math.max(maxY, b);

            // 计算四个顶点
            Point point1 = new Point(x, y);
            Point point2 = new Point(x, b);
            Point point3 = new Point(a, y);
            Point point4 = new Point(a, b);

            // 将四个订单出现的次数存放到map里
            cnt.put(point1, cnt.getOrDefault(point1, 0) + 1);
            cnt.put(point2, cnt.getOrDefault(point2, 0) + 1);
            cnt.put(point3, cnt.getOrDefault(point3, 0) + 1);
            cnt.put(point4, cnt.getOrDefault(point4, 0) + 1);
        }

        // 整个区域的四个顶点
        Point pointMinMin = new Point(minX, minY);
        Point pointMinMax = new Point(minX, maxY);
        Point pointMaxMin = new Point(maxX, minY);
        Point pointMaxMax = new Point(maxX, maxY);
        // 判断整个区域的面积是否和每个区域的面积之和相等。判断四个顶点是否仅出现一次
        if (area != (long) (maxX - minX) * (maxY - minY) || cnt.getOrDefault(pointMinMin, 0) != 1 || cnt.getOrDefault(pointMinMax, 0) != 1 || cnt.getOrDefault(pointMaxMin, 0) != 1 || cnt.getOrDefault(pointMaxMax, 0) != 1) {
            return false;
        }

        // 将四个订单从map里面去除
        cnt.remove(pointMinMin);
        cnt.remove(pointMinMax);
        cnt.remove(pointMaxMin);
        cnt.remove(pointMaxMax);

        // 剩余的顶点，要么是4，要么是2
        for (Map.Entry<Point, Integer> entry : cnt.entrySet()) {
            int value = entry.getValue();
            if (value != 2 && value != 4) {
                return false;
            }
        }
        return true;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point2 = (Point) obj;
            return this.x == point2.x && this.y == point2.y;
        }
        return false;
    }
}
