package com.test.design.decorate;

/**
 * @ClassName: MaleRole
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/16 16:10
 * @Version: 1.0
 */
public class MaleRole implements Role {

    @Override
    public void decorate() {
        System.out.println("初始化男性角色");
    }
}
