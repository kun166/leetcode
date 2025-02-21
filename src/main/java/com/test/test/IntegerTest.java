package com.test.test;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import com.test.leetcode.ListNodeUtil;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 20:24
 */
public class IntegerTest {

    @Test
    public void test() {
//        BigDecimal bigDecimal = new BigDecimal(1100000L);
//        System.out.println(bigDecimal.divide(new BigDecimal("100")));
        Date date = new Date(1724382553905L);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date));
    }

    @Test
    public void test1() {
        System.out.println(1 << 2);
        System.out.println(-25 / 26);
    }

    @Test
    public void test2() {
        AtomicInteger nextHashCode = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            System.out.println(nextHashCode.getAndAdd(0x61c88647));
        }
//        System.out.println("51509348665875".hashCode() % 8);
//        System.out.println("2094995539933711737".hashCode() % 8);
    }

    @Test
    public void test3() {
        double d = 1 - 2d / 100d;
        double ans = 1;
        for (int i = 0; i < 100; i++) {
            ans *= d;
        }
        System.out.println(1 - ans);
    }

    @Test
    public void test4() {
        //double d = 0.02d;
        double result = 1.0d;
        for (int i = 0; i < 10; i++) {
            result = result * 0.98d;
        }
        System.out.println(1.0d - result);
    }

    @Test
    public void test5() {
        int n = 3;
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i - 1] = i;
        }
        dfs(array, 0);
    }

    private void dfs(int[] array, int index) {
        if (index == array.length) {
            System.out.println(JSON.toJSONString(array));
            return;
        }
        for (int i = index; i < array.length; i++) {
            // 两两交换位置？
            int first = array[index];
            array[index] = array[i];
            array[i] = first;
            dfs(array, index + 1);
            // 变回来？
            first = array[index];
            array[index] = array[i];
            array[i] = first;
        }
    }

    @Test
    public void test6() {
        int COUNT_BITS = 29;
        int RUNNING = -1 << COUNT_BITS;
        System.out.println(Integer.toBinaryString((1 << COUNT_BITS) - 1));
        System.out.println((1 << COUNT_BITS) - 1);
        System.out.println(Integer.toBinaryString(~((1 << COUNT_BITS) - 1)));


        System.out.println("------------------------");
        long start = 1500;
        long sum = 0;
        for (int i = 1; i <= 1511; i++) {
            sum += start + (i / 15) * 500;
//            if (sum > 876000) {
//                System.out.println(i);
//                break;
//            }
        }
        System.out.println(sum);
    }

    @Test
    public void test7() {
        System.out.println("------------------------");
        long start = 1500;
        long sum = 0;
        for (int i = 1; i <= 150; i++) {
            sum += start + (i / 15) * 500;
        }
        System.out.println(sum);
    }

    @Test
    public void test8() {
        System.out.println(77567701069843L % 8);
        System.out.println(10L == 10);

//        DecimalFormat df = new DecimalFormat("####,###");
//        System.out.println(df.format(new BigDecimal("3456.78")));
//        Calendar calendar = Calendar.getInstance();
//        System.out.println("有效期至" + (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日");
        String str = "15天";
        System.out.println(str.substring(0, str.length() - 1));
        System.out.println(str.substring(str.length() - 1));

        Date date = new Date();
        System.out.println(date.getDate());
        System.out.println(date.getMonth());
    }

    @Test
    public void test9() {
        ListNode head = ListNodeUtil.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(JSON.toJSONString(revers(head, null)));
        head = ListNodeUtil.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(JSON.toJSONString(revers(head)));
    }

    public ListNode revers(ListNode curr, ListNode pre) {
        if (curr.next == null) {
            curr.next = pre;
            return curr;
        }
        ListNode next = curr.next;
        curr.next = pre;
        return revers(next, curr);
    }

    public ListNode revers(ListNode curr) {
        ListNode pre = null;
        while (curr.next != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        curr.next = pre;
        return curr;
    }
}
