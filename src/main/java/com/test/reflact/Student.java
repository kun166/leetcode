package com.test.reflact;

/**
 * @ClassName: Student
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/22 17:41
 * @Version: 1.0
 */
public class Student implements People {

    @Override
    public People work(String workName) {
        System.out.println("工作内容是" + workName);
        return this;
    }

    @Override
    public String time() {
        return "2018-06-12";
    }
}
