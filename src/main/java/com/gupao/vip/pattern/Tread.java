package com.gupao.vip.pattern;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangjixue
 * @date 2019-05-19 21:41
 */
public class Tread {
    // 默认线程数 一般是经验值：2*n+1 n:CPU核数； 理论值：单核CPU 1+[(I/O耗时)/(CPU耗时)]
    private static final int CONVERT_COLLECTION_PARAMETER = 5;

    public static void main(String[] args) {
        Map<Integer,List<String> >map  = new HashMap<Integer, List<String>>(CONVERT_COLLECTION_PARAMETER);
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (String s : list) {
            // 将集合元素根据哈希值散列到不同集合中
            int code = Math.abs(s.hashCode()) % CONVERT_COLLECTION_PARAMETER;
            if(map.get(code)!=null){
                map.get(code).add(s);
            }else{
                ArrayList<String> strings = new ArrayList<String>();
                strings.add(s);
                map.put(code,strings);
            }
        }
        System.err.println(JSON.toJSONString(list));
        System.err.println("=========散列后========");
        System.err.println(JSON.toJSONString(map));
    }
}
