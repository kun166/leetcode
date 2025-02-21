package com.test.leetcode.page5.chapter400.t406;

import java.util.Arrays;

/**
 * @ClassName: Official20230525
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/25 16:19
 * @Version: 1.0
 */
public class Official20230525 {

    /**
     * 原理：
     * 如果每个人的身高都不同，我们按身高从低到高排列。
     * 我们设人数为n，在进行排序后，它们的身高依次为h(0),h(1)……h(n-1)，且排在第i个人前面身高大于h(i)的人数为 k(i)。
     * 如果我们按照排完序后的顺序，依次将每个人放入队列中，那么当我们放入第i个人时：
     * 第0,⋯,i−1个人已经在队列中被安排了位置，并且他们无论站在哪里，对第i个人都没有任何影响，因为他们都比第i个人矮；
     * 而第i+1,⋯,n−1个人还没有被放入队列中，但他们只要站在第i个人的前面，就会对第i个人产生影响，因为他们都比第i个人高。
     * <p>
     * 如果我们在初始时建立一个包含n个位置的空队列，而我们每次将一个人放入队列中时，会将一个「空」位置变成「满」位置，
     * 那么当我们放入第i个人时，我们需要给他安排一个「空」位置，并且这个「空」位置前面恰好还有k(i)个「空」位置，
     * 用来安排给后面身高更高的人。也就是说，第i个人的位置，就是队列中从左往右数第k(i)+1个「空」位置。
     * <p>
     * 题中对于身高相同的人，我们可以认为k值小的身高更高来处理就可以了
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // 对people进行排序,先根据身高正序排序，再根据前面的人数倒序排序
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                // 先对身高进行正序排序
                return person1[0] - person2[0];
            } else {
                // 对于身高相同的，k值大的认为更矮来处理
                return person2[1] - person1[1];
            }
        });
        // 传入的数组长度
        int n = people.length;
        // 返回值
        int[][] ans = new int[n][];
        for (int[] person : people) {
            // 占据的位置，前面的人数加上他自身？
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
