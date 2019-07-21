package com.gupao.vip.pattern.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * Leader类
 *
 * @author wangjixue
 * @date 2019-07-13 11:29
 */
public class Leader implements Employee{


    private Map<String , Employee> target = new HashMap<String, Employee>(2);

    public Leader() {
        target.put("鉴权",new EmployeeA());
        target.put("业务",new EmployeeB());
    }

    @Override
    public void doing(String command) {
        target.get(command).doing(command);
    }
}
