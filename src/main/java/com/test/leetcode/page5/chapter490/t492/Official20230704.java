package com.test.leetcode.page5.chapter490.t492;

/**
 * @ClassName: Official20230704
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/4 16:02
 * @Version: 1.0
 */
public class Official20230704 {

    /**
     * 这写法就问你吊不吊吧
     *
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }
}
