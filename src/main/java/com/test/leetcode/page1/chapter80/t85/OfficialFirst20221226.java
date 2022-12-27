package com.test.leetcode.page1.chapter80.t85;

/**
 * @ClassName: OfficialFirst20221226
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/26 19:57
 * @Version: 1.0
 */
public class OfficialFirst20221226 {

    /**
     * 时间复杂度：O(m^2n)，其中 mm 和 nn 分别是矩阵的行数和列数。计算 left 矩阵需要 O(mn) 的时间。随后对于矩阵的每个点，需要 O(m) 的时间枚举高度。故总的时间复杂度为 O(mn) +O(mn)⋅O(m)=O(m^2n)。
     * <p>
     * 空间复杂度：O(mn)，其中 mm 和 nn 分别是矩阵的行数和列数。我们分配了一个与给定矩阵等大的数组，用于存储每个元素的左边连续 1 的数量。
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        // 取矩阵的行数
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        // 取矩阵的列数
        int n = matrix[0].length;
        // 记录{i,j}这个坐标左侧的1的个数
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    // 如果{i,j}坐标是'0',则直接略过
                    continue;
                }
                // 下面是以{i,j}为右下角，然后往左往上找方格面积
                // 坐标{i,j}左侧的1的个数，即宽度
                int width = left[i][j];
                // 如果仅仅是一行的话，这个就是面积了
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}
