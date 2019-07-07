package com.gupao.vip.pattern.proxy.dbroute.db;

/**
 * DynamicDataSourceEntity类
 *
 * @author wangjixue
 * @date 2019-07-07 13:29
 */
public class DynamicDataSourceEntity {

    // 默认数据源
    public static final String DEFAULT_SOURCE = null;

    public static final ThreadLocal<String> local= new ThreadLocal<String>();

    public DynamicDataSourceEntity() {
    }

    /**
     * 清空数据源
     */
    public static void remove(){
        local.remove();
    }

    /**
     * 还原当前切面的数据源
     */
    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    /**
     * 取当前正在使用的数据源名字
     * @return
     */
    public static String get(){
        return local.get();
    }

    /**
     * 设置已知名字的数据源
     * @param source
     */
    public static void  set(String source){
        local.set(source);
    }

    /**
     * 根据年份动态生成数据源
     * @param year
     */
    public static void set(int year){
        local.set("DB_"+year);
    }

}
