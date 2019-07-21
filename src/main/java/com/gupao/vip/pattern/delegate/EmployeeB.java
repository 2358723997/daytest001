package com.gupao.vip.pattern.delegate;

/**
 * EmployeeA类
 *
 * @author wangjixue
 * @date 2019-07-13 11:31
 */
public class EmployeeB implements Employee{
    @Override
    public void doing(String command) {
        System.err.println("我是员工B，我正在完成"+command+"任务");
    }
}
