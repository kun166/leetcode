package com.test.leetcode.page2.chapter130.t134;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-20 17:36
 */
public class SolutionOffice {

    /**
     * 这个官方解答的思路是,从点x出发，如果最远能到y的话(不考虑折返,假设x<y),
     * 则x到y之间的任意一个加油站最远也只能到y
     * <p>
     * 思路：从x到y的之间的某个加油站z，既然已经到达z了，说明到z的时候，剩余油量最少是0。
     * 而如果从z出发，剩余油量为0，所以z到达的最远也只能是y
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 长度
        int n = gas.length;
        // 从下标为0的加油站开始尝试
        int i = 0;
        while (i < n) {
            // 累加剩余汽油量,累加消耗汽油量
            int sumOfGas = 0, sumOfCost = 0;
            // 经过的加油站数量
            int cnt = 0;
            while (cnt < n) {
                // 因为是一个圆,加油站编号有可能折返。
                // 比如有10个加油站，第五个加油站作为起始加油站，到达10之后，会折返到第一个
                // j是当前加油站的下标
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                // 如果无法达到下一个加油站，则跳出以该i为起点加油站的尝试
                if (sumOfCost > sumOfGas) {
                    break;
                }
                // 否则，经过的加油站数量+1
                cnt++;
            }
            if (cnt == n) {
                // 如果经过的加油站数量是n，则完成了任务，转一圈
                return i;
            } else {
                // 否则，根据得到的推论，尝试下标为(i + cnt + 1)的加油站为起始加油站
                i = i + cnt + 1;
            }
        }
        // 全部加油站为起始加油站都尝试过了，未找到符合条件的加油站
        return -1;
    }
}
