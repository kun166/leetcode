package com.test.other;

import org.junit.Test;
import sun.misc.Contended;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: TestFlash
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/11/25 15:54
 * @Version: 1.0
 */
//使用了volatile
public class VolatileDemo {

    public static volatile boolean stop = false;//任务是否停止，volatile变量

    public static void main(String[] args) throws Exception {

        Thread threadl = new Thread(() -> {
            while (!stop) { //stop=fa1se，不满足停止茶件，继续执行
                //do someting
            }
            System.out.println("stop=true，满足停止条件。" + "停止时间：" + System.currentTimeMillis());
        });
        threadl.start();
        Thread.sleep(100);//保证主线程修改stop=true，在子线程动后执行。
        stop = true; //true
        System.out.println("主线程设置停止标识 stop = true。" + "设置时间：" + System.currentTimeMillis());
    }
}



