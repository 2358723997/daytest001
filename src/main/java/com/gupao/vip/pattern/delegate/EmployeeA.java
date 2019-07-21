package com.gupao.vip.pattern.delegate;

/**
 * EmployeeA类
 *
 * @author wangjixue
 * @date 2019-07-13 11:31
 */
public class EmployeeA implements Employee{
    @Override
    public void doing(String command) {
        System.err.println("我是员工A，我正在完成"+command+"任务");
    }
}
