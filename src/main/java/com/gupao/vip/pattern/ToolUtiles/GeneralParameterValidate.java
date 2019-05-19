package com.gupao.vip.pattern.ToolUtiles;

/**
 * @author wangjixue
 * @date 2019-05-18 15:18
 */
public class GeneralParameterValidate {
    private <T> boolean isNull(T parameter){

        if(parameter instanceof String){
            return ((String) parameter).isEmpty();
        }

        return true;
    }
}
