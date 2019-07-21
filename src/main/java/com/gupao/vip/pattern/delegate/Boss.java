package com.gupao.vip.pattern.delegate;

import lombok.Data;

/**
 * Boss类
 *
 * @author wangjixue
 * @date 2019-07-13 11:26
 */
@Data
public class Boss {

    public void command(String command, Leader leader){
        leader.doing(command);
    }
}
