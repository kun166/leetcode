package com.test.string;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-06 09:56
 */
@Slf4j
public class StringTest {

    @Test
    public void testIntern() {
        String str = "执行用时：\n" +
                "13 ms\n" +
                ", 在所有 Java 提交中击败了\n" +
                "51.73%\n" +
                "的用户\n" +
                "内存消耗：\n" +
                "41.8 MB\n" +
                ", 在所有 Java 提交中击败了\n" +
                "5.07%\n" +
                "的用户\n" +
                "通过测试用例：\n" +
                "189 / 189";
        System.out.println(str.replaceAll("\n", ""));
    }

    @Test
    public void test() {
        System.out.println("newCustomer".toUpperCase());
        System.out.println("newCustomer".toLowerCase());
    }


    @Test
    public void test2() {
        System.out.println(JSON.toJSONString(null));
    }


    @Test
    public void test4() {
        System.out.println("123".substring(0, 0));
    }

    @Test
    public void test10() {
        String idCard = "1234567890";
        System.out.println(idCard.substring(idCard.length() - 4));
    }

    @Test
    public void test11() {
        String str = "1. MinorGC：copy算法，回收新⽣代，回收eden、from，存活的放在to，多次回收后还存活的放到⽼年代中\n" +
                "2. ⽼年代回收⽤标记清除、标记整理算法，在回收的时候，finailize()可复活⼀次，只能调⽤⼀次\n" +
                "3. 标记-清除：先标记再清除，会产⽣内存碎⽚\n" +
                "4. 标记-复制：两块空间来回复制，内存利⽤为原来的⼀半\n" +
                "5. 标记-整理：将存活对象向⼀个⽅向移动，释放末尾空间\n" +
                "6. 空闲对象的查找⽅法：引⽤计数器法、根搜索法\n" +
                "7. GC Root：堆对象引⽤，⽅法区常量引⽤，静态对象引⽤，本地⽅法栈对象引⽤（都是对象引⽤）";
        String[] array = str.split("\n");
        for (String s : array) {
            System.out.println(s.split(" ")[1]);
        }
    }
}
